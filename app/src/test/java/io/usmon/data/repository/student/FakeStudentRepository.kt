package io.usmon.data.repository.student

import io.usmon.domain.repository.student.Student
import io.usmon.domain.repository.student.StudentRepository
import io.usmon.domain.util.Resource
import io.usmon.domain.util.SimpleResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// Created by Usmon Abdurakhmanv on 8/1/2022.

class FakeStudentRepository : StudentRepository {

    private val students = mutableSetOf<Student>()
    private var onTrigger: (suspend () -> Unit)? = null

    override suspend fun insertStudent(student: Student): SimpleResource {
        val wasInserted = students.add(student)
        return if (wasInserted) {
            onTrigger?.invoke()
            Resource.success(Unit)
        } else {
            Resource.failure("Not inserted")
        }
    }

    override suspend fun getStudentById(studentId: Int): Student? {
        students.forEach { student ->
            if (student.id == studentId) {
                return student
            }
        }
        return null
    }

    override suspend fun deleteStudent(student: Student): SimpleResource {
        val wasDeleted = students.remove(student)
        return if (wasDeleted) {
            onTrigger?.invoke()
            Resource.success(Unit)
        } else {
            Resource.failure("Not deleted")
        }
    }

    override fun getStudentsByGroup(groupId: Int): Flow<List<Student>> = flow {
        onTriggerListener {
            emit(students.toList())
        }
    }

    private fun onTriggerListener(block: suspend () -> Unit) {
        onTrigger = block
    }
}