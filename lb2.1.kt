fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "был(а) только что"
        in 61..3600 -> {
            val minutes = seconds / 60
            "был(а) $minutes ${minutesWord(minutes)} назад"
        }
        in 3601..86400 -> {
            val hours = seconds / 3600
            "был(а) $hours ${hoursWord(hours)} назад"
        }
        in 86401..172800 -> "был(а) вчера"
        in 172801..259200 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun minutesWord(minutes: Int): String {
    val lastTwo = minutes % 100
    val lastOne = minutes % 10
    return when {
        lastTwo in 11..14 -> "минут"
        lastOne == 1 -> "минуту"
        lastOne in 2..4 -> "минуты"
        else -> "минут"
    }
}

fun hoursWord(hours: Int): String {
    val lastTwo = hours % 100
    val lastOne = hours % 10
    return when {
        lastTwo in 11..14 -> "часов"
        lastOne == 1 -> "час"
        lastOne in 2..4 -> "часа"
        else -> "часов"
    }
}

fun main() {
    println(agoToText(30))
    println(agoToText(60))
    println(agoToText(61))
    println(agoToText(120))
    println(agoToText(300))
    println(agoToText(660))
    println(agoToText(1260))
    println(agoToText(1500))
    println(agoToText(3600))
    println(agoToText(7200))
    println(agoToText(18000))
    println(agoToText(86400))
    println(agoToText(86401))
    println(agoToText(172800))
    println(agoToText(172801))
    println(agoToText(259200))
    println(agoToText(259203))
}