package com.valet.link_reaper.controller

import com.valet.link_reaper.model.Link
import com.valet.link_reaper.model.details.CustomUserDetails
import com.valet.link_reaper.service.interfaces.LinkService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/link/")
class LinkController(private val linkService: LinkService) {

    @PostMapping("/")
    @PreAuthorize("isAuthenticated()")
    fun addLink(@RequestBody link: Link, @AuthenticationPrincipal details: CustomUserDetails): UUID {
        link.userId = details.user.id!!
        return linkService.addLink(link)
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    fun redirect(@PathVariable id: UUID): ResponseEntity<Any> {
        return linkService.redirect(id)
    }

}