package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "product")
data class ProductModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var name: String,

    var description: String,

    var price: Double,

    var active: Boolean,

    @ManyToOne
    var restaurant: RestaurantModel
)
