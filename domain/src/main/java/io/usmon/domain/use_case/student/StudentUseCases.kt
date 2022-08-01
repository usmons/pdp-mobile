package io.usmon.domain.use_case.student

// Created by Usmon Abdurakhmanv on 7/31/2022.

data class StudentUseCases(
    val insertStudent: InsertStudent,
    val deleteStudent: DeleteStudent,
    val getStudentById: GetStudentById,
    val getStudentsByGroup: GetStudentsByGroup,
)
