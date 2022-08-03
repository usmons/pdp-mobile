package io.usmon.domain.use_case.student

import com.google.common.truth.Truth.assertThat
import io.usmon.data.repository.student.FakeStudentRepository
import io.usmon.domain.repository.student.Student
import io.usmon.domain.repository.student.StudentRepository
import io.usmon.domain.util.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

// Created by Usmon Abdurakhmanv on 8/1/2022.

class InsertStudentTest {

    private lateinit var repository: StudentRepository
    private lateinit var insertStudent: InsertStudent

    @Before
    fun setUp() {
        repository = FakeStudentRepository()
        insertStudent = InsertStudent(repository)
    }

    @Test
    fun `Invalid firstName Returns failure resource`() = runBlocking {
        val firstName = ""
        val student = Student(
            firstName = firstName,
            lastName = "LastName",
            middleName = "MiddleName",
            startsDate = "01.01.2000",
            groupId = 0
        )
        val insertResult = insertStudent(student)
        assertThat(insertResult).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Invalid lastName Returns failure resource`() = runBlocking {
        val lastName = ""
        val student = Student(
            firstName = "FirstName",
            lastName = lastName,
            middleName = "MiddleName",
            startsDate = "01.01.2000",
            groupId = 0
        )
        val insertResult = insertStudent(student)
        assertThat(insertResult).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Invalid middleName Returns failure resource`() = runBlocking {
        val middleName = ""
        val student = Student(
            firstName = "FirstName",
            lastName = "LastName",
            middleName = middleName,
            startsDate = "01.01.2000",
            groupId = 0
        )
        val insertResult = insertStudent(student)
        assertThat(insertResult).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Invalid starting date Returns failure resource`() = runBlocking {
        val startingDate = ""
        val student = Student(
            firstName = "FirstName",
            lastName = "LastName",
            middleName = "MiddleName",
            startsDate = startingDate,
            groupId = 0
        )
        val insertResult = insertStudent(student)
        assertThat(insertResult).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Valid fields Returns success resource`() = runBlocking {
        val student = Student(
            firstName = "FirstName",
            lastName = "LastName",
            middleName = "MiddleName",
            startsDate = "01.01.2000",
            groupId = 0
        )
        val insertResult = insertStudent(student)
        assertThat(insertResult).isInstanceOf(Resource.Success::class.java)
    }
}