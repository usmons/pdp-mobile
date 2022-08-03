package io.usmon.data.repository.course

import io.usmon.data.data_source.local.course.CourseDao
import io.usmon.data.repository.course.mapper.toCourse
import io.usmon.data.repository.course.mapper.toEntity
import io.usmon.domain.repository.course.Course
import io.usmon.domain.repository.course.CourseRepository
import io.usmon.domain.util.Resource
import io.usmon.domain.util.SimpleResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException

// Created by Usmon Abdurakhmanv on 7/31/2022.

class CourseRepositoryImpl(
    private val courseDao: CourseDao,
) : CourseRepository {

    override suspend fun insertCourse(course: Course): SimpleResource {
        return try {
            courseDao.insert(course.toEntity())
            Resource.success(Unit)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.failure(e.localizedMessage ?: "Unknown error occurred")
        }
    }

    override suspend fun isCourseNameAlreadyInUse(courseName: String): Boolean {
        val course = getCourseByName(courseName)
        return course?.name == courseName
    }

    override suspend fun getCourseByName(name: String): Course? {
        return courseDao.getCourse(name)?.toCourse()
    }

    override fun getCourses(): Flow<List<Course>> {
        return courseDao.getCourses()
            .map { courses ->
                courses.map { courseEntity ->
                    courseEntity.toCourse()
                }
            }
    }
}