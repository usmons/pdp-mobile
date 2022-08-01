package io.usmon.domain.use_case.group

import io.usmon.domain.repository.group.Group
import io.usmon.domain.repository.group.GroupRepository

class GetGroupById(
    private val repository: GroupRepository,
) {

    suspend operator fun invoke(groupId: Int): Group? {
        return repository.getGroupById(groupId)
    }
}