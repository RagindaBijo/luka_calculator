package com.example.calculator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand = 0.0
    private var operation = ""
    private var equal_number1=0
    private var equal_number2=0
    private var operation_number=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }


    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {

            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if(equal_number2<equal_number1){
                text=""
                equal_number2+=1
            }

            if(text == "0"){
                text=""
            }


            val result = text + number
            resultTextView.text = result

        }
    }


    fun operationClick(clickedView: View) {
        if (clickedView is TextView) {
            operation_number = 1
            if (operation_number == 1) {

            }


            if (resultTextView.text.toString() != "") {
                operand = resultTextView.text.toString().toDouble()
                operation = clickedView.text.toString()
                resultTextView.text = ""

            } else if (resultTextView.text.toString() == ".") {
                resultTextView.text = "0"

            } else {
                operation = clickedView.text.toString()
            }


        }
    }

    fun equalsClick(clickedView: View) {

        var secondoperand=resultTextView.text.toString()

        if (secondoperand =="."){
            secondoperand ="0"
        }

        if(secondoperand == ""){
            secondoperand =operand.toString()
            when (operation) {

                "-" -> resultTextView.text = (operand - secondoperand.toDouble()).toString()
                "*" -> resultTextView.text = (operand * secondoperand.toDouble()).toString()
                "/" -> resultTextView.text = (operand / secondoperand.toDouble()).toString()
                "+" -> resultTextView.text = (operand + secondoperand.toDouble()).toString()

            }

        }


        when (operation) {

            "-" -> resultTextView.text = (operand - secondoperand.toDouble()).toString()
            "*" -> resultTextView.text = (operand * secondoperand.toDouble()).toString()
            "/" -> resultTextView.text = (operand / secondoperand.toDouble()).toString()
            "+" -> resultTextView.text = (operand + secondoperand.toDouble()).toString()

        }


        if (resultTextView.text.toString().toDouble()==resultTextView.text.toString().toDouble().toInt().toDouble()){
            resultTextView.text=resultTextView.text.toString().toDouble().toInt().toString()

        }else{
            resultTextView.text=resultTextView.text.toString()
        }
        equal_number1+=1
        operation_number=0

    }

    fun clearClick(clickedView: View) {
        operation=""
        operand = 0.0
        resultTextView.text = "0"

    }

    fun DelClick(clickedView: View){
        val length=resultTextView.length()
        if (length > 0){
            resultTextView.text=resultTextView.text.subSequence(0,length -1)

        }
    }


    fun decimal_Click(clickedView: View){

        if(clickedView is TextView) {
            var text = resultTextView.text.toString()
            var Decimal = clickedView.text.toString()

            if(resultTextView.text.toString( )== ""){
                resultTextView.text="0."
            } else if("." !in resultTextView.text.toString()){
                resultTextView.text=text+Decimal
            }



        }

    }

}











