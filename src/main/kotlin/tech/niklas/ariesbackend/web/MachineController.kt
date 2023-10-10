package tech.niklas.ariesbackend.web

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import tech.niklas.ariesbackend.db.DockerMachineRepository
import tech.niklas.ariesbackend.exception.MachineAlreadyExistsException
import tech.niklas.ariesbackend.model.DockerMachine
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/machine")
class MachineController(private val dockerMachineRepository: DockerMachineRepository) {
    @PostMapping("/registernew")
    fun registerNew(@RequestBody dockerMachine: DockerMachine): DockerMachine {
        if(dockerMachineRepository.existsByMachineName(dockerMachine.machineName) ) {
            throw MachineAlreadyExistsException("The machine ${dockerMachine.machineName} already exists in the database!")
        }
        return dockerMachineRepository.save(dockerMachine)
    }

    @GetMapping("/get")
    fun getAll(): List<DockerMachine> {
        return dockerMachineRepository.findAll()
    }

    @GetMapping("/get/{id}")
    fun getSpecificMachine(@PathVariable id: String): DockerMachine {
        return dockerMachineRepository.findById(id).getOrElse {
            throw MachineAlreadyExistsException("not found lol")
        }
    }


}