package com.clayder.api.comabemdelivery.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

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
    var kitchen: KitchenModel,

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "restaurant_type_payment",
        joinColumns = [JoinColumn(name = "restaurant_id")],
        inverseJoinColumns = [JoinColumn(name = "type_payment_id")]
    )
    var typePayment: List<TypePaymentModel> = ArrayList(),

    @JsonIgnore
    @Embedded
    var addressModel: AddressModel,

    @JsonIgnore
    @CreationTimestamp
    @Column(nullable = false)
    var createdAt: LocalDateTime,

    @JsonIgnore
    @UpdateTimestamp
    @Column(nullable = false)
    var updatedAt: LocalDateTime,
)