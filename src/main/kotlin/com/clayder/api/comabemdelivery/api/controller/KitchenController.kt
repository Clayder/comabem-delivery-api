package com.clayder.api.comabemdelivery.api.controller

import com.clayder.api.comabemdelivery.domain.exception.EntityInUseException
import com.clayder.api.comabemdelivery.domain.exception.EntityNotFoundException
import com.clayder.api.comabemdelivery.domain.model.KitchenModel
import com.clayder.api.comabemdelivery.domain.repository.KitchenRepository
import com.clayder.api.comabemdelivery.domain.service.KitchenService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kitchen")
class KitchenController(private val repository: KitchenRepository, private val service: KitchenService) {

    @GetMapping
    fun list() :List<KitchenModel> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<KitchenModel> {
        return ResponseEntity.ok(service.getById(id))
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody kitchenModel: KitchenModel): KitchenModel {
        return service.create(kitchenModel)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody kitchenUpdate: KitchenModel): ResponseEntity<KitchenModel> {

        val kitchen: KitchenModel = service.getById(id)

        kitchen.name = kitchenUpdate.name

        return ResponseEntity.ok(repository.save(kitchen))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<KitchenModel> {

        try {
            service.delete(id)
        } catch (e: EntityNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        } catch (e: EntityInUseException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }

        return ResponseEntity.noContent().build()
    }
}