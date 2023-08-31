package com.clayder.api.comabemdelivery.infrastructure.repository

import com.clayder.api.comabemdelivery.domain.model.RestaurantModel
import com.clayder.api.comabemdelivery.domain.repository.IRestaurantQueryRepository
import com.clayder.api.comabemdelivery.domain.repository.RestaurantRepository
import com.clayder.api.comabemdelivery.infrastructure.specification.RestaurantSpecification.Companion.withFreeShipping
import com.clayder.api.comabemdelivery.infrastructure.specification.RestaurantSpecification.Companion.withSimilarName
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Repository

@Repository
class RestaurantRepositoryImpl(

    @PersistenceContext
    private val manager: EntityManager,

    @Lazy
    private val repository: RestaurantRepository
): IRestaurantQueryRepository {

    override fun findAll(allParams: Map<String, String>): List<RestaurantModel> {

        val builder: CriteriaBuilder = manager.criteriaBuilder

        val criteria: CriteriaQuery<RestaurantModel> = builder.createQuery(RestaurantModel::class.java)
        val root: Root<RestaurantModel> = criteria.from(RestaurantModel::class.java)

        val predicates: ArrayList<Predicate> = ArrayList()
        allParams["name"]?.let{ predicates.add(builder.like(root.get("name"), "%$it%")) }
        allParams["finalShippingFee"]?.let { predicates.add(builder.run { lessThanOrEqualTo(root.get("shippingFee"), it) }) }
        allParams["finalShippingFee"]?.let {predicates.add(builder.run { lessThanOrEqualTo(root.get("shippingFee"), it) })}

        criteria.where(*predicates.toTypedArray())

        return  manager.createQuery(criteria).resultList
    }

    override fun findWithFreeShipping(name: String?): List<RestaurantModel> {
        return repository.findAll(withFreeShipping().and(withSimilarName(name)))
    }
}