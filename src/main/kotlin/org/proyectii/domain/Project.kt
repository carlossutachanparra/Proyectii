package org.proyectii.domain

import javax.persistence.*

@Entity
@Table(name="project")
data class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0,
    @Column
    val name: String = ""
)