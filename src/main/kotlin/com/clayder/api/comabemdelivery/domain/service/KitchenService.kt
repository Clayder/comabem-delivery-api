package com.clayder.api.comabemdelivery.domain.service

import com.clayder.api.comabemdelivery.domain.exception.EntityInUseException
import com.clayder.api.comabemdelivery.domain.exception.EntityNotFoundException
import com.clayder.api.comabemdelivery.domain.model.KitchenModel
import com.clayder.api.comabemdelivery.domain.repository.KitchenRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import java.util.*

@Service
class KitchenService(private val repository: KitchenRepository) {

    fun create(kitchen: KitchenModel): KitchenModel {
        return repository.save(kitchen)
    }

    fun delete(id: Long): Unit {
        try {
            val kitchen: KitchenModel = getById(id)
            repository.delete(kitchen)
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException("kitchen $id cannot be removed as it is in use")
        }
    }

    fun getById(id: Long): KitchenModel {

        val kitchen: Optional<KitchenModel> = repository.findById(id)

        if (kitchen.isEmpty) {
            throw EntityNotFoundException("Kitchen not found.")
        }

        return kitchen.get();
    }


}