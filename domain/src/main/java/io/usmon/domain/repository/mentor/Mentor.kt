package io.usmon.domain.repository.mentor

import java.io.Serializable

// Created by Usmon Abdurakhmanv on 7/31/2022.

data class Mentor(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val courseId: String,
    val id: Int? = null,
) : Serializable