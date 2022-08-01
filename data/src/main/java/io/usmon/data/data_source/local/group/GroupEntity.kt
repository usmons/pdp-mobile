package io.usmon.data.data_source.local.group

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Usmon Abdurakhmanv on 7/31/2022.

@Entity(
    tableName = "groups"
)
data class GroupEntity(
    val name: String,
    val courseId: String,
    val mentorId: Int,
    val time: String,
    val days: String,
    val isOpened: Boolean = false,
    @PrimaryKey val id: Int? = null,
)