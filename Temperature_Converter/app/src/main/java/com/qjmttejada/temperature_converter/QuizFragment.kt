package com.qjmttejada.temperature_converter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.qjmttejada.temperature_converter.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    lateinit var binding: FragmentQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        binding = FragmentQuizBinding.inflate(layoutInflater)
        binding.submitQuiz.setOnClickListener {

            val question1 = when (binding.quizChoices1.checkedRadioButtonId) {
                R.id.q1_c2 -> 1
                else -> 0
            }

            val question2 = when (binding.quizChoices2.checkedRadioButtonId) {
                R.id.q2_c1 -> 1
                else -> 0
            }

            val question3 = when (binding.quizChoices3.checkedRadioButtonId) {
                R.id.q3_c1 -> 1
                else -> 0
            }

            val question4 = when (binding.quizChoices4.checkedRadioButtonId) {
                R.id.q4_c3 -> 1
                else -> 0
            }

            val question5 = when (binding.quizChoices5.checkedRadioButtonId) {
                R.id.q5_c2 -> 1
                else -> 0
            }

            val score = (question1 + question2 + question3 + question4 + question5)

            if (score <= 3) {
                Toast.makeText(
                    activity,
                    "Your score is $score. Better luck next time #huhuhu",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else if (score == 4) {
                Toast.makeText(
                    activity,
                    "Your score is $score. Nice! almost perfect.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else {
                Toast.makeText(
                    activity,
                    "Your score is $score. Perfect!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }

}