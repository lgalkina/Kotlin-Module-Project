package user

import java.util.*

private val scanner = Scanner(System.`in`)

fun getItem(maxIndex: Int): Int {
    val index: Int
    val numStr: String = scanner.next().trim { it <= ' ' }
    if (numStr.isEmpty()) {
        showText( "Некорректное значение, значение не может быть пустым. Попробуйе еще раз.")
        return -1
    }
    try {
        index = numStr.toInt()
    } catch (ex: NumberFormatException) {
        showText("Некорректное значение, значение должно быть целым числом. Попробуйе еще раз.")
        return -1
    }
    if (index >= maxIndex || index < 0) {
        showText("Некорректное значение, значение должно быть равно цифре одного из пунктов меню. Попробуйе еще раз.")
        return -1
    }
    return index
}

fun getName(): String {
    showText("Введите название: ")
    while (true) {
        val name = scanner.next().trim { it <= ' ' }
        if (name.isEmpty()) {
            showText("Некорректное значение названия, название не может быть пустым. Попробуйе еще раз: ")
            continue
        }
        return name
    }
}

fun getNotes(): String {
    showText("Введите содержимое заметки (введите 'exit' для завершения ввода): ")
    val lines = mutableListOf<String>()
    while (scanner.hasNext()) {
        val next = scanner.next()
        if (next.equals("exit", ignoreCase = true)) {
            break
        }
        lines.add(next)
    }
    return lines.joinToString()
}

fun showText(text: String) {
    println(text)
}