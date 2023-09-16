package com.valet.link_reaper.model.details

import com.valet.link_reaper.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class CustomUserDetails(val user: User): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = user.authorities.toMutableSet()
    override fun getPassword() = user.password
    override fun getUsername() = user.username
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked()= true
    override fun isCredentialsNonExpired()= true
    override fun isEnabled()= true
}