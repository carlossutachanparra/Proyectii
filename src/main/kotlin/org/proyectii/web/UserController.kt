package org.proyectii.web

import io.swagger.v3.oas.annotations.Operation
import org.proyectii.application.UserService
import org.proyectii.domain.User
import org.proyectii.web.dto.UserDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {

    @Operation(summary = "List all the created users")
    @GetMapping("/")
    fun getUsers(): List<User> =
        userService.getUsers()

    @Operation(summary = "Gets an user by given id")
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User =
        userService.getUser(id)

    @Operation(summary = "Creates a new user")
    @PostMapping("/")
    fun createUser(@RequestBody user: UserDTO): User =
        userService.createUser(user)

    @Operation(summary = "Deletes an user by given id")
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) =
        userService.deleteUser(id)

    @Operation(summary = "Updates an user")
    @PutMapping("/")
    fun updateUser(@RequestBody user: UserDTO): User =
        userService.updateUser(user)

}
