package gog.quizeog.goeziuq.presenter.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gog.quizeog.goeziuq.domain.CategoryQuiz
import gog.quizeog.goeziuq.domain.MixQuestion
import gog.quizeog.goeziuq.domain.models.ModelQuizQuestion
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelQuiz @Inject constructor(
    private val mixQuestion: MixQuestion
) : ViewModel() {

    private val mutableQuizQuestion = MutableLiveData<List<ModelQuizQuestion>>()
    val quizQuestion: LiveData<List<ModelQuizQuestion>> = mutableQuizQuestion

    fun setNewQuestionList(category: CategoryQuiz) {
        mutableQuizQuestion.value = (mixQuestion.getQuizQuestionModel(category).shuffled())
    }

    private val mutableCurrentQuestion = MutableLiveData(0)
    val currentQuestion: LiveData<Int> = mutableCurrentQuestion

    fun nextQuestion(num: Int) {
        mutableCurrentQuestion.value = num
    }

}
