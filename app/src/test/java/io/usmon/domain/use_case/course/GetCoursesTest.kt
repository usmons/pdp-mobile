package io.usmon.domain.use_case.course

import com.google.common.truth.Truth.assertThat
import io.usmon.data.repository.course.FakeCourseRepository
import io.usmon.domain.repository.course.Course
import io.usmon.domain.repository.course.CourseRepository
import io.usmon.domain.util.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

// Created by Usmon Abdurakhmanv on 8/1/2022.

class GetCoursesTest {

    private lateinit var repository: CourseRepository
    private lateinit var insertCourse: InsertCourse
    private lateinit var getCourses: GetCourses

    @Before
    fun setUp() {
        repository = FakeCourseRepository()
        insertCourse = InsertCourse(repository)
        getCourses = GetCourses(repository)
    }

    @Test
    fun `Triggers when course added`() = runBlocking {
        val course = Course(
            name = "Name",
            description = "Description"
        )

        val coursesFlow = getCourses()

        coursesFlow.collect { courses ->
            assertThat(course).isIn(courses)
        }

        val insertResult = insertCourse(course)
        assertThat(insertResult).isInstanceOf(Resource.Success::class.java)
    }
}