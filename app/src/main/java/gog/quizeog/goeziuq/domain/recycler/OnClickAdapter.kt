package gog.quizeog.goeziuq.domain.recycler

import gog.quizeog.goeziuq.domain.CategoryQuiz
import gog.quizeog.goeziuq.domain.models.ModelQuiz

interface OnClickAdapter {

    fun callMethod(category: ModelQuiz)
}