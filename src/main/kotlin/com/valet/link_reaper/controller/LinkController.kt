package com.valet.link_reaper.controller

import com.valet.link_reaper.model.Link
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/link/")
class LinkController {

    @PostMapping("/")
    @PreAuthorize("isAuthenticated()")
    fun addLink(@RequestBody link: Link) {

    }

}