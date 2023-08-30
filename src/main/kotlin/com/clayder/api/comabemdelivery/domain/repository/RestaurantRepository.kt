package com.clayder.api.comabemdelivery.domain.repository

import com.clayder.api.comabemdelivery.domain.model.RestaurantModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RestaurantRepository: JpaRepository<RestaurantModel, Long>, IRestaurantQueryRepository {

    @Query("FROM RestaurantModel WHERE name LIKE %:name% AND kitchen.id = :id")
    fun findRestaurantsByName(name: String, @Param("id") kitchenId: Long): List<RestaurantModel>
}