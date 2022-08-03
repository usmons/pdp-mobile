package io.usmon.domain.repository.student

import io.usmon.domain.util.SimpleResource
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

interface StudentRepository {

    suspend fun insertStudent(student: Student): SimpleResource

    suspend fun getStudentById(studentId: Int): Student?

    suspend fun deleteStudent(student: Student): SimpleResource

    fun getStudentsByGroup(groupId: Int): Flow<List<Student>>
}