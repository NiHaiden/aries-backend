package tech.niklas.ariesbackend.exception

import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.lang.Exception

@ControllerAdvice
class CentralExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, rq: WebRequest): ResponseEntity<String> {
        return ResponseEntity<String>(ex.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MachineAlreadyExistsException::class)
    fun handleMachineAlreadyExistsEx(ex: MachineAlreadyExistsException, rq: WebRequest): ResponseEntity<String> {
        return ResponseEntity<String>(ex.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ServiceAlreadyExistsException::class)
    fun handleServiceAlreadyExistsEx(ex: ServiceAlreadyExistsException, rq: WebRequest): ResponseEntity<String> {
        return ResponseEntity<String>(ex.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ServiceDoesntExistException::class)
    fun handleServiceAlreadyExistsEx(ex: ServiceDoesntExistException, rq: WebRequest): ResponseEntity<String> {
        return ResponseEntity<String>(ex.message, HttpStatus.NOT_FOUND)
    }
}