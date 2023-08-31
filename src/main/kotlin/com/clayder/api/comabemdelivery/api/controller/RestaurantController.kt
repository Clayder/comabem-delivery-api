package com.clayder.api.comabemdelivery.api.controller

import com.clayder.api.comabemdelivery.domain.exception.EntityCanNotUpdatedException
import com.clayder.api.comabemdelivery.domain.exception.EntityInUseException
import com.clayder.api.comabemdelivery.domain.exception.EntityNotFoundException
import com.clayder.api.comabemdelivery.domain.model.RestaurantModel
import com.clayder.api.comabemdelivery.domain.service.RestaurantService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restaurant")
class RestaurantController(private val service: RestaurantService) {

    @GetMapping
    fun getAll(@RequestParam allParams: Map<String, String>): List<RestaurantModel> {
        return service.findAll(allParams)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<RestaurantModel> {
        return try {
            val restaurant = service.getById(id)
            ResponseEntity.ok(restaurant)
        } catch (e: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun create(@RequestBody newRestaurantModel: RestaurantModel): ResponseEntity<RestaurantModel> {
        return try {
            val newRestaurant = service.create(newRestaurantModel)
            ResponseEntity.status(HttpStatus.CREATED).body(newRestaurant)
        } catch (e: EntityNotFoundException) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    fun update(@RequestBody updateRestaurant: RestaurantModel, @PathVariable id: Long): ResponseEntity<RestaurantModel> {
        return try {
            val updatedRestaurant: RestaurantModel = service.update(updateRestaurant, id)
            ResponseEntity.ok(updatedRestaurant)
        } catch (e: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        } catch (e: EntityCanNotUpdatedException) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<RestaurantModel> {
        return try {
            service.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        } catch (e: EntityInUseException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
    }

    @GetMapping("/free-shipping")
    fun freeShipping(@RequestParam name: String?): List<RestaurantModel> {
        return service.findAll(name)
    }
}