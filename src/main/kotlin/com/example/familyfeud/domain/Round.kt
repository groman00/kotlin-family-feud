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
    fun buzzIn() {}
}