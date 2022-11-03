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
    private var add_operator=false
    private var press_equal=false


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

            press_equal=false

            if (resultTextView.text.toString() != "") {
                if (add_operator==false) {
                    operand = resultTextView.text.toString().toDouble()
                    operation = clickedView.text.toString()
                    resultTextView.text = ""
                    add_operator=true
                } else if (resultTextView.text.toString() == ".") {

                    resultTextView.text = "0"

                } else{

                    var result=0.0
                    var secondoperand=resultTextView.text.toString().toDouble()
                    when(operation) {

                        "+" -> result = operand + secondoperand
                        "-" -> result = operand - secondoperand
                        "/" -> result = operand / secondoperand
                        "*" -> result = operand * secondoperand

                    }
                    operand=result
                    resultTextView.text=""
                    operation = clickedView.text.toString()


                }

            }else{

                operation = clickedView.text.toString()

            }

        }

    }

    fun equalsClick(clickedView: View) {

        var secondoperand = resultTextView.text.toString()

        if (secondoperand == ".") {
            secondoperand = "0"
        }

        if (secondoperand == "") {
            secondoperand = operand.toString()
            when (operation) {

                "-" -> resultTextView.text = (operand - secondoperand.toDouble()).toString()
                "*" -> resultTextView.text = (operand * secondoperand.toDouble()).toString()
                "/" -> resultTextView.text = (operand / secondoperand.toDouble()).toString()
                "+" -> resultTextView.text = (operand + secondoperand.toDouble()).toString()

            }
            add_operator = false
            press_equal = true
        } else{


            when (operation) {

                "-" -> resultTextView.text = (operand - secondoperand.toDouble()).toString()
                "*" -> resultTextView.text = (operand * secondoperand.toDouble()).toString()
                "/" -> resultTextView.text = (operand / secondoperand.toDouble()).toString()
                "+" -> resultTextView.text = (operand + secondoperand.toDouble()).toString()

            }
            add_operator=false
            press_equal=true

        }


        if (resultTextView.text.toString().toDouble()==resultTextView.text.toString().toDouble().toInt().toDouble()){
            resultTextView.text=resultTextView.text.toString().toDouble().toInt().toString()

        }else{
            resultTextView.text=resultTextView.text.toString()
        }
        equal_number1+=1


    }

    fun clearClick(clickedView: View) {
        operation=""
        operand = 0.0
        resultTextView.text = "0"
        add_operator=false
        press_equal=false

    }

    fun DelClick(clickedView: View){
        val length=resultTextView.length()
        if (length > 0){
            resultTextView.text=resultTextView.text.subSequence(0,length -1)
            if(length == 0){
                resultTextView.text="0"
            }

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











