package com.clayder.api.comabemdelivery.infrastructure.specification

import com.clayder.api.comabemdelivery.domain.model.RestaurantModel
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification
import java.math.BigDecimal

class RestaurantFreeShippingSpec: Specification<RestaurantModel> {

    override fun toPredicate(
        root: Root<RestaurantModel>,
        query: CriteriaQuery<*>,
        builder: CriteriaBuilder
    ): Predicate? {
        return builder.equal(root.get<Any>("shippingFee"), BigDecimal.ZERO)
    }
}