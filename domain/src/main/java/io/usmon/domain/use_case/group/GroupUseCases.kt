package io.usmon.domain.use_case.group

// Created by Usmon Abdurakhmanv on 7/31/2022.

data class GroupUseCases(
    val insertGroup: InsertGroup,
    val deleteGroup: DeleteGroup,
    val getGroupById: GetGroupById,
    val getGroupsByCourse: GetGroupsByCourse,
)
