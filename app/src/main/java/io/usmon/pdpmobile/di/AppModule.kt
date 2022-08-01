package io.usmon.pdpmobile.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.usmon.data.data_source.local.DefaultDatabase
import io.usmon.data.data_source.local.DefaultDatabase.Companion.DB_NAME
import io.usmon.data.repository.course.CourseRepositoryImpl
import io.usmon.data.repository.group.GroupRepositoryImpl
import io.usmon.data.repository.mentor.MentorRepositoryImpl
import io.usmon.data.repository.student.StudentRepositoryImpl
import io.usmon.domain.repository.course.CourseRepository
import io.usmon.domain.repository.group.GroupRepository
import io.usmon.domain.repository.mentor.MentorRepository
import io.usmon.domain.repository.student.StudentRepository
import io.usmon.domain.use_case.course.CourseUseCases
import io.usmon.domain.use_case.course.GetCourseByName
import io.usmon.domain.use_case.course.GetCourses
import io.usmon.domain.use_case.course.InsertCourse
import io.usmon.domain.use_case.group.*
import io.usmon.domain.use_case.mentor.DeleteMentor
import io.usmon.domain.use_case.mentor.GetMentorsByCourse
import io.usmon.domain.use_case.mentor.InsertMentor
import io.usmon.domain.use_case.mentor.MentorUseCases
import io.usmon.domain.use_case.student.*
import javax.inject.Singleton

// Created by Usmon Abdurakhmanv on 7/31/2022.

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application): DefaultDatabase {
        return Room.databaseBuilder(
            app,
            DefaultDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCourseRepository(database: DefaultDatabase): CourseRepository {
        return CourseRepositoryImpl(courseDao = database.courseDao)
    }

    @Provides
    @Singleton
    fun provideMentorRepository(database: DefaultDatabase): MentorRepository {
        return MentorRepositoryImpl(mentorDao = database.mentorDao)
    }

    @Provides
    @Singleton
    fun provideStudentRepository(database: DefaultDatabase): StudentRepository {
        return StudentRepositoryImpl(studentDao = database.studentDao)
    }

    @Provides
    @Singleton
    fun provideGroupRepository(database: DefaultDatabase): GroupRepository {
        return GroupRepositoryImpl(groupDao = database.groupDao)
    }

    @Provides
    @Singleton
    fun provideCourseUseCases(repository: CourseRepository): CourseUseCases {
        return CourseUseCases(
            insertCourse = InsertCourse(repository),
            getCourseByName = GetCourseByName(repository),
            getCourses = GetCourses(repository)
        )
    }

    @Provides
    @Singleton
    fun provideMentorUseCases(repository: MentorRepository): MentorUseCases {
        return MentorUseCases(
            insertMentor = InsertMentor(repository),
            deleteMentor = DeleteMentor(repository),
            getMentorsByCourse = GetMentorsByCourse(repository)
        )
    }

    @Provides
    @Singleton
    fun provideStudentUseCases(repository: StudentRepository): StudentUseCases {
        return StudentUseCases(
            insertStudent = InsertStudent(repository),
            deleteStudent = DeleteStudent(repository),
            getStudentById = GetStudentById(repository),
            getStudentsByGroup = GetStudentsByGroup(repository)
        )
    }

    @Provides
    @Singleton
    fun provideGroupUseCases(repository: GroupRepository): GroupUseCases {
        return GroupUseCases(
            insertGroup = InsertGroup(repository),
            deleteGroup = DeleteGroup(repository),
            getGroupById = GetGroupById(repository),
            getGroupsByCourse = GetGroupsByCourse(repository)
        )
    }
}