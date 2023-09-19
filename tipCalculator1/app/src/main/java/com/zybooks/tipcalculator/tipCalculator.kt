package com.zybooks.tipcalculator

class tipCalculator(cost : Double, tip : Int, people : Int ) {
    var cost = 0.0
        set(value){
            field = if(value >= 0) value else 0.0
        }

    var tip = 0
        set(value){
            field = if(value >= 0) value else 10
        }

    var people = 0
        set(value){
            field = if(value > 0) value else 1
        }

    val tipCalculation : Double
        get(){
            return (tip * cost / 100).toDouble()
        }

    val TotalAmount : Double
        get(){
            return (tipCalculation + cost)
        }

    val splitAmount : Double
        get(){
            return (TotalAmount / people)
        }

    val splitTipAMount : Double
        get(){
            return (tipCalculation / people)
        }

    init{
        this.cost = cost
        this.tip = tip
        this.people = people
    }
}