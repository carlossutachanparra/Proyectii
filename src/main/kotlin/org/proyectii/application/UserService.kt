package org.proyectii.application

import org.proyectii.domain.User
import org.proyectii.domain.UserRepository
import org.proyectii.web.dto.UserCreateDTO
import org.proyectii.web.dto.UserDTO
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getUsers(): List<User> =
        userRepository.findAll()

    fun getUser(id: Long): User =
        userRepository.findByIdOrNull(id) ?: error("No user with id $id")

    fun createUser(user: UserCreateDTO): User =
        userRepository.save(
            User(
                name = user.name,
                email = user.email,
                password = user.password
            )
        )

    fun deleteUser(id: Long) =
        userRepository.deleteById(id)

    fun updateUser(user: UserDTO): User {
        val currentUser = user.id?.let { getUser(it) } ?: error("User id must be defined")
        val updatedUser = currentUser.copy(
            name = user.name
        )
        return userRepository.save(updatedUser)
    }


}
