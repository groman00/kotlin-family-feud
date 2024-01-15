package com.example.familyfeud

import com.example.familyfeud.domain.*

class DemoApplication {

    fun run() {
        val host = Host("Steve Harvey")
        val team1 = createTeam("Osbourne Family")
        val team2 = createTeam("Stevens Family")
        val game = Game(
            Triple("Round 1", "Round 2", "Round 3"),
            host,
            listOf(team1, team2)
        )

        println("Game created: $game")

        val round1 = createRound()

        println("Round 1 created: $round1")

        val startedRound1 = round1.startRound()

        println("Round 1 started: $startedRound1")

        val team1Player1 = TeamPlayer(team1, team1.players[0])
        val guess = Guess("Kitchen")
        val guessResult = startedRound1.buzzIn(
            team1Player1,
            guess
        )

        when(guessResult) {
            is GoodGuess -> println("Good guess!")
            is BadGuess -> println("Bad guess!")
        }
    }

    private fun createTeam(name: String): Team {
        val players = listOf(
            Player("Team $name: Player 1"),
            Player("Team $name: Player 2"),
        )
        return Team(players)
    }

    private fun createRound(): NewRound {
        val survey = NewSurvey(
            listOf("WORD", "LAUGH", "PIECE OF CAKE/BITE", "DRINK/DROP"),
            "Name a place where you don't like people walking in on you unannounced."
        )
        // println("New survey created: ${survey.value}")

        return NewRound(survey)
    }
}

fun main() {
    DemoApplication().run()
}

