package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.*

@Entity
@Table(name = "permission")
data class PermissionModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var description: String
)