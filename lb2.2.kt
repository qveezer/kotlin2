fun calculateCommission(
    cardType: String = "VK Pay",
    previousTransfers: Double = 0.0,
    transferAmount: Double = 0.0
): Double {
    if (cardType == "VK Pay") {
        return 0.0
    }

    if (cardType == "MasterCard" || cardType == "Maestro") {
        val total = previousTransfers + transferAmount
        return if (total <= 75000) {
            0.0
        } else {
            transferAmount * 0.006
        }
    }

    if (cardType == "Visa" || cardType == "Мир") {
        return transferAmount * 0.0075
    }

    return 0.0
}

fun main() {

    println("РАСЧЁТ КОМИССИИ")


    println("\n1. VK Pay, перевод 10000 руб.")
    println("   Комиссия: ${calculateCommission("VK Pay", 0.0, 10000.0)} руб.")

    println("\n2. MasterCard, переводили 50000, переводим 10000")
    println("   Всего будет: ${50000 + 10000}")
    println("   Комиссия: ${calculateCommission("MasterCard", 50000.0, 10000.0)} руб.")

    println("\n3. MasterCard, переводили 70000, переводим 10000")
    println("   Всего будет: ${70000 + 10000}")
    println("   Комиссия: ${calculateCommission("MasterCard", 70000.0, 10000.0)} руб.")

    println("\n4. Maestro, переводили 70000, переводим 5000")
    println("   Всего будет: ${70000 + 5000}")
    println("   Комиссия: ${calculateCommission("Maestro", 70000.0, 5000.0)} руб.")

    println("\n5. Visa, перевод 10000 руб.")
    println("   Комиссия: ${calculateCommission("Visa", 0.0, 10000.0)} руб.")

    println("\n6. Мир, перевод 20000 руб.")
    println("   Комиссия: ${calculateCommission("Мир", 0.0, 20000.0)} руб.")

    println("\n7. Без указания карты")
    println("   Комиссия: ${calculateCommission()} руб.")


}