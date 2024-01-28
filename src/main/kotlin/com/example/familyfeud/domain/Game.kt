package com.example.familyfeud.domain

data class Game (
    val rounds: Triple<String, String, String>,
    val host: Host,
    val teams: Pair<Team, Team>
)