package tech.niklas.ariesbackend.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import tech.niklas.ariesbackend.db.DockerMachineRepository
import tech.niklas.ariesbackend.exception.MachineAlreadyExistsException
import tech.niklas.ariesbackend.model.DockerMachine

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


}