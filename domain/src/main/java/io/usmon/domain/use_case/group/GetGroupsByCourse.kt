package io.usmon.domain.use_case.group

import io.usmon.domain.repository.group.GroupRepository
import io.usmon.domain.repository.group.GroupedStudents
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGroupsByCourse(
    private val repository: GroupRepository,
) {

    operator fun invoke(courseName: String): Flow<List<GroupedStudents>> {
        if (courseName.isBlank()) {
            return flow { emit(emptyList()) }
        }
        return repository.getGroupsByCourse(courseName)
    }
}