package com.valet.link_reaper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity

@SpringBootApplication
class LinkReaperApplication

fun main(args: Array<String>) {
    runApplication<LinkReaperApplication>(*args)
}
