package com.valet.link_reaper.service

import com.valet.link_reaper.model.details.CustomUserDetails
import com.valet.link_reaper.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService(private val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return CustomUserDetails(userRepository.findByUsername(username).orElseThrow{throw UsernameNotFoundException("User with username: {$username} not found")})
    }
}