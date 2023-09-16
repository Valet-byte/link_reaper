package com.valet.link_reaper.exception.handler

import com.valet.link_reaper.exception.ApiException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {

    private val log = LoggerFactory.getLogger(ApiExceptionHandler::class.java)

    @ExceptionHandler(value = [ApiException::class])
    protected fun apiExceptionHandler(ex: ApiException): ResponseEntity<Any> {
        log.error(ex.message, ex)
        return  ResponseEntity<Any>(ex.response, ex.response.status)
    }
}