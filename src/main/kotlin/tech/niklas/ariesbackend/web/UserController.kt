package tech.niklas.ariesbackend.web

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import tech.niklas.ariesbackend.db.UserRepository
import tech.niklas.ariesbackend.model.User


@RestController
class UserController(private val userRepository: UserRepository) {
    @GetMapping("/users/hello")
    fun userHello(): User {
        return userRepository.save(User(99, "Niklas Haiden"))
    }

    @GetMapping("/users/getall")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }
}