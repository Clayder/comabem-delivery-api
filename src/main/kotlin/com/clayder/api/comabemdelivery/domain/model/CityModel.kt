package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.*

@Entity
@Table(name = "city")
data class CityModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(nullable = false)
    var name: String,

    @ManyToOne
    var state: StateModel
)