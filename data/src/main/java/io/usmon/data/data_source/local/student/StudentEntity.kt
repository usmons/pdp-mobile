package io.usmon.data.data_source.local.student

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Usmon Abdurakhmanv on 7/31/2022.

@Entity(
    tableName = "students"
)
data class StudentEntity(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val startsDate: String,
    val groupId: Int,
    @PrimaryKey val id: Int? = null,
)