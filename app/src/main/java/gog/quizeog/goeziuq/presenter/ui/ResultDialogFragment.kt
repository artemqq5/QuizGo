package gog.quizeog.goeziuq.presenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import gog.quizeog.goeziuq.R
import gog.quizeog.goeziuq.databinding.FragmentResultDialogBinding
import gog.quizeog.goeziuq.domain.CategoryQuiz
import gog.quizeog.goeziuq.domain.models.ModelQuiz

@AndroidEntryPoint
class ResultDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentResultDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments?.getInt("data-result").toString()

        binding.resultPoints.text = args

        binding.restartButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_resultDialogFragment_to_quizFragment, bundleOf(
                    "category" to arguments?.getParcelable<ModelQuiz>("category")
                )
            )
        }

        binding.goMenuButton.setOnClickListener {
            findNavController().navigate(R.id.action_resultDialogFragment_to_menuFragment)
        }


    }
}