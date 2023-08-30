package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.*

@Entity
@Table(name = "type_payment")
data class TypePaymentModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(nullable = false)
    var description: String,
)