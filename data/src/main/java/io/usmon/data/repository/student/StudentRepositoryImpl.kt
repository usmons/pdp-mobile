package io.usmon.data.repository.student

import io.usmon.data.data_source.local.student.StudentDao
import io.usmon.data.repository.student.mapper.toEntity
import io.usmon.data.repository.student.mapper.toStudent
import io.usmon.domain.repository.student.Student
import io.usmon.domain.repository.student.StudentRepository
import io.usmon.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException

// Created by Usmon Abdurakhmanv on 7/31/2022.

class StudentRepositoryImpl(
    private val studentDao: StudentDao,
) : StudentRepository {

    override suspend fun insertStudent(student: Student): Resource<Unit> {
        return try {
            studentDao.insert(student.toEntity())
            Resource.success(Unit)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.failure(e.localizedMessage ?: "Unknown error occurred")
        }
    }

    override suspend fun getStudentById(studentId: Int): Student? {
        return studentDao.getStudentById(studentId)?.toStudent()
    }

    override suspend fun deleteStudent(student: Student): Resource<Unit> {
        return try {
            studentDao.delete(student.toEntity())
            Resource.success(Unit)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.failure(e.localizedMessage ?: "Unknown error occurred")
        }
    }

    override fun getStudentsByGroup(groupId: Int): Flow<List<Student>> {
        return studentDao.getStudentsByGroup(groupId)
            .map { students ->
                students.map { studentEntity ->
                    studentEntity.toStudent()
                }
            }
    }
}