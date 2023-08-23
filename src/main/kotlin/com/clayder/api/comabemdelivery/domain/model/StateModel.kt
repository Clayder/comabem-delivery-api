package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.*

@Entity
@Table(name = "state")
data class StateModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(nullable = false)
    var name: String,
)