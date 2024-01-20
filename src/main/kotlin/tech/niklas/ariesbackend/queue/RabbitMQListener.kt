package tech.niklas.ariesbackend.queue

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitMQListener {
    @RabbitListener(queues = arrayOf("docker.deploy"))
    fun processMessage(message: String) {
        println("Received message: $message")
    }
}