package com.clayder.api.comabemdelivery.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table


@Entity
@Table(name="kitchen")
data class KitchenModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(nullable = true)
    var name: String,

    @JsonIgnore
    @OneToMany(mappedBy = "kitchen")
    var restaurants: List<RestaurantModel> = ArrayList()

)