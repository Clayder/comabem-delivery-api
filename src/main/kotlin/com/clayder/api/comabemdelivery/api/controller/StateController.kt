package com.clayder.api.comabemdelivery.api.controller

import com.clayder.api.comabemdelivery.domain.exception.EntityCanNotUpdatedException
import com.clayder.api.comabemdelivery.domain.exception.EntityInUseException
import com.clayder.api.comabemdelivery.domain.exception.EntityNotFoundException
import com.clayder.api.comabemdelivery.domain.model.StateModel
import com.clayder.api.comabemdelivery.domain.service.StateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/state")
class StateController(private val service: StateService) {

    @GetMapping
    fun getAll(): List<StateModel> {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<StateModel> {
        return try {
            val model = service.getById(id)
            ResponseEntity.ok(model)
        } catch (e: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun create(@RequestBody newModel: StateModel): ResponseEntity<StateModel> {
        return try {
            val modelCreated = service.create(newModel)
            ResponseEntity.status(HttpStatus.CREATED).body(modelCreated)
        } catch (e: EntityNotFoundException) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    fun update(@RequestBody updateModel: StateModel, @PathVariable id: Long): ResponseEntity<StateModel> {
        return try {
            val modelUpdated: StateModel = service.update(updateModel, id)
            ResponseEntity.ok(modelUpdated)
        } catch (e: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        } catch (e: EntityCanNotUpdatedException) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<StateModel> {
        return try {
            service.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        } catch (e: EntityInUseException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
    }
}