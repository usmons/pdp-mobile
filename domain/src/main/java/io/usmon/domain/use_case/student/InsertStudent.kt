package io.usmon.domain.use_case.student

import io.usmon.domain.repository.student.Student
import io.usmon.domain.repository.student.StudentRepository
import io.usmon.domain.util.Resource

// Created by Usmon Abdurakhmanv on 7/31/2022.

class InsertStudent(
    private val repository: StudentRepository,
) {

    suspend operator fun invoke(student: Student): Resource<Unit> {
        if (student.firstName.isBlank()) {
            return Resource.failure("The Student's first name couldn't be empty")
        }
        if (student.lastName.isBlank()) {
            return Resource.failure("The Student's last name couldn't be empty")
        }
        if (student.middleName.isBlank()) {
            return Resource.failure("The Student's middle name couldn't be empty")
        }
        if (student.startsDate.isBlank()) {
            return Resource.failure("The student's starting day couldn't be empty")
        }
        return repository.insertStudent(student)
    }

}