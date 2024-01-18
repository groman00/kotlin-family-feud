package com.example.familyfeud.domain

sealed interface Round {
    val survey: Survey
}

data class NewRound(
    override val survey: NewSurvey
) : Round {
    fun startRound(): StartedRound {
        val revealedSurvey = survey.reveal()
        println("Survey Revealed: ${revealedSurvey.value}")
        return StartedRound(revealedSurvey)
    }
}

data class StartedRound(
    override val survey: RevealedSurvey
) : Round {
    fun buzzIn(teamPlayer: TeamPlayer, guess: Guess): Guess {
        println("$teamPlayer buzzed in with: $guess?")
        survey.answers.find { it == guess.value }?.let {
            return GoodGuess(guess.value)
        }

        return BadGuess(guess.value)
    }
}