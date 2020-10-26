import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.ByteArrayInputStream
import java.util.*


class MainKtTest {

    @Test
    fun rateMaestro_excideLast() {
        val lastAmount = 55000000
        val amount = 10000000
        val result = rateMaestro(amount, lastAmount)
        assertEquals(0, result)
    }

    @Test
    fun rateMaestro_excideAmount() {
        val lastAmount = 40000000
        val amount = 16000000
        val result = rateMaestro(amount, lastAmount)
        assertEquals(0, result)
    }

    @Test
    fun rateMaestro_inAction() {
        val lastAmount = 4000000
        val amount = 2600000
        val result = rateMaestro(amount, lastAmount)
        assertEquals(0, result)
    }

    @Test
    fun rateMaestro_weak() {
        val lastAmount = 20000
        val amount = 2000
        val result = rateMaestro(amount, lastAmount)
        assertEquals(null, result)
    }

    @Test
    fun rateMaestro_simple() {
        val lastAmount = 28000
        val amount = 22000
        val result = rateMaestro(amount, lastAmount)
        assertEquals(2132, result)
    }

    @Test
    fun rateVisa_max() {
        val amount = 500000
        val result = rateVisa(amount)
        assertEquals(3750, result)
    }

    @Test
    fun rateVisa_min() {
        val amount = 3400
        val result = rateVisa(amount)
        assertEquals(null, result)
    }

    @Test
    fun rateVisa_simple() {
        val amount = 400000
        val result = rateVisa(amount)
        assertEquals(3500, result)
    }

    @Test
    fun rateVKPay_maxLast() {
        val lastAmount = 3500000
        val amount = 1000000
        val result = rateVKPay(amount, lastAmount)
        assertEquals(null, result)
    }

    @Test
    fun rateVKPay_maxAmount() {
        val lastAmount = 2000000
        val amount = 1600000
        val result = rateVKPay(amount, lastAmount)
        assertEquals(null, result)
    }

    @Test
    fun rateVKPay_simple() {
        val lastAmount = 2400000
        val amount = 1400000
        val result = rateVKPay(amount, lastAmount)
        assertEquals(0, result)
    }

//    @Test
//    fun main_simple() {
//        val `in` = ByteArrayInputStream("1 \n 1000".toByteArray())
//        System.setIn(`in`)
//        val keyboard = Scanner(`in`)
//        val input: Int = keyboard.nextInt()
//        val newinput:Int =  keyboard.nextInt()
//        val result = main()
//        assertEquals(0, result)
//    }
}