package io.usmon.domain.use_case.group

import io.usmon.domain.repository.group.Group
import io.usmon.domain.repository.group.GroupRepository
import io.usmon.domain.util.Resource
import io.usmon.domain.util.SimpleResource

// Created by Usmon Abdurakhmanv on 7/31/2022.

class InsertGroup(
    private val repository: GroupRepository,
) {
    suspend operator fun invoke(group: Group): SimpleResource {
        if (group.name.isBlank()) {
            return Resource.failure("Group name couldn't be empty")
        }
        if (group.time.isBlank()) {
            return Resource.failure("Time should be chosen")
        }
        if (group.days.isBlank()) {
            return Resource.failure("Days should be chosen")
        }
        val groupNameAlreadyInUse = repository.isGroupNameAlreadyExist(groupName = group.name) && group.id == null
        if (groupNameAlreadyInUse) {
            return Resource.failure("Group name already in use")
        }
        return repository.insertGroup(group)
    }
}