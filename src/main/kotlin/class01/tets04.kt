package class01

import javassist.ClassPool
import javassist.CtField
import java.io.OutputStream
import java.nio.charset.Charset

/**
 * 写一个打日志的东西
 */
fun log(tag: String, target: OutputStream, message: Any?){
    //打日志"\n"是换行的意思
    target.write("[$tag] $message\n".toByteArray())
}

/**
 * 柯里化它
 * 1.首先传tag
 * 2.返回一个函数，函数再传target
 * 3.返回一个函数，函数再传Any
 */
/*
* 这样写下去就很复杂了
fun log(tag: String): (target: OutputStream) -> (message: Any?){

}*/

/***
 * 用一个简单的写法
 */
/*fun log(tag: String)
    =fun(target: OutputStream)
    =fun(message: Any?)
    = target.write("[$tag] $message\n".toByteArray())*/

fun main(args: Array<String>) {
    log("benny",System.out,"HelloWorld")
    //log("benny")(System.out)("HelloWorld Again")
    ::log.curried()("benny")(System.out)("HelloWorld Again")

    //偏函数
    //1.定义一个变量
    //2.先柯里化一下它,对于固定每次都要传的参数，可以先固定一下它
    //3.对于多参数函数，通过先指定它的一些固定的参数，得到的依然是一个函数，这个函数就是原来函数的偏函数
    val consoleLogWithTag = (::log.curried())("benny")(System.out)
    consoleLogWithTag("Hello wang dong")
    consoleLogWithTag("helllo boy")
    consoleLogWithTag("hello girl")

    val bytes = "我是熊本同学".toByteArray(charset("GBK"))
    val stringFormGBK = makeStringFromGbKBytes(bytes)
    println(stringFormGBK)
}

/**
 * 这个柯里化就非常简单了
 * 写一个扩展函数
 * 三个参数那么就扩展Function3了
 * 这样写就对了，目前请不要过分深究，他日在细细研究
 */
fun <P1,P2,P3,R> Function3<P1,P2,P3,R>.curried()
        =fun (p1: P1) = fun (p2: P2) = fun (p3: P3) = this(p1,p2,p3)

/**定义一个匿名函数
 * 两个参数byteArry，charset
 * 返回String类型
 */
val makeString = fun(byteArry: ByteArray,charset: Charset):String{
    return String(byteArry,charset)
}

/**
 * 定义一个变量
 * partial2是一个偏函数
 * 第二个参数charset已经绑定为GBK
 */
val makeStringFromGbKBytes = makeString.partial2(charset("GBK"))

/**
 * 定义一个扩展方法
 * 参数是P1、P2
 * 返回值是：R
 * 参数p2已经被偏函数绑定
 * fun()只需要传第一参数就好了
 * partial1和partial2都是绑定参数的
 */
fun <P1,P2,R> Function2<P1,P2,R>.partial2(p2: P2) = fun(p1:P1) = this(p1,p2)
fun <P1,P2,R> Function2<P1,P2,R>.partial1(p1: P1) = fun(p2:P2) = this(p1,p2)