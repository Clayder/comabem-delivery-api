package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name="restaurant")
data class Restaurantmodel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String,
    var shippingFee: BigDecimal
)