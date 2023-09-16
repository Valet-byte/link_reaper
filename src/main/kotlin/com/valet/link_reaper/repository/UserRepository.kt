package com.valet.link_reaper.repository

import com.valet.link_reaper.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface UserRepository: JpaRepository<User, UUID> {
    fun findByUsername(username: String): Optional<User>
}