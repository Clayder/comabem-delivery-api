package com.clayder.api.comabemdelivery.domain.service

import com.clayder.api.comabemdelivery.domain.exception.EntityCanNotUpdatedException
import com.clayder.api.comabemdelivery.domain.exception.EntityInUseException
import com.clayder.api.comabemdelivery.domain.exception.EntityNotFoundException
import com.clayder.api.comabemdelivery.domain.model.CityModel
import com.clayder.api.comabemdelivery.domain.model.StateModel
import com.clayder.api.comabemdelivery.domain.repository.CityRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class CityService(private val repository: CityRepository, private val stateService: StateService) {

    fun findAll(): List<CityModel> {
        return repository.findAll()
    }

    fun getById(id: Long): CityModel {
        val model = repository.findById(id)

        if(model.isEmpty) {
            throw EntityNotFoundException("State $id not found.")
        }

        return model.get()
    }

    fun create(newModel: CityModel): CityModel {
        return repository.save(newModel)
    }

    fun update(updateModel: CityModel, id: Long): CityModel {

        var state: StateModel

        try {
            state = stateService.getById(updateModel.state.id)
        } catch (e: EntityNotFoundException) {
            throw EntityCanNotUpdatedException("State not registered")
        }

        val model = getById(id)

        updateModel.id = model.id
        updateModel.state = state

        return repository.save(updateModel)
    }

    fun delete(id: Long): Unit {

        try {
            repository.deleteById(id)
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException("City $id cannot be removed as it is in use")
        }
    }
}