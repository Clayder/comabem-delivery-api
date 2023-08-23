package com.clayder.api.comabemdelivery.api.controller

import com.clayder.api.comabemdelivery.domain.model.KitchenModel
import com.clayder.api.comabemdelivery.domain.repository.KitchenRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kitchen")
class KitchenController(private val repository: KitchenRepository ) {

    @GetMapping
    fun list() :List<KitchenModel> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): KitchenModel{
        return repository.findById(id).orElseGet(null)
    }
}