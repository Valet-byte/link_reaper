package com.valet.link_reaper.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.security.core.GrantedAuthority

@Entity
data class UserAuthority(@Id var id: Int, var name: String): GrantedAuthority {
    override fun getAuthority() = name

    companion object{
        val USER = UserAuthority(1, "USER")
        val ADMIN = UserAuthority(2, "ADMIN")
    }
}