package io.usmon.domain.use_case.course

// Created by Usmon Abdurakhmanv on 7/31/2022.

data class CourseUseCases(
    val insertCourse: InsertCourse,
    val getCourseByName: GetCourseByName,
    val getCourses: GetCourses,
)
