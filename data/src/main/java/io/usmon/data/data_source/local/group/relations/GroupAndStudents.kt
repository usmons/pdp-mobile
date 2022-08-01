package io.usmon.data.data_source.local.group.relations

import androidx.room.Embedded
import androidx.room.Relation
import io.usmon.data.data_source.local.group.GroupEntity
import io.usmon.data.data_source.local.student.StudentEntity

data class GroupAndStudents(
    @Embedded val group: GroupEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "groupId"
    )
    val students: List<StudentEntity>,
)
