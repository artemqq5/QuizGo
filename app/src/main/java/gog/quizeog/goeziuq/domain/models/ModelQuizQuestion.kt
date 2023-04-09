package gog.quizeog.goeziuq.domain.models

data class ModelQuizQuestion(
    val question: String,
    val listAnswers: List<String>,
    val rightAnswer: String,
)
