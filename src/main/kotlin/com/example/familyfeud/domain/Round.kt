package com.example.familyfeud.domain

sealed interface Round {
    val survey: Survey
}

data class NewRound(
    override val survey: NewSurvey
) : Round {
    fun startFaceoff(): FaceOff {
        val revealedSurvey = survey.reveal()
        println("Survey Revealed: ${revealedSurvey.value}")
        return FaceOff(revealedSurvey)
    }
}

data class FaceOff(
    override val survey: RevealedSurvey
) : Round {
    private lateinit var guessingTeam: Team
    fun buzzIn(teamPlayer: TeamPlayer): FaceOff {
        println("$teamPlayer buzzed in")

        guessingTeam = teamPlayer.team
//        survey.answers.find { it == guess.value }?.let {
//            return GoodGuess(guess.value)
//        }
//        return BadGuess(guess.value)
        return this
    }

    fun guess(answer: Answer) {
        if (answer.ranking == 0) {
            // best answer
            // reveal answer
            // return to pass or play
            return
        }
//        guessingTeam = other team

    }

//    fun bestGuess(): PlayingRound {
//        return PlayingRound(
//            survey,
//            PlayingTeam(guessingTeam.players)
//        )
//    }
//
//    fun goodGuess() {
//
//    }
}

data class PlayingRound(
    override val survey: RevealedSurvey,
    val playingTeam: PlayingTeam
): Round {

}