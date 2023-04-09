package gog.quizeog.goeziuq.data.subData

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import gog.quizeog.goeziuq.R
import gog.quizeog.goeziuq.data.ModelQuestion
import javax.inject.Inject

class Biology @Inject constructor(@ApplicationContext context: Context) {

    val questions = arrayListOf(
        ModelQuestion(
            context.resources.getStringArray(R.array.biology_questions)[0],
            context.resources.getStringArray(R.array.biology_answer_1)[0],
            context.resources.getStringArray(R.array.biology_answer_2)[0],
            context.resources.getStringArray(R.array.biology_answer_right)[0],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.biology_questions)[1],
            context.resources.getStringArray(R.array.biology_answer_1)[1],
            context.resources.getStringArray(R.array.biology_answer_2)[1],
            context.resources.getStringArray(R.array.biology_answer_right)[1],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.biology_questions)[2],
            context.resources.getStringArray(R.array.biology_answer_1)[2],
            context.resources.getStringArray(R.array.biology_answer_2)[2],
            context.resources.getStringArray(R.array.biology_answer_right)[2],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.biology_questions)[3],
            context.resources.getStringArray(R.array.biology_answer_1)[3],
            context.resources.getStringArray(R.array.biology_answer_2)[3],
            context.resources.getStringArray(R.array.biology_answer_right)[3],
        ),
        ModelQuestion(
            context.resources.getStringArray(R.array.biology_questions)[4],
            context.resources.getStringArray(R.array.biology_answer_1)[4],
            context.resources.getStringArray(R.array.biology_answer_2)[4],
            context.resources.getStringArray(R.array.biology_answer_right)[4],
        ),
    )

}