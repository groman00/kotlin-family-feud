package com.example.familyfeud.domain

data class Answer(
    val ranking: Int,
    val value: String
)

sealed interface Survey {
    val answers: List<Answer>
}

data class NewSurvey(
    override val answers: List<Answer>,
    private val value: String
) : Survey {
    fun reveal(): RevealedSurvey {
        return RevealedSurvey(answers, value)
    }
}

data class RevealedSurvey(
    override val answers: List<Answer>,
    val value: String
) : Survey


