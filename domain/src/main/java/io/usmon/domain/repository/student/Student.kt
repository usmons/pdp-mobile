package io.usmon.domain.repository.student

import java.io.Serializable

// Created by Usmon Abdurakhmanv on 7/31/2022.

data class Student(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val startsDate: String,
    val groupId: Int,
    val id: Int? = null,
) : Serializable