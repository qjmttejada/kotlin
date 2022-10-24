package com.qjmttejada.conversionapp_viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.qjmttejada.conversionapp_viewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TempConverterViewModel
    private lateinit var textView: TextView
    private lateinit var liveData: TempConverterLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TempConverterViewModel::class.java)

        binding.btnConvert.setOnClickListener {
            temperatureConverter()
        }

        textView=findViewById(R.id.conversionCountTxt)
        liveData = ViewModelProvider(this).get(TempConverterLiveData::class.java)
        var count: LiveData<Int> = liveData.getInitialcount()
        count.observe(this, Observer {
            textView.text = "Converstion Count: $it"
        })
    }

    private fun temperatureConverter(){
        val stringInTextField = binding.editInput.text.toString()
        if (stringInTextField.isNotEmpty()) {

            val temp = stringInTextField.toDouble()
            val selectedUnit = when(binding.selectUnit.checkedRadioButtonId) {
                R.id.btnCelsius -> "Celsius"
                R.id.btnFahrenheit -> "Fahrenheit"
                else -> "Kelvin"
            }

            val (resultText1, resultUnit1) = viewModel.tempConverter1(temp, selectedUnit)
            val (resultText2, resultUnit2) = viewModel.tempConverter2(temp, selectedUnit)

            binding.textResult.text = resultText1
            binding.textResult2.text = resultText2
            binding.textResultType.text = resultUnit1
            binding.textResultType2.text = resultUnit2

            liveData.getCurrentCount() //Live Data Count
        }
        else{
            Toast.makeText(this, "No Temperature Value entered!",
                            Toast.LENGTH_SHORT).show()
            binding.textResult.text = "0.0"
            binding.textResult2.text = "0.0"
            return
        }
    }
}