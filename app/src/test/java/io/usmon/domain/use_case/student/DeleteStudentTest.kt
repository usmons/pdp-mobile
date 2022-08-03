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

class DeleteStudentTest {

    private lateinit var repository: StudentRepository
    private lateinit var insertStudent: InsertStudent
    private lateinit var deleteStudent: DeleteStudent

    @Before
    fun setUp() {
        repository = FakeStudentRepository()
        insertStudent = InsertStudent(repository)
        deleteStudent = DeleteStudent(repository)
    }

    @Test
    fun `Does not exist student Returns failure resource`() = runBlocking {
        val student = Student(
            firstName = "First",
            lastName = "Last",
            middleName = "Middle",
            startsDate = "01.01.2000",
            groupId = 0
        )
        val result = deleteStudent(student)
        assertThat(result).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Exist student Returns success resource`() = runBlocking {
        val student = Student(
            firstName = "First",
            lastName = "Last",
            middleName = "Middle",
            startsDate = "01.01.2000",
            groupId = 0
        )
        val insertResult = insertStudent(student)
        assertThat(insertResult).isInstanceOf(Resource.Success::class.java)

        val result = deleteStudent(student)
        assertThat(result).isInstanceOf(Resource.Success::class.java)
    }

}