package io.usmon.domain.use_case.course

import io.usmon.domain.repository.course.Course
import io.usmon.domain.repository.course.CourseRepository
import io.usmon.domain.util.Resource
import io.usmon.domain.util.SimpleResource

// Created by Usmon Abdurakhmanv on 7/31/2022.

class InsertCourse(
    private val repository: CourseRepository,
) {
    suspend operator fun invoke(course: Course): SimpleResource {
        if (course.name.isBlank()) {
            return Resource.failure("Course name couldn't be empty")
        }
        if (course.description.isBlank()) {
            return Resource.failure("Course description couldn't be empty")
        }
        val courseNameAlreadyInUse = repository.isCourseNameAlreadyInUse(courseName = course.name)
        if (courseNameAlreadyInUse) {
            return Resource.failure("Course name already in use")
        }
        return repository.insertCourse(course)
    }
}