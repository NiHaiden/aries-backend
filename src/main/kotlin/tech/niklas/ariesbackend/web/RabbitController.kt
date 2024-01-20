package tech.niklas.ariesbackend.web

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rabbit")
class RabbitController(@Autowired private val rabbitTemplate: RabbitTemplate,
    @Autowired private val queue: Queue) {

    @GetMapping("/test")
    fun sendMessage(): String {
        val message: String = "Hello Rabbit!"
        rabbitTemplate.convertAndSend(queue.name, message)
        return "Message sent successfully!"
    }
}