package com.valet.link_reaper.service

import com.valet.link_reaper.model.Link
import com.valet.link_reaper.service.interfaces.LinkService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class LinkServiceImpl : LinkService {
    override fun addLink(link: Link): String {
        TODO("Not yet implemented")
    }

    override fun redirect(id: UUID): ResponseEntity<Any> {
        TODO("Not yet implemented")
    }
}