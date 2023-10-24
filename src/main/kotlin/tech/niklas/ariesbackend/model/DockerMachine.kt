package tech.niklas.ariesbackend.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.Hibernate

@Entity
@Table(name = "dockermachines")
data class DockerMachine(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val machineID: String,

        @NotBlank
        @NotNull
        @Column(name = "machineName")
        val machineName: String,

        @NotBlank
        @NotNull
        @Column(name = "machineHostname")
        val machineHostname: String,

        // the reported linux kernel version by the agent
        @Column(name = "machineKernel")
        val machineKernel: String,

        // the reported linux distro
        @NotBlank
        @NotNull
        @Column(name = "machineDistro")
        val machineDistro: String,

        @NotBlank
        @NotNull
        @Column(name = "machineConnectUrl")
        val machineConnectUrl: String

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as DockerMachine

        return machineID == other.machineID
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(machineName = $machineName , machineHostname = $machineHostname , machineKernel = $machineKernel , machineDistro = $machineDistro , machineConnectUrl = $machineConnectUrl )"
    }

}
