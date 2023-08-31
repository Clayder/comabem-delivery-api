package com.clayder.api.comabemdelivery.domain.service

import com.clayder.api.comabemdelivery.domain.exception.EntityCanNotUpdatedException
import com.clayder.api.comabemdelivery.domain.exception.EntityNotFoundException
import com.clayder.api.comabemdelivery.domain.model.KitchenModel
import com.clayder.api.comabemdelivery.domain.model.RestaurantModel
import com.clayder.api.comabemdelivery.domain.repository.RestaurantRepository
import org.springframework.stereotype.Service

@Service
class RestaurantService(private val repository: RestaurantRepository, private val kitchenService: KitchenService) {

    fun findAll(allParams: Map<String, String>): List<RestaurantModel> {
        return repository.findAll(allParams)
    }

    fun findAll(): List<RestaurantModel> {
        return repository.findAll()
    }

    fun findAll(name: String?): List<RestaurantModel> {
        return repository.findWithFreeShipping(name)
    }

    fun getById(id: Long): RestaurantModel {
        val restaurant = repository.findById(id)

        if (restaurant.isEmpty) {
            throw EntityNotFoundException("Restaurant $id not found")
        }

        return restaurant.get()
    }

    fun create(restaurantModel: RestaurantModel): RestaurantModel {

        val kitchen: KitchenModel = kitchenService.getById(restaurantModel.kitchen.id)

        restaurantModel.kitchen = kitchen

        return repository.save(restaurantModel)
    }

    fun update(updateRestaurant: RestaurantModel, id: Long): RestaurantModel {

        val kitchen: KitchenModel

        try {
            kitchen = kitchenService.getById(updateRestaurant.kitchen.id)
        } catch (e: EntityNotFoundException) {
            throw EntityCanNotUpdatedException("Kitchen not registered")
        }

        val restaurant = getById(id)

        updateRestaurant.id = restaurant.id
        updateRestaurant.kitchen = kitchen

        return repository.save(updateRestaurant)
    }

    fun delete(id: Long): Unit {
        repository.deleteById(id)
    }
}