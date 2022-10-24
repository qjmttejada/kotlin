package com.example.farecalculator

import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class ViewActivityModel: ViewModel() {

    public var farecost:Double = 0.00

    fun computeFare(cost:Double, disc:Int, roundUp:Boolean): String {

        val discountPercentage = when (disc) {
            0 -> 0.20
            1 -> 0.10
            else -> 0.05
        }
        farecost = (cost - (discountPercentage * cost))

        if (roundUp){
            farecost = (cost - (discountPercentage * cost)) * 2

        }

        return NumberFormat.getCurrencyInstance().format(farecost)

    }
}