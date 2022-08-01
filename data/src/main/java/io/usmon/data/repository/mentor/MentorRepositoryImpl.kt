package io.usmon.data.repository.mentor

import io.usmon.data.data_source.local.mentor.MentorDao
import io.usmon.data.repository.mentor.mapper.toEntity
import io.usmon.data.repository.mentor.mapper.toMentor
import io.usmon.domain.repository.mentor.Mentor
import io.usmon.domain.repository.mentor.MentorRepository
import io.usmon.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException

// Created by Usmon Abdurakhmanv on 7/31/2022.

class MentorRepositoryImpl(
    private val mentorDao: MentorDao,
) : MentorRepository {

    override suspend fun insertMentor(mentor: Mentor): Resource<Unit> {
        return try {
            mentorDao.insert(mentor.toEntity())
            Resource.success(Unit)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.failure(e.localizedMessage ?: "Unknown error occurred")
        }
    }

    override suspend fun deleteMentor(mentor: Mentor): Resource<Unit> {
        return try {
            mentorDao.delete(mentor.toEntity())
            Resource.success(Unit)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.failure(e.localizedMessage ?: "Unknown error occurred")
        }
    }

    override fun getMentorsByCourse(courseName: String): Flow<List<Mentor>> {
        return mentorDao.getMentorsByCourse(courseName)
            .map { mentors ->
                mentors.map { mentorEntity ->
                    mentorEntity.toMentor()
                }
            }
    }
}