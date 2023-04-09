package gog.quizeog.goeziuq.presenter.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import gog.quizeog.goeziuq.R
import gog.quizeog.goeziuq.databinding.FragmentQuizBinding
import gog.quizeog.goeziuq.domain.CategoryQuiz
import gog.quizeog.goeziuq.domain.models.ModelQuiz
import gog.quizeog.goeziuq.domain.models.ModelQuizQuestion
import gog.quizeog.goeziuq.presenter.vm.ViewModelQuiz
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("SetTextI18n")
@AndroidEntryPoint
class QuizFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentQuizBinding

    private val viewModelQuiz by activityViewModels<ViewModelQuiz>()

    var currentQuiz: ModelQuizQuestion? = null

    var guessedQuestion = 0
    var counterQuestion = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelQuiz.quizQuestion.observe(viewLifecycleOwner) { listQuestion ->
            viewModelQuiz.currentQuestion.observe(viewLifecycleOwner) { question ->
                binding.questionCounter.text = "Question ${question + 1} / ${listQuestion.size}"
                currentQuiz = listQuestion[question]
                setQuestion(listQuestion[question])

                binding.questionAnswer1.isEnabled = true
                binding.questionAnswer2.isEnabled = true
                binding.questionAnswer3.isEnabled = true
            }
        }

        val args = arguments?.getParcelable<ModelQuiz>("category")

        args?.let {
            viewModelQuiz.setNewQuestionList(it.title)
            counterQuestion = it.count
        }



        binding.questionAnswer1.setOnClickListener(this)
        binding.questionAnswer2.setOnClickListener(this)
        binding.questionAnswer3.setOnClickListener(this)

    }

    private fun setQuestion(modelQuizQuestion: ModelQuizQuestion) {
        binding.questionText.text = modelQuizQuestion.question
        binding.questionAnswer1.text = modelQuizQuestion.listAnswers[0]
        binding.questionAnswer2.text = modelQuizQuestion.listAnswers[1]
        binding.questionAnswer3.text = modelQuizQuestion.listAnswers[2]
    }

    override fun onClick(p0: View?) {
        binding.questionAnswer1.isEnabled = false
        binding.questionAnswer2.isEnabled = false
        binding.questionAnswer3.isEnabled = false

        setReaction(p0 as Button)
    }

    private fun setReaction(view: Button) {

        lifecycleScope.launch(Dispatchers.Main) {
            view.setCompoundDrawablesWithIntrinsicBounds(
                null,
                null,
                ContextCompat.getDrawable(
                    requireContext(),
                    if (view.text == currentQuiz?.rightAnswer) {
                        guessedQuestion++
                        R.drawable.ic_true
                    } else R.drawable.ic_false
                ),
                null
            )

            delay(500)

            try {
                Log.i("myLog", "counterQuestion = ${counterQuestion}")
                Log.i("myLog", "value + 1 = ${viewModelQuiz.currentQuestion.value!! + 1}")
                if (viewModelQuiz.currentQuestion.value!! + 1 < counterQuestion) {
                    viewModelQuiz.nextQuestion(viewModelQuiz.currentQuestion.value!! + 1)
                } else {
                    findNavController().navigate(
                        R.id.action_quizFragment_to_resultDialogFragment,
                        bundleOf(
                            "data-result" to guessedQuestion,
                            "category" to arguments?.getParcelable<ModelQuiz>("category")
                        )
                    )
                }
            } catch (e: Exception) {
                Log.i("myLog", e.toString())
            }


            view.setCompoundDrawablesWithIntrinsicBounds(
                null,
                null,
                null,
                null
            )

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModelQuiz.nextQuestion(0)
    }

}