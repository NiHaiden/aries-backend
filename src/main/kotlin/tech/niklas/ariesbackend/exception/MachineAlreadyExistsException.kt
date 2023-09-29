package tech.niklas.ariesbackend.exception

import java.lang.Exception

class MachineAlreadyExistsException: Exception {
    constructor() : super()
    constructor(message: String): super(message)
}