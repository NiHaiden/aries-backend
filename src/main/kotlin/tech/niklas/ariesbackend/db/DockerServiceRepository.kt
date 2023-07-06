package tech.niklas.ariesbackend.db;

import org.springframework.data.jpa.repository.JpaRepository
import tech.niklas.ariesbackend.model.DockerService

interface DockerServiceRepository : JpaRepository<DockerService, String> {
}