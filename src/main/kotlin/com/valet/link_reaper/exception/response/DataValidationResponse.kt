package com.valet.link_reaper.exception.response

import org.springframework.http.HttpStatus

data class DataValidationResponse(override val message: String, override val errorCode: Int)
    : ExceptionMessage(message, errorCode, HttpStatus.BAD_REQUEST) {
    companion object {

    }
}