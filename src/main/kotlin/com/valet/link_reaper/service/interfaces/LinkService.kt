package com.valet.link_reaper.service.interfaces

import com.valet.link_reaper.model.Link
import org.springframework.http.ResponseEntity
import java.util.UUID

interface LinkService {
    fun addLink(link: Link): String
    fun redirect(id: UUID): ResponseEntity<Any>
}