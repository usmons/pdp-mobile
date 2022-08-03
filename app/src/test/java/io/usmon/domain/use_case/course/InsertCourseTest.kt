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

class InsertCourseTest {

    private lateinit var repository: CourseRepository
    private lateinit var insertCourse: InsertCourse

    @Before
    fun setUp() {
        repository = FakeCourseRepository()
        insertCourse = InsertCourse(repository)
    }

    @Test
    fun `Invalid name Returns failure resource`() = runBlocking {
        val name = ""
        val course = Course(
            name = name,
            description = "Description"
        )
        val result = insertCourse(course)
        assertThat(result).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Invalid description Returns failure resource`() = runBlocking {
        val description = ""
        val course = Course(
            name = "Name",
            description = description
        )
        val result = insertCourse(course)
        assertThat(result).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Valid name and description Returns success resource`() = runBlocking {
        val course = Course(
            name = "Name",
            description = "Description"
        )
        val result = insertCourse(course)
        assertThat(result).isInstanceOf(Resource.Success::class.java)
    }

    @Test
    fun `Already exist name Returns failure resource`() = runBlocking {
        val course = Course(
            name = "Name",
            description = "Description"
        )
        val result = insertCourse(course)
        assertThat(result).isInstanceOf(Resource.Success::class.java)

        val failureResult = insertCourse(course)
        assertThat(failureResult).isInstanceOf(Resource.Failure::class.java)
    }


}