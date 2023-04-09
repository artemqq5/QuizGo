package gog.quizeog.goeziuq.domain

import gog.quizeog.goeziuq.data.DefaultRepository
import gog.quizeog.goeziuq.domain.models.ModelQuizQuestion
import javax.inject.Inject

class MixQuestion @Inject constructor(private val repository: DefaultRepository) {

    fun getQuizQuestionModel(category: CategoryQuiz): List<ModelQuizQuestion> {

        val list = when (category) {
            CategoryQuiz.Mathem -> repository.listOfQuestionMath
            CategoryQuiz.Biology -> repository.listOfQuestionBiology
            CategoryQuiz.Cinema -> repository.listOfQuestionCinema
            CategoryQuiz.Programming -> repository.listOfQuestionProgramming
            CategoryQuiz.History -> repository.listOfQuestionHistory
        }

        return list.map {
            ModelQuizQuestion(
                it.question,
                listAnswers = listOf(
                    it.answer1,
                    it.answer2,
                    it.rightAnswer
                ).shuffled(),
                it.rightAnswer
            )
        }

    }

}