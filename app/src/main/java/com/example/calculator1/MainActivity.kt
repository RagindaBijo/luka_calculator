package com.example.calculator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand = 0.0
    private var operation = ""
    private var equalNumber1=0
    private var equalNumber2=0
    private var addoperator=false
    private var pressequal=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }


    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {

            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if(equalNumber2<equalNumber1){
                text=""
                equalNumber2+=1
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

            pressequal=false

            if (resultTextView.text.toString() != "") {
                if (!addoperator) {
                    operand = resultTextView.text.toString().toDouble()
                    operation = clickedView.text.toString()
                    resultTextView.text = ""
                    addoperator=true
                } else if (resultTextView.text.toString() == ".") {

                    resultTextView.text = "0"

                } else{

                    var result=0.0
                    val secondoperand=resultTextView.text.toString().toDouble()
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
//gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg


    fun equalsClick(clickedView: View) {
        if (clickedView is TextView){
            var secondoperand = resultTextView.text.toString().toDouble()

            if (secondoperand.toString()== ".") {
                secondoperand=0.0
            }

            if (secondoperand.toString() == "") {
                secondoperand = operand
                var result=0.0
                when (operation) {

                    "-" -> result = (operand - secondoperand)
                    "*" -> result=  (operand * secondoperand)
                    "/" -> result = (operand / secondoperand)
                    "+" -> result = (operand + secondoperand)


                }
                resultTextView.text=result.toString()
                addoperator = false
                pressequal = true
            } else {
                var result=0.0

                when (operation) {

                    "-" -> result = (operand - secondoperand)
                    "*" -> result = (operand * secondoperand)
                    "/" -> result = (operand / secondoperand)
                    "+" -> result = (operand + secondoperand)

                }

                resultTextView.text=result.toString()
                addoperator = false
                pressequal = true

            }


            if (resultTextView.text.toString().toDouble() == resultTextView.text.toString().toDouble()
                    .toInt().toDouble()
            ) {
                resultTextView.text = resultTextView.text.toString().toDouble().toInt().toString()

            } else {
                resultTextView.text = resultTextView.text.toString()
            }
            equalNumber1 += 1

        }
    }

    //gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg

    fun clearClick(clickedView: View) {
        if(clickedView is TextView){
            operation = ""
            operand = 0.0
            resultTextView.text = "0"
            addoperator = false
            pressequal = false
        }
    }

    fun delClick(clickedView: View){
            if(clickedView is TextView){
            val length=resultTextView.length()
            if (length > 0){
                resultTextView.text=resultTextView.text.subSequence(0,length -1)
                if(length == 1){
                    resultTextView.text="0"
                }

            }
        }
    }


    fun decimalClick(clickedView: View){

        if(clickedView is TextView) {
            val text = resultTextView.text.toString()
            val decimal = clickedView.text.toString()

            if(resultTextView.text.toString( )== ""){
                resultTextView.text="0."
            } else if("." !in resultTextView.text.toString()){

                val result=text+decimal
                resultTextView.text=result
            }

        }

    }

}











