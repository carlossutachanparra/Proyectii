package org.proyectii.web

import io.swagger.v3.oas.annotations.Operation
import org.proyectii.application.ProjectService
import org.proyectii.domain.Project
import org.proyectii.web.dto.ProjectDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/projects")
class ProjectController(
    val projectService: ProjectService
) {

    @Operation(summary = "List all the created projects")
    @GetMapping("/")
    fun getProjects(): List<Project> =
        projectService.getProjects()

    @Operation(summary = "Gets a project by given id")
    @GetMapping("/{id}")
    fun getProject(@PathVariable id: Long): Project =
        projectService.getProject(id)

    @Operation(summary = "Creates a new project")
    @PostMapping("/")
    fun createProject(@RequestBody project: ProjectDTO): Project =
        projectService.createProject(project)

    @Operation(summary = "Deletes a project by given id")
    @DeleteMapping("/{id}")
    fun deleteProject(@PathVariable id: Long) =
        projectService.deleteProject(id)

    @Operation(summary = "Updates a project")
    @PutMapping("/")
    fun updateProject(@RequestBody project: ProjectDTO): Project =
        projectService.updateProject(project)

}
