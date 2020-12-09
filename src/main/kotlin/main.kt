val limitMaxOnDay = 15_000_000
val limitMaxOnMounth = 60_000_000
val limitMaxVkPayInMounth = 4_000_000
val limitMaxVkPay = 1_500_000
val amountMaxMasterOnMonth = 7_500_000

fun main() {
    val cardType ="Visa"
    val amoutPrevMonth = 12_0000
    val amountCurrent = 50000

    val amountCurrentMonthOnCard = 50_000
    val amountCardOnDay = 6_000
    val amountVkPayOnMonth = 7_000
    val isPromo = true

    if (amountCurrentMonthOnCard > limitMaxOnMounth ||
        amountCardOnDay > limitMaxOnDay ||
        cardType == "VK pay" && (amountCurrent > limitMaxVkPay || amountVkPayOnMonth > limitMaxVkPayInMounth)) {
            println("Перевод невозможен. Превышение лимитов")
    } else {
        println("Сумма комиссии составляет: " + calculateCommission(cardType, amoutPrevMonth, amountCurrent, isPromo))
    }

}

fun calculateCommission(cardType: String = "VK pay",
                        amoutPrevMonth: Int = 0,
                        amountCurrent: Int,
                        isPromo: Boolean) =
    when {
        ( (cardType == "Mastercard" || cardType == "Maestro") &&
                amoutPrevMonth > amountMaxMasterOnMonth &&
                !isPromo)  -> amountCurrent * 0.006 +2_000
        (cardType == "Visa" || cardType == "Mir")  -> if (amountCurrent * 0.0075 > 3_500) amountCurrent * 0.0075 else 3_500
        else -> 0
    }


