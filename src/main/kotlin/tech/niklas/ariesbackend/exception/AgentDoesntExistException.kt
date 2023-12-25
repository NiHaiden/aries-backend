package tech.niklas.ariesbackend.exception

import java.lang.Exception

class AgentDoesntExistException: Exception {
    constructor() : super()
    constructor(message: String): super(message)
}
