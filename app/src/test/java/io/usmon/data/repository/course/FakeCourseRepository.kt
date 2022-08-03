package io.usmon.data.repository.course

import io.usmon.domain.repository.course.Course
import io.usmon.domain.repository.course.CourseRepository
import io.usmon.domain.util.Resource
import io.usmon.domain.util.SimpleResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// Created by Usmon Abdurakhmanv on 8/1/2022.

class FakeCourseRepository : CourseRepository {

    private val courses = mutableSetOf<Course>()
    private var onTrigger: (suspend () -> Unit)? = null

    override suspend fun insertCourse(course: Course): SimpleResource {
        val wasAdded = courses.add(course)
        return if (wasAdded) {
            // If we add Course into database it triggered via flow
            onTrigger?.invoke()
            Resource.success(Unit)
        } else {
            Resource.failure("Not added")
        }
    }

    override suspend fun isCourseNameAlreadyInUse(courseName: String): Boolean {
        courses.forEach { course ->
            if (course.name == courseName) {
                return true
            }
        }
        return false
    }

    override suspend fun getCourseByName(name: String): Course? {
        courses.forEach { course ->
            if (course.name == name) {
                return course
            }
        }
        return null
    }

    override fun getCourses(): Flow<List<Course>> = flow {
        onTriggeredListener {
            emit(courses.toList())
        }
    }

    private fun onTriggeredListener(block: suspend () -> Unit) {
        onTrigger = block
    }
}