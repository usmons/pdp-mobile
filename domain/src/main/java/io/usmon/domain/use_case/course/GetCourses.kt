package io.usmon.domain.use_case.course

import io.usmon.domain.repository.course.Course
import io.usmon.domain.repository.course.CourseRepository
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

class GetCourses(
    private val repository: CourseRepository,
) {
    operator fun invoke(): Flow<List<Course>> = repository.getCourses()
}