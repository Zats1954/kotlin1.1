import java.util.*

fun main() {
    var lastAmount = 0
    val number1 = Scanner(System.`in`)
    println(
        """Введите номер типа карты/счёта :
             1. MasterCard или Maestro 
             2. Visa или Мир
             3. VK Pay
        """
    )
    val typeCard = number1.nextInt()
    if (typeCard in 1..3) {
        when (typeCard) {
            1, 3 -> {
                print("Введите сумму предыдущих переводов в этом месяце (руб.): ")
                lastAmount = number1.nextInt() * 100
            }
        }
        print("Введите сумму перевода (руб.): ")
        val amount = number1.nextInt() * 100

        val rate = when (typeCard) {
            1 -> rateMaestro(amount, lastAmount)
            2 -> rateVisa(amount)
            3 -> rateVKPay(amount, lastAmount)
            else -> null
        }
        if (rate != null) {
            print("сумма перевода: " + amount + " коп., комиссия = " + rate + " коп.")
        } else {
            print("Перевод ${amount / 100} руб. невозможен")
        }
    } else {
        print("Неправильный номер. Надо 1,2 или 3")
    }
}


fun rateMaestro(amount: Int, lastAmount: Int): Int? {
    if (lastAmount + amount > 600_000_00
        || amount > 150_000_00
    ) return null                               // restricted summ
    if (lastAmount in 30000..7499999) return 0 // promotion
    val rate = (amount * 0.006).toInt() + 2000
    return if (rate < 0) null else rate
}


fun rateVisa(amount: Int): Int? {
    var rate = (amount * 0.0075).toInt()
    if ((rate) < 3500) rate = 3500
    return if (rate < 0 || amount < rate) {
        null
    } else {
        rate
    }
}

fun rateVKPay(amount: Int, lastAmount: Int): Int? {
    return if (lastAmount + amount > 40_000_00
               || amount > 15_000_00)
    null                                // restricted summ
           else
    0
}
