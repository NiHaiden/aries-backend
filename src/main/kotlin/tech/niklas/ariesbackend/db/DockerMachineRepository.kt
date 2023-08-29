package tech.niklas.ariesbackend.db;

import org.springframework.data.jpa.repository.JpaRepository
import tech.niklas.ariesbackend.model.DockerMachine

interface DockerMachineRepository : JpaRepository<DockerMachine, String> {
     fun existsByMachineName(machineName: String): Boolean
}