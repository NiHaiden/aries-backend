package tech.niklas.ariesbackend.exception

import java.lang.Exception

class ServiceAlreadyExistsException: Exception {
    constructor() : super()
    constructor(message: String): super(message)
}
