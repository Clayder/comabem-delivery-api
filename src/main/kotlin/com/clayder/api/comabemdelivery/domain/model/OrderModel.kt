package com.clayder.api.comabemdelivery.domain.model

import com.clayder.api.comabemdelivery.domain.OrderStatusEnum
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name="order")
data class OrderModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(nullable = false)
    var subTotal: Double,

    @Column(nullable = false)
    var shippingFee: Double,

    @Column(nullable = false)
    var amount: Double,

    @Column(nullable = false)
    var createdAt: LocalDateTime,

    @field:OneToMany(mappedBy = "order")
    var orderItem: List<OrderItemModel> = ArrayList(),

    @Column(nullable = false)
    var status: OrderStatusEnum,

    @JsonIgnore
    @Embedded
    var address: AddressModel,

    var confirmationDate: LocalDateTime,
    var cancellationDate: LocalDateTime,
    var deliveryDate: LocalDateTime,
)