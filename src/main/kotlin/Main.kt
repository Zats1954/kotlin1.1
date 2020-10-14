import java.util.*

fun main() {
    val number1 = Scanner(System.`in`)
    print("Введите сумму перевода (руб.): ")
    val amount = number1.nextInt()*100
    var rate = (amount * 0.0075).toInt()
    if((rate) < 3500) rate = 3500
    print("amount: " + amount + " коп., rate = " + rate + " коп.")
}

