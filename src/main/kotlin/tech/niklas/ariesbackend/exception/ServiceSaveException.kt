package tech.niklas.ariesbackend.exception

import java.lang.Exception

class ServiceSaveException: Exception {
    constructor() : super()
    constructor(message: String): super(message)
}
