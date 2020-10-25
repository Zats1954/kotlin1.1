import java.util.*


enum class CardType(val number: Int){
    MAESTRO(1),
    VISA(2),
    VKPAY(3)
}

fun main() {

    var lastAmount = 0
    val scanner = Scanner(System.`in`)
    println(
        """Введите номер типа карты/счёта :
             ${CardType.MAESTRO.number}. MasterCard или Maestro 
             ${CardType. VISA.number}. Visa или Мир
             ${CardType.VKPAY.number}. VK Pay
        """
    )
    val typeCard = scanner.nextInt()
    try{
        val myCard = CardType.values()[typeCard - 1]
        if (myCard == CardType.MAESTRO || myCard == CardType.VKPAY) {
            print("Введите сумму предыдущих переводов в этом месяце (руб.): ")
            lastAmount = scanner.nextInt() * 100
        }
        print("Введите сумму перевода (руб.): ")
        val amount = scanner.nextInt() * 100

        val rate = when (myCard) {
            CardType.MAESTRO -> rateMaestro(amount, lastAmount)
            CardType.VISA -> rateVisa(amount)
            CardType.VKPAY -> rateVKPay(amount, lastAmount)
        }
        if (rate != null) {
            println("сумма перевода: $amount коп., комиссия = $rate коп.")
        } else {
            println("Перевод ${amount / 100} руб. невозможен")
        }
    } catch(e:ArrayIndexOutOfBoundsException ) {
        println("Неправильный номер. Надо 1,2 или 3")
    }
}


fun rateMaestro(amount: Int, lastAmount: Int): Int? {
    if (lastAmount + amount > 600_000_00
        || amount > 150_000_00
    ) return null                               // restricted summ
    if (lastAmount in 30000..7499999) return 0 // promotion
    val rate = (amount * 0.006).toInt() + 2000
    return if (rate > amount|| rate < 0) null else rate
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
