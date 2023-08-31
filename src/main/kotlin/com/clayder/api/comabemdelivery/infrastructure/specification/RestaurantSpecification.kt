package com.clayder.api.comabemdelivery.infrastructure.specification

import com.clayder.api.comabemdelivery.domain.model.RestaurantModel
import org.springframework.data.jpa.domain.Specification
import java.math.BigDecimal

class RestaurantSpecification {

    companion object {

        fun withFreeShipping(): Specification<RestaurantModel> {
            return Specification {root, _, builder ->
                builder.equal(root.get<Any>("shippingFee"), BigDecimal.ZERO)
            }
        }

        fun withSimilarName(name: String?): Specification<RestaurantModel> {
            return Specification {root, _, builder ->
                name?.let {
                    builder.like(root.get("name"), "%$name%")
                }
            }
        }
    }
}