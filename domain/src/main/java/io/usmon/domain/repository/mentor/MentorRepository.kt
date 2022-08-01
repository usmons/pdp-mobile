package io.usmon.domain.repository.mentor

import io.usmon.domain.util.Resource
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

interface MentorRepository {

    suspend fun insertMentor(mentor: Mentor): Resource<Unit>

    suspend fun deleteMentor(mentor: Mentor): Resource<Unit>

    fun getMentorsByCourse(courseName: String): Flow<List<Mentor>>

}