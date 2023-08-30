package com.clayder.api.comabemdelivery.infrastructure.repository

import com.clayder.api.comabemdelivery.domain.model.RestaurantModel
import com.clayder.api.comabemdelivery.domain.repository.IRestaurantQueryRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.stereotype.Repository

@Repository
class RestaurantRepositoryImpl(

    @PersistenceContext
    private val manager: EntityManager
): IRestaurantQueryRepository {

    override fun findAll2(allParams: Map<String, String>): List<RestaurantModel> {

        val builder: CriteriaBuilder = manager.criteriaBuilder

        val criteria: CriteriaQuery<RestaurantModel> = builder.createQuery(RestaurantModel::class.java)
        val root: Root<RestaurantModel> = criteria.from(RestaurantModel::class.java)

        val predicates: ArrayList<Predicate> = ArrayList()

        if (allParams.containsKey("name")) {
            predicates.add(builder.like(root.get("name"), "%${allParams["name"]}%"))
        }

        if (allParams.containsKey("finalShippingFee")) {
            predicates.add(builder.run { lessThanOrEqualTo(root.get("shippingFee"), allParams["finalShippingFee"] ?: "0") })
        }

        if (allParams.containsKey("initShippingFee")) {
            predicates.add(builder.run { lessThanOrEqualTo(root.get("shippingFee"), allParams["initShippingFee"] ?: "0") })
        }

        criteria.where(*predicates.toTypedArray())
        val query: TypedQuery<RestaurantModel> = manager.createQuery(criteria)

        return query.resultList
    }
}