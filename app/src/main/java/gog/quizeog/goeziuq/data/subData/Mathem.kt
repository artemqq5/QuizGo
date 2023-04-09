package gog.quizeog.goeziuq.data.subData

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import gog.quizeog.goeziuq.R
import gog.quizeog.goeziuq.data.ModelQuestion
import javax.inject.Inject

class Mathem @Inject constructor(@ApplicationContext context: Context) {

    val questions = arrayListOf(
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[0],
            context.resources.getStringArray(R.array.mathem_answer_1)[0],
            context.resources.getStringArray(R.array.mathem_answer_2)[0],
            context.resources.getStringArray(R.array.mathem_answer_right)[0],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[1],
            context.resources.getStringArray(R.array.mathem_answer_1)[1],
            context.resources.getStringArray(R.array.mathem_answer_2)[1],
            context.resources.getStringArray(R.array.mathem_answer_right)[1],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[2],
            context.resources.getStringArray(R.array.mathem_answer_1)[2],
            context.resources.getStringArray(R.array.mathem_answer_2)[2],
            context.resources.getStringArray(R.array.mathem_answer_right)[2],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[3],
            context.resources.getStringArray(R.array.mathem_answer_1)[3],
            context.resources.getStringArray(R.array.mathem_answer_2)[3],
            context.resources.getStringArray(R.array.mathem_answer_right)[3],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[4],
            context.resources.getStringArray(R.array.mathem_answer_1)[4],
            context.resources.getStringArray(R.array.mathem_answer_2)[4],
            context.resources.getStringArray(R.array.mathem_answer_right)[4],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[5],
            context.resources.getStringArray(R.array.mathem_answer_1)[5],
            context.resources.getStringArray(R.array.mathem_answer_2)[5],
            context.resources.getStringArray(R.array.mathem_answer_right)[5],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[6],
            context.resources.getStringArray(R.array.mathem_answer_1)[6],
            context.resources.getStringArray(R.array.mathem_answer_2)[6],
            context.resources.getStringArray(R.array.mathem_answer_right)[6],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[7],
            context.resources.getStringArray(R.array.mathem_answer_1)[7],
            context.resources.getStringArray(R.array.mathem_answer_2)[7],
            context.resources.getStringArray(R.array.mathem_answer_right)[7],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[8],
            context.resources.getStringArray(R.array.mathem_answer_1)[8],
            context.resources.getStringArray(R.array.mathem_answer_2)[8],
            context.resources.getStringArray(R.array.mathem_answer_right)[8],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[9],
            context.resources.getStringArray(R.array.mathem_answer_1)[9],
            context.resources.getStringArray(R.array.mathem_answer_2)[9],
            context.resources.getStringArray(R.array.mathem_answer_right)[9],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.mathem_questions)[10],
            context.resources.getStringArray(R.array.mathem_answer_1)[10],
            context.resources.getStringArray(R.array.mathem_answer_2)[10],
            context.resources.getStringArray(R.array.mathem_answer_right)[10],
        ),
    )
}