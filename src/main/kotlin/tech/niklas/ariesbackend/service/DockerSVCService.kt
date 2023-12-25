package tech.niklas.ariesbackend.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import tech.niklas.ariesbackend.db.DockerServiceRepository
import tech.niklas.ariesbackend.exception.ServiceDoesntExistException
import tech.niklas.ariesbackend.exception.ServiceSaveException
import tech.niklas.ariesbackend.model.DockerService
import javax.print.Doc
import kotlin.jvm.optionals.getOrElse

/**
 * DockerSVCService is a class that provides CRUD operations for DockerService objects.
 *
 * @param serviceRepository an instance of the DockerServiceRepository interface that is used for accessing the database.
 */
@Service
class DockerSVCService(@Autowired private val serviceRepository: DockerServiceRepository) {

    fun getAll(): List<DockerService> {
        return serviceRepository.findAll()
    }

    fun getSpecificService(serviceId: String): DockerService {
        return serviceRepository.findById(serviceId).getOrElse {
            throw ServiceDoesntExistException("The service with id $serviceId was not found in the database.")
        }
    }

    fun saveService(service: DockerService): DockerService {
        return try {
            serviceRepository.save(service)
        } catch (e: DataIntegrityViolationException) {
            throw ServiceSaveException("The service you are trying to save is violating the data integrity rules.")
        }
    }

    //update method

    fun updateService(serviceId: String, updatedService: DockerService): DockerService {
        val originalService = serviceRepository.findById(serviceId).orElseThrow {
            ServiceDoesntExistException("The service with id $serviceId was not found in the database.")
        }
        originalService.serviceName = updatedService.serviceName
        originalService.serviceType = updatedService.serviceType
        originalService.serviceMachine = updatedService.serviceMachine
        return serviceRepository.save(originalService)

    }
}