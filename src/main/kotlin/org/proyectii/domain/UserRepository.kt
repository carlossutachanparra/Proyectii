package org.proyectii.domain

import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository: JpaRepository<User,Long> {

}