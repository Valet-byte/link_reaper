package com.valet.link_reaper.controller

import com.valet.link_reaper.model.User
import com.valet.link_reaper.model.dto.UserDTO
import com.valet.link_reaper.service.interfaces.UserService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(private val userService: UserService) {

    @PostMapping("/registration")
    @PreAuthorize("permitAll()")
    fun registration(@RequestBody user: User) = UserDTO.toDto(userService.addUser(user))
}