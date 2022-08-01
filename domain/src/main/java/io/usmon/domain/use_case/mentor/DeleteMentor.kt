package io.usmon.domain.use_case.mentor

import io.usmon.domain.repository.mentor.Mentor
import io.usmon.domain.repository.mentor.MentorRepository
import io.usmon.domain.util.Resource

// Created by Usmon Abdurakhmanv on 7/31/2022.

class DeleteMentor(
    private val repository: MentorRepository,
) {
    suspend operator fun invoke(mentor: Mentor): Resource<Unit> {
        return repository.deleteMentor(mentor)
    }
}