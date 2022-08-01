package io.usmon.domain.use_case.mentor

import io.usmon.domain.repository.mentor.Mentor
import io.usmon.domain.repository.mentor.MentorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

class GetMentorsByCourse(
    private val repository: MentorRepository,
) {
    operator fun invoke(courseName: String): Flow<List<Mentor>> {
        if (courseName.isBlank()) {
            return flow { emit(emptyList()) }
        }
        return repository.getMentorsByCourse(courseName)
    }
}