fun main() {


    println("Добро пожаловать в систему перевода денежных средств.\n(минимальная сумма перевода - 100 рублей)")

    while (true) {
        println("Если хотите совершить новый перевод, введите - 1. Если хотите выйти - 0.")
        val input = readln().toInt()
        if (input == 1) {
            print("Введите сумму перевода в рублях, чтобы узнать размер комиссии: ")
            val transferAmount = getTransferAmount()
            val commissionsAmount = calculateCommissionAmount(transferAmount)
            if (transferAmount < 100) println("Меньше 100 рублей перевести невозможно!")
            else println("При переводе $transferAmount р., комиссия составит $commissionsAmount р.\n")
        } else if (input == 0) break
        else println("Вы ввели не допустимое значение. Попробуйте ещё раз!")


    }
}

fun getTransferAmount(): Int {

    while (true) {
        var amount: Int
        try {
            amount = readln().toInt()
            return amount

        } catch (e: NumberFormatException) {
            print("Вы ввели недопустимый формат суммы перевода! Попробуйте ещё раз: ")
        }
    }

}

fun calculateCommissionAmount(transferAmount: Int): Number {
    val amount = transferAmount / 100 * 0.75
    val minimalAmount = 35
    return if (amount > minimalAmount) amount else minimalAmount
}