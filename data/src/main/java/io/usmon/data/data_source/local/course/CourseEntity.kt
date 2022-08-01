package io.usmon.data.data_source.local.course

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Usmon Abdurakhmanv on 7/31/2022.
@Entity(
    tableName = "courses"
)
data class CourseEntity(
    @PrimaryKey(autoGenerate = false) val name: String,
    val description: String,
)
