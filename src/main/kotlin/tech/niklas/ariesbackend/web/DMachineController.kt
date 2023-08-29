package tech.niklas.ariesbackend.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import tech.niklas.ariesbackend.db.DockerMachineRepository
import tech.niklas.ariesbackend.model.DockerMachine

@RestController
@RequestMapping("/machine")
class DMachineController(private val dockerMachineRepository: DockerMachineRepository) {
    @PostMapping("/registernew")
    fun registerNew(@RequestBody dockerMachine: DockerMachine): DockerMachine {
        if(dockerMachineRepository.existsByMachineName(dockerMachine.machineName) ) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "That machine already exists!", IllegalArgumentException("Illegal argument!"))
        }
        return dockerMachineRepository.save(dockerMachine)
    }


}