package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name="restaurant")
data class RestaurantModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(nullable = false)
    var name: String,

    @Column(name="shipping_fee", nullable = false)
    var shippingFee: BigDecimal,

    @ManyToOne
    var kitchen: KitchenModel
)