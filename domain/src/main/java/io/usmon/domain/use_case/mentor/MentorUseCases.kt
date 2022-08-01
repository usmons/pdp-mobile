package io.usmon.domain.use_case.mentor

// Created by Usmon Abdurakhmanv on 7/31/2022.

data class MentorUseCases(
    val insertMentor: InsertMentor,
    val deleteMentor: DeleteMentor,
    val getMentorsByCourse: GetMentorsByCourse,
)
