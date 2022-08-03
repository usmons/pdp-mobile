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

class DeleteMentorTest {

    private lateinit var repository: MentorRepository
    private lateinit var insertMentor: InsertMentor
    private lateinit var deleteMentor: DeleteMentor

    @Before
    fun setUp() {
        repository = FakeMentorRepository()
        insertMentor = InsertMentor(repository)
        deleteMentor = DeleteMentor(repository)
    }

    @Test
    fun `Does not exist mentor Returns failure resource`() = runBlocking {
        val mentor = Mentor(
            firstName = "First",
            lastName = "Last",
            middleName = "Middle",
            courseId = "courseId"
        )
        val result = deleteMentor(mentor)
        assertThat(result).isInstanceOf(Resource.Failure::class.java)
    }

    @Test
    fun `Exist mentor Returns success resource`() = runBlocking {
        val mentor = Mentor(
            firstName = "First",
            lastName = "Last",
            middleName = "Middle",
            courseId = "courseId"
        )
        val insertResult = insertMentor(mentor)
        assertThat(insertResult).isInstanceOf(Resource.Success::class.java)

        val result = deleteMentor(mentor)
        assertThat(result).isInstanceOf(Resource.Success::class.java)
    }
}