package io.usmon.data.repository.mentor.mapper

import io.usmon.data.data_source.local.mentor.MentorEntity
import io.usmon.domain.repository.mentor.Mentor

// Created by Usmon Abdurakhmanv on 7/31/2022.

fun MentorEntity.toMentor(): Mentor {
    return Mentor(
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,
        courseId = courseId,
        id = id,
    )
}

fun Mentor.toEntity(): MentorEntity {
    return MentorEntity(
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,
        courseId = courseId,
        id = id
    )
}