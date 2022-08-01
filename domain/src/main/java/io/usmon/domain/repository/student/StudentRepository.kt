package io.usmon.domain.repository.student

import io.usmon.domain.util.Resource
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

interface StudentRepository {

    suspend fun insertStudent(student: Student): Resource<Unit>

    suspend fun getStudentById(studentId: Int): Student?

    suspend fun deleteStudent(student: Student): Resource<Unit>

    fun getStudentsByGroup(groupId: Int): Flow<List<Student>>
}