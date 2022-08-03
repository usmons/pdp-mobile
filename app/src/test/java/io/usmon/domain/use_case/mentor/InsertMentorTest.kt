package io.usmon.domain.use_case.mentor

import com.google.common.truth.Truth.assertThat
import io.usmon.data.repository.mentor.FakeMentorRepository
import io.usmon.domain.repository.mentor.Mentor
import io.usmon.domain.repository.mentor.MentorRepository
import io.usmon.domain.util.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

// Created by Usmon Abdurakhmanv on 8/1/2022.

class InsertMentorTest {


    private lateinit var repository: MentorRepository
    private lateinit var insertMentor: InsertMentor

    @Before
    fun setUp() {
        repository = FakeMentorRepository()
        insertMentor = InsertMentor(repository)
    }

    @Test
    fun `Invalid firstName Returns failure resource`() = runBlocking {
        val firstName = ""
        val mentor = Mentor(
            firstName = firstName,
            lastName = "LastName",
            middleName = "MiddleName",
            courseId = "CourseId"
        )
        val result = insertMentor(mentor)
        assertThat(result).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Invalid laseName Returns failure resource`() = runBlocking {
        val laseName = ""
        val mentor = Mentor(
            firstName = "FirstName",
            lastName = laseName,
            middleName = "MiddleName",
            courseId = "CourseId"
        )
        val result = insertMentor(mentor)
        assertThat(result).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Invalid middleName Returns failure resource`() = runBlocking {
        val middleName = ""
        val mentor = Mentor(
            firstName = "FirstName",
            lastName = "LaseName",
            middleName = middleName,
            courseId = "CourseId"
        )
        val result = insertMentor(mentor)
        assertThat(result).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Valid fields Returns success resource`() = runBlocking {
        val mentor = Mentor(
            firstName = "FirstName",
            lastName = "LaseName",
            middleName = "MiddleName",
            courseId = "CourseId"
        )
        val result = insertMentor(mentor)
        assertThat(result).isInstanceOf(Resource.Success::class.java)
    }
}