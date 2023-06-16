package tech.niklas.ariesbackend.db

import org.springframework.data.jpa.repository.JpaRepository
import tech.niklas.ariesbackend.model.User

interface UserRepository : JpaRepository<User, Long> {

}