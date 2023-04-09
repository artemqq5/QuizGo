package gog.quizeog.goeziuq.data

import javax.inject.Inject

interface DefaultRepository {

    val listOfQuestionBiology: ArrayList<ModelQuestion>
    val listOfQuestionProgramming: ArrayList<ModelQuestion>
    val listOfQuestionMath: ArrayList<ModelQuestion>
    val listOfQuestionHistory: ArrayList<ModelQuestion>
    val listOfQuestionCinema: ArrayList<ModelQuestion>

}