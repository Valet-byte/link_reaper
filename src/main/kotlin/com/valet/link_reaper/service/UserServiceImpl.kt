package com.valet.link_reaper.service

import com.valet.link_reaper.exception.ApiException
import com.valet.link_reaper.exception.response.DataNotFoundResponse
import com.valet.link_reaper.model.User
import com.valet.link_reaper.model.UserAuthority
import com.valet.link_reaper.repository.UserRepository
import com.valet.link_reaper.service.interfaces.UserService
import com.valet.mysimpleapp.constatn.USER_KEY
import org.springframework.cache.annotation.Cacheable
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder) : UserService {
    override fun addUser(user: User): User{
        user.password = passwordEncoder.encode(user.password)
        user.authorities = setOf(UserAuthority.USER)
        return userRepository.save(user)
    }

    @Cacheable(cacheNames = [USER_KEY], key = "#id")
    override fun getById(id: UUID): User {
        return userRepository.findById(id).orElseThrow{throw ApiException(DataNotFoundResponse.USER_NOT_FOUND)}
    }

    @Cacheable(cacheNames = [USER_KEY], key = "#username")
    override fun getByUsername(username: String): User {
        return userRepository.findByUsername(username).orElseThrow{throw ApiException(DataNotFoundResponse.USER_NOT_FOUND)}
    }
}