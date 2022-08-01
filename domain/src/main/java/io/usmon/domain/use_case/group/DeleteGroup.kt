package io.usmon.domain.use_case.group

import io.usmon.domain.repository.group.Group
import io.usmon.domain.repository.group.GroupRepository
import io.usmon.domain.util.Resource

class DeleteGroup(
    private val repository: GroupRepository,
) {
    suspend operator fun invoke(group: Group): Resource<Unit> {
        return repository.deleteGroup(group)
    }
}