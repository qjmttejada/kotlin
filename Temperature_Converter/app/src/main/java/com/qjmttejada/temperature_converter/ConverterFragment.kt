package com.qjmttejada.temperature_converter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qjmttejada.temperature_converter.databinding.FragmentConverterBinding
import java.text.DecimalFormat


class ConverterFragment() : Fragment() {

    //Activity Binding
    lateinit var binding: FragmentConverterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = FragmentConverterBinding.inflate(layoutInflater)
        binding.btnConvert.setOnClickListener {
            temperatureConverter()
        }
        return binding.root
    }

    private fun temperatureConverter(){
        val stringInTextField = binding.editInput.text.toString()
        val resultText: String
        val resultText2: String

        if (stringInTextField.isNotEmpty()) {
            val df = DecimalFormat("#.##")
            val temp = stringInTextField.toDouble()
            val selectedUnit = when(binding.selectUnit.checkedRadioButtonId) {
                R.id.btnCelsius -> "Celsius"
                R.id.btnFahrenheit -> "Fahrenheit"
                else -> "Kelvin"
            }
            if(selectedUnit == "Fahrenheit"){
                resultText = df.format((temp - 32) * 5 / 9)
                resultText2 = df.format(((temp - 32) * 5 / 9) + 273.15)
                binding.textResultType.text = "Celsius"
                binding.textResultType2.text = "Kelvin"
            }
            else if(selectedUnit == "Celsius"){
                resultText = df.format((temp *9/5)+32)
                resultText2 = df.format((temp + 273.15))
                binding.textResultType.text = "Fahrenheit"
                binding.textResultType2.text = "Kelvin"
            }
            else{
                resultText = df.format((temp - 273.15))
                resultText2 = df.format(((temp - 273.15) * 9 / 5 ) + 32)
                binding.textResultType.text = "Celsius"
                binding.textResultType2.text = "Fahrenheit"
            }

            binding.textResult.text = resultText
            binding.textResult2.text = resultText2
        }

    }

}