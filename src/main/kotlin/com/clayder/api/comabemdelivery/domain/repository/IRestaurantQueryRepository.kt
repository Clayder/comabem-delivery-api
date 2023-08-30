package com.clayder.api.comabemdelivery.domain.repository

import com.clayder.api.comabemdelivery.domain.model.RestaurantModel

interface IRestaurantQueryRepository {

    fun findAll2(allParams: Map<String, String>): List<RestaurantModel>
}