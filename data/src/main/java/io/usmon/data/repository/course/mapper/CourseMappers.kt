package io.usmon.data.repository.course.mapper

import io.usmon.data.data_source.local.course.CourseEntity
import io.usmon.domain.repository.course.Course

// Created by Usmon Abdurakhmanv on 7/31/2022.

fun CourseEntity.toCourse(): Course {
    return Course(
        name = name,
        description = description,
    )
}

fun Course.toEntity(): CourseEntity {
    return CourseEntity(
        name = name,
        description = description
    )
}