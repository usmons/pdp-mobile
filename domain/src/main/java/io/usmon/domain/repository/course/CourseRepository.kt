package io.usmon.domain.repository.course

import io.usmon.domain.util.SimpleResource
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

interface CourseRepository {

    suspend fun insertCourse(course: Course): SimpleResource

    suspend fun isCourseNameAlreadyInUse(courseName: String): Boolean

    suspend fun getCourseByName(name: String): Course?

    fun getCourses(): Flow<List<Course>>

}