package com.valet.link_reaper.repository

import com.valet.link_reaper.model.Link
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface LinkRepository : JpaRepository<Link, UUID> {
}