package gog.quizeog.goeziuq.presenter.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import gog.quizeog.goeziuq.R
import gog.quizeog.goeziuq.databinding.FragmentMenuBinding
import gog.quizeog.goeziuq.domain.models.ModelQuiz
import gog.quizeog.goeziuq.domain.recycler.OnClickAdapter
import gog.quizeog.goeziuq.domain.recycler.RecyclerAdapterQuiz
import javax.inject.Inject

@AndroidEntryPoint
class MenuFragment : Fragment(), OnClickAdapter {

    private lateinit var binding: FragmentMenuBinding

    @Inject
    lateinit var adapterQuiz: RecyclerAdapterQuiz

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerQuiz.also {
            adapterQuiz.callBack = this
            it.adapter = adapterQuiz
        }

    }

    override fun callMethod(category: ModelQuiz) {
        Log.i("myLog", "des = ${findNavController().currentDestination?.label}")
        if (findNavController().currentDestination?.label == "fragment_menu") {
            findNavController().navigate(
                R.id.action_menuFragment_to_quizFragment, bundleOf(
                    "category" to category
                )
            )
        }

    }

}