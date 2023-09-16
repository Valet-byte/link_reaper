package com.valet.link_reaper.model.dto

import com.valet.link_reaper.model.User
import java.util.UUID

data class UserDTO(
    val id: UUID?,
    val name: String
) {
    companion object {
        fun toDto(user: User) = UserDTO(id = user.id, name = user.username)

    }
}
