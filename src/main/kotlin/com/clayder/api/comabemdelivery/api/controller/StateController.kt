package com.clayder.api.comabemdelivery.api.controller

import com.clayder.api.comabemdelivery.domain.model.StateModel
import com.clayder.api.comabemdelivery.domain.repository.StateRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/state")
class StateController(private val stateRepository: StateRepository) {

    @GetMapping
    fun list(): List<StateModel> {
        return stateRepository.findAll()
    }
}