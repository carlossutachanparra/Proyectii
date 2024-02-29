package org.proyectii.application

import org.proyectii.domain.Project
import org.proyectii.domain.ProjectRepository
import org.proyectii.web.dto.ProjectDTO
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProjectService (
    private val projectRepository: ProjectRepository
) {
    fun getProjects(): List<Project> =
        projectRepository.findAll()

    fun getProject(id:Long): Project =
        projectRepository.findByIdOrNull(id) ?: error("No project with id $id")

    fun createProject(project: ProjectDTO): Project =
        projectRepository.save(Project(name = project.name))

    fun deleteProject(id:Long) =
        projectRepository.deleteById(id)

    fun updateProject(project: ProjectDTO): Project {
        val currentProject = project.id?.let { getProject(it) } ?: error("project id must be defined")
        val updatedProject = currentProject.copy(
            name = project.name
        )
        return projectRepository.save(updatedProject)
    }
}