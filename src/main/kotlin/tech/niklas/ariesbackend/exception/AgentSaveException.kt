package tech.niklas.ariesbackend.exception

import java.lang.Exception

class AgentSaveException: Exception {
    constructor() : super()
    constructor(message: String): super(message)
}
