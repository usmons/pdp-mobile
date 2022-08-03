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

class GetMentorsByCourseTest {

    private lateinit var repository: MentorRepository
    private lateinit var insertMentor: InsertMentor
    private lateinit var getMentorsByCourse: GetMentorsByCourse

    @Before
    fun setUp() {
        repository = FakeMentorRepository()
        insertMentor = InsertMentor(repository)
        getMentorsByCourse = GetMentorsByCourse(repository)
    }

    @Test
    fun `Invalid courseId Gives emptyList() when database changed`() = runBlocking {
        val courseId = ""
        val mentor = Mentor(
            firstName = "First",
            lastName = "Last",
            middleName = "Middle",
            courseId = courseId
        )

        val mentorsFlow = getMentorsByCourse(courseId)
        mentorsFlow.collect { mentors ->
            assertThat(mentors).isEmpty()
        }

        val insertedResult = insertMentor(mentor)
        assertThat(insertedResult).isInstanceOf(Resource.Success::class.java)
    }

    @Test
    fun `Valid courseId Gives mentors by courseId when database changed`() = runBlocking {
        val courseId = "courseId"
        val mentor = Mentor(
            firstName = "First",
            lastName = "Last",
            middleName = "Middle",
            courseId = courseId
        )

        val mentorsFlow = getMentorsByCourse(courseId)
        mentorsFlow.collect { mentors ->
            assertThat(mentor).isIn(mentors)
        }

        val insertedResult = insertMentor(mentor)
        assertThat(insertedResult).isInstanceOf(Resource.Success::class.java)
    }
}