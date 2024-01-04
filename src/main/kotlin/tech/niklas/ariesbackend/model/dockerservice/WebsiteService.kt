package tech.niklas.ariesbackend.model.dockerservice

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import tech.niklas.ariesbackend.model.DockerMachine
import tech.niklas.ariesbackend.model.DockerService
import tech.niklas.ariesbackend.model.types.DatabaseType
import tech.niklas.ariesbackend.model.types.ServiceType

@Entity
@DiscriminatorValue("website-service")
class WebsiteService(
    serviceID: String?,
    serviceName: String,
    serviceType: ServiceType,
    serviceMachine: DockerMachine,
    serviceUrl: String
)
 : DockerService(serviceID, serviceName, serviceType, serviceMachine)
