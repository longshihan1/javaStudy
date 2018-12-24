package class01

fun main(args: Array<String>) {
    var nums = 1..20
    for (num in nums) {
        println(num)
    }
    println("111")

    var lists = listOf("1", "2", "3")
    for ((i, e) in lists.withIndex()) {
        println("$i    $e")
    }
    var gril = Girl("123", 234)
    gril.test()

    test4.test()

    var test001 = test5.test01()
    test001.sayHello()

    Thread(Runnable {
        while (true) {
            println("1")
        }
    }).start()
}

fun add(x: Int, y: Int): Int = x + y

class Girl(var name: String, var age: Int) {
    fun test() {
        println(name)
    }

    override fun toString(): String {
        return name + ":" + age
    }
}

abstract class test2(var name: String) {
    abstract fun eat()
}

class test3(name: String) : test2(name) {
    override fun eat() {

    }

}

object test4 {
    fun test() {
        print("ss")
    }
}

sealed class test5 {
    class test01() : test5()
    class test02() : test5()
    class test03() : test5()
    class test04() : test5()
    class test05() : test5()

    fun sayHello() {
        println("似曾相识")
    }
}

