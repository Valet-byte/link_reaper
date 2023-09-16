package com.valet.link_reaper.exception

import com.valet.link_reaper.exception.response.ExceptionMessage

class ApiException(val response: ExceptionMessage) : RuntimeException()