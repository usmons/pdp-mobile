package io.usmon.domain.use_case.student

import io.usmon.domain.repository.student.Student
import io.usmon.domain.repository.student.StudentRepository

// Created by Usmon Abdurakhmanv on 7/31/2022.

class GetStudentById(
    private val repository: StudentRepository,
) {
    suspend operator fun invoke(studentId: Int?): Student? {
        return studentId?.let {
            return repository.getStudentById(studentId)
        }
    }
}