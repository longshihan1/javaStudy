package class01

import annotations.PoKo
import annotations.PoKo2

@PoKo
data class Country(val id:Int,val name:String)

@PoKo2
data class Country123(val id:Int,val name:String)

fun main(args: Array<String>) {
    val china=Country(1,"中国")
    println(china)
    println(china.component1())
    val (id,name)=china
    println(id)
    println(name)

}

infix fun<P1,P2,R> Function1<P1,P2>.andThen(function: Function1<P2,R>):Function1<P1,R>{
    return fun (p1:P1):R{
        return function.invoke(this.invoke(p1))
    }
}


infix fun<P1,P2,R> Function1<P2,R>.composs(function: Function1<P1,P2>):Function1<P1,R>{
    return fun (p1:P1):R{
        return this.invoke(function.invoke(p1))
    }
}

