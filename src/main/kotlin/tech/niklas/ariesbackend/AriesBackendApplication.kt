package tech.niklas.ariesbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AriesBackendApplication

fun main(args: Array<String>){
    runApplication<AriesBackendApplication>(*args)
}
