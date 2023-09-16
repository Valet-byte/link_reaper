package com.valet.link_reaper.config

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableMethodSecurity(
    jsr250Enabled = true,
    prePostEnabled = true,
    securedEnabled = true)
@EnableCaching
class Config {
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder(12)

    @Bean
    fun http(http: HttpSecurity): SecurityFilterChain {
        http.csrf{it.disable()}
        .sessionManagement{it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
        .httpBasic(Customizer.withDefaults())
        return http.build()
    }

    @Bean
    fun redisCache(factory: RedisConnectionFactory): CacheManager {
        val cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
            .disableCachingNullValues().serializeValuesWith(
                RedisSerializationContext.SerializationPair
                    .fromSerializer(GenericJackson2JsonRedisSerializer()))
        return RedisCacheManager.builder(factory).cacheDefaults(cacheConfiguration).build()
    }

}