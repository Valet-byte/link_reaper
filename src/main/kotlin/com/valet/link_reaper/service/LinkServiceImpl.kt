package com.valet.link_reaper.service

import com.valet.link_reaper.exception.ApiException
import com.valet.link_reaper.exception.response.DataNotFoundResponse
import com.valet.link_reaper.exception.response.DataValidationResponse
import com.valet.link_reaper.model.Link
import com.valet.link_reaper.repository.LinkRepository
import com.valet.link_reaper.service.interfaces.LinkService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class LinkServiceImpl(private val linkRepository: LinkRepository): LinkService {
    override fun addLink(link: Link) = linkRepository.save(link).id!!


    override fun redirect(id: UUID): ResponseEntity<Any> {
        val link = linkRepository.findById(id).orElseThrow{throw ApiException(DataNotFoundResponse.LINK_BY_ID_NOT_FOUND)}

        val statusCode: HttpStatusCode = if (link.isPermanentRedirect) {
            HttpStatusCode.valueOf(301)
        } else {
            HttpStatusCode.valueOf(302)
        }
        val response = ResponseEntity<Any>(statusCode)
        response.headers.set("Location", link.url)
        return response
    }
}