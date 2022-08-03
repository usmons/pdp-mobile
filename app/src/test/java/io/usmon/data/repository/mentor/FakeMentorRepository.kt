package io.usmon.data.repository.mentor

import io.usmon.domain.repository.mentor.Mentor
import io.usmon.domain.repository.mentor.MentorRepository
import io.usmon.domain.util.Resource
import io.usmon.domain.util.SimpleResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// Created by Usmon Abdurakhmanv on 8/1/2022.

class FakeMentorRepository : MentorRepository {

    private val mentors = mutableSetOf<Mentor>()
    private var onTrigger: (suspend () -> Unit)? = null

    override suspend fun insertMentor(mentor: Mentor): SimpleResource {
        val wasAdded = mentors.add(mentor)
        return if (wasAdded) {
            onTrigger?.invoke()
            Resource.success(Unit)
        } else {
            Resource.failure("Not inserted")
        }
    }

    override suspend fun deleteMentor(mentor: Mentor): SimpleResource {
        val wasDeleted = mentors.remove(mentor)
        return if (wasDeleted) {
            onTrigger?.invoke()
            Resource.success(Unit)
        } else {
            Resource.failure("Not deleted")
        }
    }

    override fun getMentorsByCourse(courseName: String): Flow<List<Mentor>> = flow {
        onTriggerListener {
            emit(mentors.toList())
        }
    }

    private fun onTriggerListener(block: suspend () -> Unit) {
        onTrigger = block
    }
}