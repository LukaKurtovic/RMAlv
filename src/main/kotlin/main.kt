import java.io.Console
import kotlin.random.Random
import java.util.Scanner

fun main() {
    var n: Int
    val hand1 = Hand()

    println("First roll")
    hand1.rollDice()
    println("How many dice do you want to hold?")
    n = Integer.valueOf(readLine())
    hand1.holdDice(n)

    println("Second roll")
    hand1.rollDice()
    println("How many dice do you want to hold?")
    n = Integer.valueOf(readLine())
    hand1.holdDice(n)

    println("Third roll")
    hand1.rollDice()
    println("How many dice do you want to hold?")
    n = Integer.valueOf(readLine())
    hand1.holdDice(n)

}

class Die(var number: Int = 1){
    fun roll(){
        number = Random.nextInt(1, 7)
    }

    override fun toString(): String {
        return "$number"
    }
}

class Hand(var hand: MutableList<Die> = mutableListOf(Die(), Die(), Die(), Die(), Die(), Die()),
           var hold: MutableList<Die> = mutableListOf(),
           var numberOfRolls: Int = 0){
    fun rollDice(){
        for (die in hand){
            die.number = Random.nextInt(1, 7)
            println("Rolled: ${die.number}")
        }
        numberOfRolls++
    }

    fun holdDice(n: Int){
        var indexList = mutableListOf<Int>()
        indexList.clear()
        for (i in 0 until n){
            println("Enter index of the ${i+1}. die you want to hold")
            indexList.add(Integer.valueOf(readLine())-1)
            hold.add(hand[indexList[i]])

        }
        println("Holding: ")
        for (i in 0 until n){
            hand.removeAt(0)
        }
        for(i in 0 until hold.size){
            println(hold[i])
        }
    }
}