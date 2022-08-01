package io.usmon.domain.use_case.student

import io.usmon.domain.repository.student.Student
import io.usmon.domain.repository.student.StudentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

class GetStudentsByGroup(
    private val repository: StudentRepository,
) {
    operator fun invoke(groupId: Int?): Flow<List<Student>> {
        return groupId?.let {
            repository.getStudentsByGroup(groupId)
        } ?: flow { emit(emptyList<Student>()) }
    }
}