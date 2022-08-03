package io.usmon.domain.repository.mentor

import io.usmon.domain.util.Resource
import io.usmon.domain.util.SimpleResource
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

interface MentorRepository {

    suspend fun insertMentor(mentor: Mentor): SimpleResource

    suspend fun deleteMentor(mentor: Mentor): SimpleResource

    fun getMentorsByCourse(courseName: String): Flow<List<Mentor>>

}