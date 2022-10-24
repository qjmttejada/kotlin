package com.example.farecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.farecalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewActivityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ViewActivityModel::class.java)

        binding.calculateButton.setOnClickListener{ calculateFare()}
    }

    private fun calculateFare(){
        val stringInTextField = binding.fareCost.text.toString()
        val cost = stringInTextField.toDouble()
        val id: Int = when (binding.discountOptions.checkedRadioButtonId){
            R.id.option_senior -> 0
            R.id.option_pwd -> 1
            else -> 2
        }
        val roundUp = binding.roundUpSwitch.isChecked
        val discount = viewModel.computeFare(cost,id,roundUp)
        binding.fareResult.text = getString(R.string.total_fare, discount)
    }
}