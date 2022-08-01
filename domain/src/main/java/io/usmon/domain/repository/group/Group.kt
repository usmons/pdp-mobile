package io.usmon.domain.repository.group

import java.io.Serializable

// Created by Usmon Abdurakhmanv on 7/31/2022.

data class Group(
    val name: String,
    val courseId: String,
    val mentorId: Int,
    val time: String,
    val days: String,
    val isOpened: Boolean = false,
    val id: Int? = null,
) : Serializable