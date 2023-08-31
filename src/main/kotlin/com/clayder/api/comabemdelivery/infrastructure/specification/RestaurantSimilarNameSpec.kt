package com.clayder.api.comabemdelivery.infrastructure.specification

import com.clayder.api.comabemdelivery.domain.model.RestaurantModel
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification
import java.util.*

class RestaurantSimilarNameSpec(private val name: Optional<String>): Specification<RestaurantModel> {

    override fun toPredicate(
        root: Root<RestaurantModel>,
        query: CriteriaQuery<*>,
        builder: CriteriaBuilder
    ): Predicate? {

        if (!name.isEmpty) {
            return builder.like(root.get("name"), "%${name.get()}%")
        }
        return null
    }
}