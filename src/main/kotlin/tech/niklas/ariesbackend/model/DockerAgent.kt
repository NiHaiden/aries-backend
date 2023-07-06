package tech.niklas.ariesbackend.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.Hibernate

@Entity
@Table(name = "dockeragents")
data class DockerAgent (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val agentUUID : String?,

    @NotBlank
    @NotNull
    @Column(name = "agentname")
    val agentName : String,

    @NotBlank
    @NotNull
    @Column(name = "agentsecret")
    val agentSecret: String



) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as DockerAgent

        return agentUUID != null && agentUUID == other.agentUUID
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(agentUUID = $agentUUID , agentName = $agentName , agentSecret = $agentSecret )"
    }

}
