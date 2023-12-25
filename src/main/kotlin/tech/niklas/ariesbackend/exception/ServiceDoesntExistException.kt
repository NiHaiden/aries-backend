package tech.niklas.ariesbackend.exception

import java.lang.Exception

class ServiceDoesntExistException: Exception {
    constructor() : super()
    constructor(message: String): super(message)
}
