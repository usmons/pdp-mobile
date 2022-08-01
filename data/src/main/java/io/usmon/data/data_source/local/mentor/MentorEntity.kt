package io.usmon.data.data_source.local.mentor

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Usmon Abdurakhmanv on 7/31/2022.

@Entity(
    tableName = "mentors"
)
data class MentorEntity(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val courseId: String,
    @PrimaryKey val id: Int? = null,
)