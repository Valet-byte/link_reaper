package com.valet.link_reaper.service.interfaces

import com.valet.link_reaper.model.User
import com.valet.link_reaper.model.dto.UserDTO
import java.util.UUID

interface UserService {
    fun addUser(user: User): User
    fun getById(id: UUID): User
    fun getByUsername(username: String): User
}