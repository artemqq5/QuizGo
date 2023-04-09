package gog.quizeog.goeziuq.domain.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import gog.quizeog.goeziuq.R
import gog.quizeog.goeziuq.data.DefaultRepository
import gog.quizeog.goeziuq.databinding.ItemQuizBinding
import gog.quizeog.goeziuq.domain.CategoryQuiz
import gog.quizeog.goeziuq.domain.models.ModelQuiz
import javax.inject.Inject


class RecyclerAdapterQuiz @Inject constructor(private val repository: DefaultRepository) :
    RecyclerView.Adapter<RecyclerAdapterQuiz.ViewHolder>() {

    var callBack: OnClickAdapter? = null

    private val listQuiz = listOf(
        ModelQuiz(
            CategoryQuiz.Mathem,
            R.drawable.ic_math,
            repository.listOfQuestionMath.size
        ),
        ModelQuiz(
            CategoryQuiz.Biology,
            R.drawable.ic_biology,
            repository.listOfQuestionBiology.size
        ),
        ModelQuiz(
            CategoryQuiz.Cinema,
            R.drawable.ic_film,
            repository.listOfQuestionCinema.size
        ),
        ModelQuiz(
            CategoryQuiz.Programming,
            R.drawable.ic_prog,
            repository.listOfQuestionProgramming.size
        ),
        ModelQuiz(
            CategoryQuiz.History,
            R.drawable.ic_history,
            repository.listOfQuestionHistory.size
        ),
    )

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemQuizBinding.bind(view)

        fun bindItem(item: ModelQuiz, position: Int) {

            if (position == 0 || position == listQuiz.size) {
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(
                    binding.root.marginLeft,
                    binding.root.marginTop + 100,
                    binding.root.marginRight,
                    binding.root.marginBottom
                )
                binding.root.layoutParams = params
            }

            binding.labelCard.text = item.title.toString()
            binding.imgCard.setImageResource(item.img)
            binding.questionCount.text = item.count.toString()

            binding.root.setOnClickListener {
                callBack?.callMethod(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_quiz, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listQuiz[position], position)
    }

    override fun getItemCount() = listQuiz.size
}