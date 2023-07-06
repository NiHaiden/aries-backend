package tech.niklas.ariesbackend.model.dockerservice

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import tech.niklas.ariesbackend.model.DockerMachine
import tech.niklas.ariesbackend.model.DockerService
import tech.niklas.ariesbackend.model.types.DatabaseType
import tech.niklas.ariesbackend.model.types.ServiceType

@Entity
@DiscriminatorValue("database-service")
class DatabaseService(
    serviceID: String?,
    serviceName: String,
    serviceType: ServiceType,
    serviceMachine: DockerMachine,
    databaseType: DatabaseType
) : DockerService(serviceID, serviceName, serviceType, serviceMachine)
