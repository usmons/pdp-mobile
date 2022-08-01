package io.usmon.domain.use_case.course

import io.usmon.domain.repository.course.Course
import io.usmon.domain.repository.course.CourseRepository

// Created by Usmon Abdurakhmanv on 7/31/2022.

class GetCourseByName(
    private val repository: CourseRepository,
) {
    suspend operator fun invoke(courseName: String): Course? {
        if (courseName.isBlank()) {
            return null
        }
        return repository.getCourseByName(courseName)
    }
}