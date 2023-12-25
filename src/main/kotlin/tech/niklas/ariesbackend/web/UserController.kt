package tech.niklas.ariesbackend.web

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.niklas.ariesbackend.db.UserRepository


@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {
    @GetMapping("/getuserinfo")
    fun userinfo(): Map<String, Any> {
        val authenticationToken: Authentication = SecurityContextHolder.getContext().authentication
        lateinit var attributes: Map<String, Any>
        if (authenticationToken is JwtAuthenticationToken) {
            attributes = authenticationToken.tokenAttributes
        }
        return attributes
    }

}