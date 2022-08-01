package io.usmon.data.repository.group

import io.usmon.data.data_source.local.group.GroupDao
import io.usmon.data.repository.group.mapper.toEntity
import io.usmon.data.repository.group.mapper.toGroup
import io.usmon.data.repository.group.mapper.toGroupedStudents
import io.usmon.domain.repository.group.Group
import io.usmon.domain.repository.group.GroupRepository
import io.usmon.domain.repository.group.GroupedStudents
import io.usmon.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException

// Created by Usmon Abdurakhmanv on 7/31/2022.

class GroupRepositoryImpl(
    private val groupDao: GroupDao,
) : GroupRepository {
    override suspend fun insertGroup(group: Group): Resource<Unit> {
        return try {
            groupDao.insert(group.toEntity())
            Resource.success(Unit)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.failure(e.localizedMessage ?: "Unknown error occurred")
        }
    }

    override suspend fun deleteGroup(group: Group): Resource<Unit> {
        return try {
            groupDao.delete(group.toEntity())
            Resource.success(Unit)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.failure(e.localizedMessage ?: "Unknown error occurred")
        }
    }

    override suspend fun isGroupNameAlreadyExist(groupName: String): Boolean {
        val group = groupDao.getGroupByName(groupName)
        return group?.name == groupName
    }

    override suspend fun getGroupById(groupId: Int): Group? {
        return groupDao.getGroupById(groupId)?.toGroup()
    }

    override fun getGroupsByCourse(courseName: String): Flow<List<GroupedStudents>> {
        return groupDao.getGroupsByCourse(courseName).map {
            it.map { it.toGroupedStudents() }
        }
    }
}