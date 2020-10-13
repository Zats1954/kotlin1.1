import java.util.*

fun main() {
    val number1 = Scanner(System.`in`)
    print("Введите сумму перевода (руб.): ")
    val amount = number1.nextInt()*100
    val rate = (amount * 0.0075 + 3500).toInt()
    print("amount: " + amount + " коп., rate = " + rate + " коп.")
}

