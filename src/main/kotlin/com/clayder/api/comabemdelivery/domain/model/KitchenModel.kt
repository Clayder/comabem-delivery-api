package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.*

@Entity
@Table(name="kitchen")
data class KitchenModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String
)