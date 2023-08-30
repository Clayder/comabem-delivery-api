package com.clayder.api.comabemdelivery.domain.service

import com.clayder.api.comabemdelivery.domain.exception.EntityInUseException
import com.clayder.api.comabemdelivery.domain.exception.EntityNotFoundException
import com.clayder.api.comabemdelivery.domain.model.StateModel
import com.clayder.api.comabemdelivery.domain.repository.StateRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class StateService(private val repository: StateRepository) {

    fun findAll(): List<StateModel> {
        return repository.findAll()
    }

    fun getById(id: Long): StateModel {
        val model = repository.findById(id)

        if(model.isEmpty) {
            throw EntityNotFoundException("State $id not found.")
        }

        return model.get()
    }

    fun create(newModel: StateModel): StateModel {
        return repository.save(newModel)
    }

    fun update(updateModel: StateModel, id: Long): StateModel {
        val model = getById(id)
        updateModel.id = model.id
        return repository.save(updateModel)
    }

    fun delete(id: Long): Unit {
        try {
            repository.deleteById(id)
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException("State $id cannot be removed as it is in use")
        }
    }
}