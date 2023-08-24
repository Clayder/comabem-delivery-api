package com.clayder.api.comabemdelivery.api.controller

import com.clayder.api.comabemdelivery.domain.model.KitchenModel
import com.clayder.api.comabemdelivery.domain.repository.KitchenRepository
import org.springframework.beans.BeanUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/kitchen")
class KitchenController(private val repository: KitchenRepository ) {

    @GetMapping
    fun list() :List<KitchenModel> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<KitchenModel> {

        val kitchen: Optional<KitchenModel> = repository.findById(id)

        if (kitchen.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.ok(kitchen.get())
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody kitchenModel: KitchenModel): KitchenModel {
        return repository.save(kitchenModel)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody kitchenUpdate: KitchenModel): ResponseEntity<KitchenModel> {

        val kitchen: Optional<KitchenModel> = repository.findById(id)

        if (kitchen.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        kitchen.get().name = kitchenUpdate.name

        return ResponseEntity.ok(repository.save(kitchen.get()))
    }
}