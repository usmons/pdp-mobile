package io.usmon.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.usmon.data.data_source.local.DefaultDatabase.Companion.DB_VERSION
import io.usmon.data.data_source.local.course.CourseDao
import io.usmon.data.data_source.local.course.CourseEntity
import io.usmon.data.data_source.local.group.GroupDao
import io.usmon.data.data_source.local.group.GroupEntity
import io.usmon.data.data_source.local.mentor.MentorDao
import io.usmon.data.data_source.local.mentor.MentorEntity
import io.usmon.data.data_source.local.student.StudentDao
import io.usmon.data.data_source.local.student.StudentEntity

// Created by Usmon Abdurakhmanv on 7/31/2022.

@Database(
    entities = [
        CourseEntity::class,
        GroupEntity::class,
        MentorEntity::class,
        StudentEntity::class
    ],
    version = DB_VERSION,
    exportSchema = false
)
abstract class DefaultDatabase : RoomDatabase() {
    abstract val courseDao: CourseDao
    abstract val groupDao: GroupDao
    abstract val mentorDao: MentorDao
    abstract val studentDao: StudentDao

    companion object {
        const val DB_NAME = "pdp-mobile.db"
        internal const val DB_VERSION = 1
    }
}