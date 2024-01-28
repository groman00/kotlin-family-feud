package com.example.familyfeud.domain

open class Team (
    open val players: List<Player>
)

data class PlayingTeam(
    override val players: List<Player>
) : Team (players)

