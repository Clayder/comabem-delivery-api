package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name="order_item")
data class OrderItemModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(nullable = false)
    var quantity: Int,

    @Column(nullable = false)
    var unitPrice: Double,

    @Column(nullable = false)
    var totalPrice: Double,

    var observation: String,

    @field:ManyToOne(optional = false, fetch = FetchType.LAZY)
    var order: OrderModel,

    @field:ManyToOne(optional = false, fetch = FetchType.LAZY)
    var product: ProductModel
)
