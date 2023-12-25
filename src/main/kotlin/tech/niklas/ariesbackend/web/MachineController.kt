package tech.niklas.ariesbackend.web

import jakarta.validation.constraints.NotBlank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import tech.niklas.ariesbackend.model.DockerMachine
import tech.niklas.ariesbackend.service.DockerMachineService

@RestController
@RequestMapping("/machine")
class MachineController(@Autowired private val dockerMachineService: DockerMachineService) {
    @PostMapping("/new")
    fun newMachine(@RequestBody dockerMachine: DockerMachine): DockerMachine {
        return dockerMachineService.registerNew(dockerMachine)
    }

    @GetMapping("/get")
    fun getAll(): List<DockerMachine> {
        return dockerMachineService.getAll()
    }

    @GetMapping("/get/{id}")
    fun getSpecificMachine(@PathVariable id: String): DockerMachine {
        return dockerMachineService.getSpecificMachine(id)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteMachine(@PathVariable id: String): String {
        return dockerMachineService.deleteMachine(id)
    }

    @GetMapping("/exists/{id}")
    fun machineExists(@NotBlank @PathVariable id: String): Boolean {
        return dockerMachineService.machineExists(id)
    }

    @PatchMapping("/update/{id}")
    fun updateMachine(@PathVariable @NotBlank id: String, @RequestBody dockerMachine: DockerMachine): DockerMachine {

        return dockerMachineService.updateMachine(id, dockerMachine)
    }
}