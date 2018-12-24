package class01

import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    println("acd"*16)
}

operator fun String.times(int: Int):String{
    val stringBuilder=StringBuilder()
    for (i in 0 until int){
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}
