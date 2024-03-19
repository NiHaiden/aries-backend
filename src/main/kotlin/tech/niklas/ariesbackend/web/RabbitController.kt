package tech.niklas.ariesbackend.web

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.niklas.ariesbackend.model.DockerAgent

@RestController
@RequestMapping("/rabbit")
class RabbitController(@Autowired private val rabbitTemplate: RabbitTemplate,
    @Autowired private val queue: Queue) {

    @GetMapping("/test")
    fun sendMessage(): String {
        val message: String = "Hello Rabbit!"
        val objectMapper: ObjectMapper = ObjectMapper()
        val dockerAgent: DockerAgent = DockerAgent("xxx", "machine1", "secret123", "secret.aries.dev")
        rabbitTemplate.convertAndSend(queue.name, objectMapper.writeValueAsString(dockerAgent))
        return "Message sent successfully!"
    }
}