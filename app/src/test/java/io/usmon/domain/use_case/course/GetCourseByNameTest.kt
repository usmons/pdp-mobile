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

class GetCourseByNameTest {


    private lateinit var repository: CourseRepository
    private lateinit var insertCourse: InsertCourse
    private lateinit var getCourseByName: GetCourseByName

    @Before
    fun setUp() {
        repository = FakeCourseRepository()
        insertCourse = InsertCourse(repository)
        getCourseByName = GetCourseByName(repository)
    }

    @Test
    fun `Invalid course name Returns null`() = runBlocking {
        val name = ""
        val takenCourse = getCourseByName(name)
        assertThat(takenCourse).isNull()
    }

    @Test
    fun `Valid name Returns course with in name`() = runBlocking {
        val name = "Name"
        val course = Course(
            name = name,
            description = "Description"
        )
        val insertResult = insertCourse(course)
        assertThat(insertResult).isInstanceOf(Resource.Success::class.java)

        val takenCourse = getCourseByName(name)
        assertThat(takenCourse).isEqualTo(course)
    }

}