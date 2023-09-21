package com.zybooks.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.view.View
import android.widget.Toast
import org.w3c.dom.Text
import java.lang.NumberFormatException
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

        //Checking for empty or invalid input
        if(billStr.isEmpty() || tipStr.isEmpty() || howManyStr.isEmpty()){
            Toast.makeText(this,"Please fill in the fields", Toast.LENGTH_SHORT).show()
        }

        try {
            //Convert string to number and verified if not null or assign 0
            val bill = billStr.toDouble()
            val tipPercentage = tipStr.toInt()
            val howMany = howManyStr.toInt()

            //Input validation check
            if (bill < 0 || tipPercentage < 0 || howMany <= 0){
                Toast.makeText(this,"Invalid input. Enter positive values", Toast.LENGTH_SHORT).show()
                return
            }

            val calc = tipCalculator(bill, tipPercentage, howMany)
            val totalAmount = calc.TotalAmount
            val eachAmount = calc.splitAmount
            val eachTip = calc.splitTipAMount

            val totalText = getString(R.string.total_num, totalAmount)
            val totalSplitText = getString(R.string.totalSplit_num, eachAmount)
            val tipSplitText = getString(R.string.tipSplit_num, eachTip)

            totalPayTextView.text = totalText
            splitAmountTextView.text = totalSplitText
            splitTipTextView.text = tipSplitText
        }catch (e : NumberFormatException){
            Toast.makeText(this,"Invalid input. Enter valid numbers", Toast.LENGTH_SHORT).show()
        }
    }
}