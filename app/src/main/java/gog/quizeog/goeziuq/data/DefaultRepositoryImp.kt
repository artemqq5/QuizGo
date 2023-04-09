package gog.quizeog.goeziuq.data

import gog.quizeog.goeziuq.data.subData.*
import javax.inject.Inject

class DefaultRepositoryImp @Inject constructor(
    private val biology: Biology,
    private val history: History,
    private val programming: Programming,
    private val math: Mathem,
    private val cinema: Cinema
) : DefaultRepository {

    override val listOfQuestionBiology: ArrayList<ModelQuestion>
        get() = biology.questions
    override val listOfQuestionProgramming: ArrayList<ModelQuestion>
        get() = programming.questions
    override val listOfQuestionMath: ArrayList<ModelQuestion>
        get() = math.questions
    override val listOfQuestionHistory: ArrayList<ModelQuestion>
        get() = history.questions
    override val listOfQuestionCinema: ArrayList<ModelQuestion>
        get() = cinema.questions

}