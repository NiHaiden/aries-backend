package tech.niklas.ariesbackend.service

import tech.niklas.ariesbackend.db.DockerMachineRepository
import tech.niklas.ariesbackend.exception.MachineAlreadyExistsException
import tech.niklas.ariesbackend.model.DockerMachine
import kotlin.jvm.optionals.getOrElse

class DockerMachineService(private val dockerMachineRepository: DockerMachineRepository,
                           private val dockerMachineService: DockerMachineService) {


    fun registerNew(dockerMachine: DockerMachine): DockerMachine {
        if(dockerMachineRepository.existsByMachineName(dockerMachine.machineName) ) {
            throw MachineAlreadyExistsException("The machine ${dockerMachine.machineName} already exists in the database!")
        }
        return dockerMachineRepository.save(dockerMachine)
    }

    fun getAll(): List<DockerMachine> {
        return dockerMachineRepository.findAll()
    }

    fun getSpecificMachine(id: String): DockerMachine {
        return dockerMachineRepository.findById(id).getOrElse {
            throw MachineAlreadyExistsException("not found lol")
        }
    }

    fun deleteMachine(id: String): String {
        dockerMachineRepository.deleteById(id)
        return "Deleted machine with id $id"
    }

}