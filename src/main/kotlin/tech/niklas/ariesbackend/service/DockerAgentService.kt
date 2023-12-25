package tech.niklas.ariesbackend.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import tech.niklas.ariesbackend.db.DockerAgentRepository
import tech.niklas.ariesbackend.db.DockerServiceRepository
import tech.niklas.ariesbackend.exception.AgentDoesntExistException
import tech.niklas.ariesbackend.exception.AgentSaveException
import tech.niklas.ariesbackend.model.DockerAgent
import kotlin.jvm.optionals.getOrElse

@Service
class DockerAgentService(@Autowired private val dockerAgentRepository: DockerAgentRepository) {

    fun getAllAgents(): List<DockerAgent> {
        return dockerAgentRepository.findAll()
    }

    fun getSpecificDockerAgent(agentId: String): DockerAgent {
        return dockerAgentRepository.findById(agentId).getOrElse {
            throw AgentDoesntExistException("The agent with id $agentId does not exist.")
        }
    }

    fun saveDockerAgent(dockerAgent: DockerAgent): DockerAgent {
        return try {
            dockerAgentRepository.save(dockerAgent)
        } catch (ex: Exception) {
            throw AgentSaveException("An exception occured while registering the agent: ${ex.message}")
        }
    }

    fun updateDockerAgent(agentId: String, newAgent: DockerAgent): DockerAgent {
        var existingAgent = dockerAgentRepository.findById(agentId)
            .getOrElse { throw AgentDoesntExistException("The agent with id $agentId does not exist.") }

        existingAgent.agentName = newAgent.agentName
        existingAgent.connectUrl = newAgent.connectUrl
        existingAgent.agentSecret = newAgent.agentSecret

        return try {
            dockerAgentRepository.save(existingAgent)
        } catch (ex: Exception) {
            throw AgentSaveException("An exception occured while updating the agent: ${ex.message}")
        }

    }

}