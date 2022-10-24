package com.qjmttejada.conversionapp_viewmodellivedata

import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class TempConverterViewModel: ViewModel() {

    public var result1:Double = 0.00
    public var result2:Double = 0.00
    public var unit1:String = ""
    public var unit2:String = ""

    data class temp1(var return1:String, var type1:String)
    data class temp2(var return2:String, var type2:String)

    val df = DecimalFormat("#.##")

    fun tempConverter1(input:Double, unit:String): temp1 {

        if(unit == "Fahrenheit"){
             result1 = ((input - 32) * 5 / 9)
             unit1 = "Celsius"
        }
        else if(unit == "Celsius"){
            result1 = ((input *9/5)+32)
            unit1 = "Fahrenheit"
        }
        else{
            result1 = ((input - 273.15))
            unit1 = "Celsius"
        }

        return temp1(df.format(result1), unit1)
    }

    fun tempConverter2(input:Double, unit:String): temp2{

        if(unit == "Fahrenheit"){
            result2 = (((input - 32) * 5 / 9) + 273.15)
            unit2 = "Kelvin"
        }
        else if(unit == "Celsius"){
            result2 = ((input + 273.15))
            unit2 = "Kelvin"
        }
        else{
            result2 = (((input - 273.15) * 9 / 5 ) + 32)
            unit2 = "Fahrenheit"
        }

        return temp2(df.format(result2), unit2)
    }

}