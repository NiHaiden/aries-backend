package tech.niklas.ariesbackend.model.types

enum class ServiceType(val serviceType: String) {
    DATABASE("database"),
    APP("application"),
    WEBSITE("website")
}