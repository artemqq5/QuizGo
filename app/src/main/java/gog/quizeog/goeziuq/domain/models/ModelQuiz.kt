package gog.quizeog.goeziuq.domain.models

import android.os.Parcelable
import gog.quizeog.goeziuq.domain.CategoryQuiz

import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelQuiz(
    val title: CategoryQuiz,
    val img: Int,
    val count: Int
): Parcelable
