package com.valet.link_reaper.exception.response

import org.springframework.http.HttpStatus

abstract class ExceptionMessage(open val message: String, open val errorCode: Int, val status: HttpStatus)