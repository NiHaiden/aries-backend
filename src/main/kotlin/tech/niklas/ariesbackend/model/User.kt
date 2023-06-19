package tech.niklas.ariesbackend.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import org.hibernate.Hibernate
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        @Column(name = "username")
        @NotNull
        @NotBlank
        val username: String,

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
