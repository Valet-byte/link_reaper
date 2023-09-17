package com.valet.link_reaper.model

import jakarta.persistence.*
import java.util.UUID

@Entity
data class Link(
    @Id @Column(columnDefinition = "uuid DEFAULT gen_random_uuid()")
    var id: UUID?,
    var url: String,
    @JoinColumn(table = "user", referencedColumnName = "id")
    var userId: UUID,
    var isPermanentRedirect: Boolean = true,
    var isHttp: Boolean = false
)
