package com.zybooks.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.view.View
import org.w3c.dom.Text
import java.time.temporal.TemporalAmount

class MainActivity : AppCompatActivity() {

    private lateinit var billAmount: EditText
    private lateinit var tipAmount : EditText
    private lateinit var howManyPeople : EditText
    private lateinit var splitAmountTextView: TextView
    private lateinit var splitTipTextView : TextView
    private lateinit var totalPayTextView : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        billAmount = findViewById(R.id.enterBill)
        tipAmount = findViewById(R.id.enterTip)
        howManyPeople = findViewById(R.id.enterSplit)
        totalPayTextView = findViewById(R.id.amountPayLabel)
        splitAmountTextView = findViewById(R.id.totalSplitLabel)
        splitTipTextView = findViewById(R.id.tipSplitLabel)
    }

    fun calculateTip(view : View){

        //Get input
        val billStr = billAmount.text.toString()
        val tipStr = tipAmount.text.toString()
        val howManyStr = howManyPeople.text.toString()

        //Convert string to number and verified if not null or assign 0
        val bill = billStr.toDoubleOrNull() ?: 0.00
        val tipPercentage = tipStr.toDoubleOrNull() ?: 10.00
        val howMany = howManyStr.toIntOrNull() ?: 1

        val tipCalc = (tipPercentage * bill / 100).toDouble()
        val totalAmount = tipCalc + bill

        totalPayTextView.text = String.format("$%.2f",totalAmount)
        splitAmountTextView.text = String.format("$%.2f", totalAmount / howMany)
        splitTipTextView.text = String.format("$%.2f", tipCalc / howMany)
    }
}