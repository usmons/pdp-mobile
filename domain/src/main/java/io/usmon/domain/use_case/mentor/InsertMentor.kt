package io.usmon.domain.use_case.mentor

import io.usmon.domain.repository.mentor.Mentor
import io.usmon.domain.repository.mentor.MentorRepository
import io.usmon.domain.util.Resource
import io.usmon.domain.util.SimpleResource

// Created by Usmon Abdurakhmanv on 7/31/2022.

class InsertMentor(
    private val repository: MentorRepository,
) {
    suspend operator fun invoke(mentor: Mentor): SimpleResource {
        if (mentor.firstName.isBlank()) {
            return Resource.failure("First name couldn't be empty")
        }
        if (mentor.lastName.isBlank()) {
            return Resource.failure("Last name couldn't be empty")
        }
        if (mentor.middleName.isBlank()) {
            return Resource.failure("Middle name couldn't be empty")
        }
        return repository.insertMentor(mentor)
    }
}