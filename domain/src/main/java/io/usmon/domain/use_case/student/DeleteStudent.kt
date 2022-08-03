package io.usmon.domain.use_case.student

import io.usmon.domain.repository.student.Student
import io.usmon.domain.repository.student.StudentRepository
import io.usmon.domain.util.SimpleResource

// Created by Usmon Abdurakhmanv on 7/31/2022.

class DeleteStudent(
    private val repository: StudentRepository,
) {
    suspend operator fun invoke(student: Student): SimpleResource {
        return repository.deleteStudent(student)
    }
}