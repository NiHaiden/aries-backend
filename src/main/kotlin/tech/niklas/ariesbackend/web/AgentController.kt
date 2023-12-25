package tech.niklas.ariesbackend.web

import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.niklas.ariesbackend.model.DockerAgent
import tech.niklas.ariesbackend.service.DockerAgentService

@RestController
@RequestMapping("/agent")
class AgentController(@Autowired private val dockerAgentService: DockerAgentService) {
    @GetMapping("get/all")
    fun getAllAgents(): List<DockerAgent> {
        return dockerAgentService.getAllAgents()
    }

    @GetMapping("get/{id}")
    fun getSpecificAgent(@PathVariable agentId: String): DockerAgent {
        return dockerAgentService.getSpecificDockerAgent(agentId)
    }

    @PostMapping("/new")
    fun registerNewAgent(@Valid @RequestBody @NotEmpty dockerAgent: DockerAgent): DockerAgent {
        return dockerAgentService.saveDockerAgent(dockerAgent)
    }

}