package io.usmon.domain.repository.group

import io.usmon.domain.repository.student.Student
import java.io.Serializable

// Created by Usmon Abdurakhmanv on 8/1/2022.

data class GroupedStudents(
    val group: Group,
    val students: List<Student>,
) : Serializable
