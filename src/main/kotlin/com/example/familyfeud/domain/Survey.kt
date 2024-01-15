package com.example.familyfeud.domain

sealed interface Survey {
    val answers: List<String>
}

data class NewSurvey(
    override val answers: List<String>,
    private val value: String
) : Survey {
    fun reveal(): RevealedSurvey {
        return RevealedSurvey(answers, value)
    }
}

data class RevealedSurvey(
    override val answers: List<String>,
    val value: String
) : Survey


