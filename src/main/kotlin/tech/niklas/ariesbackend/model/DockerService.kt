package tech.niklas.ariesbackend.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.Hibernate
import tech.niklas.ariesbackend.model.types.ServiceType

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "serviceType", discriminatorType = DiscriminatorType.STRING)
open class DockerService protected constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val serviceID : String?,

    @NotBlank
    @NotNull
    @Column(name = "serviceName")
    val serviceName : String,

    @NotNull
    val serviceType : ServiceType,

    //On which machine does the service run?
    @NotNull
    @ManyToOne
    @JoinColumn(name = "machineID")
    val serviceMachine: DockerMachine

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as DockerService

        return serviceID != null && serviceID == other.serviceID
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(serviceID = $serviceID , serviceName = $serviceName , serviceType = $serviceType , serviceMachine = $serviceMachine )"
    }
}
