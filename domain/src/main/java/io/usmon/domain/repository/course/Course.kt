package io.usmon.domain.repository.course

import java.io.Serializable

// Created by Usmon Abdurakhmanv on 7/31/2022.

data class Course(
    val name: String,
    val description: String,
) : Serializable
