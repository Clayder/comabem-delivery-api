package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Embeddable
data class AddressModel(

    @Column(name = "address_zipcode")
    var zipCode: String,

    @Column(name = "address_address1")
    var address1: String,

    @Column(name = "address_address2")
    var address2: String,

    @Column(name = "address_number")
    var number: String,

    @Column(name = "address_neighborhood")
    var neighborhood: String,

    @field:ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_city_id")
    var city: CityModel
)