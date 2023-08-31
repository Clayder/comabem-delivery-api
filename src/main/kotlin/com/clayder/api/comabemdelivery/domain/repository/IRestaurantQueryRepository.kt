package com.clayder.api.comabemdelivery.domain.repository

import com.clayder.api.comabemdelivery.domain.model.RestaurantModel

interface IRestaurantQueryRepository {

    fun findAll(allParams: Map<String, String>): List<RestaurantModel>
    fun findWithFreeShipping(name: String?): List<RestaurantModel>
}