package com.valet.link_reaper.exception.response

import org.springframework.http.HttpStatus

class DataNotFoundResponse (override val message: String, override val errorCode: Int)
    : ExceptionMessage(message, errorCode, HttpStatus.NOT_FOUND) {
    companion object {
        val USER_NOT_FOUND = DataNotFoundResponse("User by username not found", 1001)
    }
}