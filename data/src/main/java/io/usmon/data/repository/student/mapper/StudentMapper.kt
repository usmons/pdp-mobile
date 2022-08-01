package io.usmon.data.repository.student.mapper

import io.usmon.data.data_source.local.student.StudentEntity
import io.usmon.domain.repository.student.Student

// Created by Usmon Abdurakhmanv on 7/31/2022.

fun StudentEntity.toStudent(): Student {
    return Student(
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,
        startsDate = startsDate,
        groupId = groupId,
        id = id
    )
}

fun Student.toEntity(): StudentEntity {
    return StudentEntity(
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,
        startsDate = startsDate,
        groupId = groupId,
        id = id
    )
}