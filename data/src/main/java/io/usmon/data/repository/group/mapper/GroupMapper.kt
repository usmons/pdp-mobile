package io.usmon.data.repository.group.mapper

import io.usmon.data.data_source.local.group.GroupEntity
import io.usmon.data.data_source.local.group.relations.GroupAndStudents
import io.usmon.data.repository.student.mapper.toStudent
import io.usmon.domain.repository.group.Group
import io.usmon.domain.repository.group.GroupedStudents

// Created by Usmon Abdurakhmanv on 7/31/2022.

fun GroupEntity.toGroup(): Group {
    return Group(
        name = name,
        courseId = courseId,
        mentorId = mentorId,
        time = time,
        days = days,
        isOpened = isOpened,
        id = id
    )
}

fun Group.toEntity(): GroupEntity {
    return GroupEntity(
        name = name,
        courseId = courseId,
        mentorId = mentorId,
        time = time,
        days = days,
        isOpened = isOpened,
        id = id
    )
}

fun GroupAndStudents.toGroupedStudents(): GroupedStudents {
    return GroupedStudents(
        group = group.toGroup(),
        students = students.map { it.toStudent() }
    )
}