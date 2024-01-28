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
            Pair(team1, team2)
        )

        println("Game created: $game")

        val round1 = createRound()

        println("Round 1 created: $round1")

        val team1Player1 = TeamPlayer(team1, team1.players[0])
        val team2Player1 = TeamPlayer(team2, team2.players[0])

        println("Round 1: ${team1Player1.player.name} and ${team2Player1.player.name} ready for faceoff")

        val faceOff = round1.startFaceoff()

        println("Round 1 FaceOff: $faceOff")

        faceOff.buzzIn(team1Player1)

        println("Round 1 FaceOff: $faceOff")

        // If good guess, reveal guess.
            // if best guess, pass or play
            // else, other team player guesses
        // else switching guessing team and return

        simulateBestGuessFaceOff(faceOff)
//        simulateGoodGuessFaceOff(faceOff)


        // val guess = Guess("BATHROOM")
        // val guess = Guess("BATHROOM")
//        when(guessResult) {
//            is GoodGuess -> {
//                println("Good guess! Pass or Play?")
//            }
//            is BadGuess -> {
//                println("Bad Guess. ${team2Player1.player.name} can guess.")
//
//                // How do validate that only team 2 can guess?
//            }
//        }
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
            listOf("BATHROOM", "MY BEDROOM", "MY HOUSE", "WORK/OFFICE"),
            "Name a place where you don't like people walking in on you unannounced."
        )
        // println("New survey created: ${survey.value}")

        return NewRound(survey)
    }

    private fun simulateBestGuessFaceOff(faceOff: FaceOff): PlayingRound {
        // Pass in answer object
        // Let faceoff determine next state, best guess, good guess
        // There should be a separate path for bad guess bc the host will call a different mutation
        faceOff.guess()
    }

    private fun simulateGoodGuessFaceOff(faceOff: FaceOff) {
//        faceOff.goodGuess()
    }

    private fun simulateBadGuessFaceOff() {}

    private fun simulateBothBadGuessFaceOff() {}
}

fun main() {
    DemoApplication().run()
}

