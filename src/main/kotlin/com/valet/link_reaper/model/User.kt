package com.valet.link_reaper.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID?,
    @Column(unique = true)
    var username: String = "",
    var password: String = "",
    @ManyToMany(fetch = FetchType.EAGER)
    var authorities: Set<UserAuthority> = setOf(UserAuthority.USER)
)
