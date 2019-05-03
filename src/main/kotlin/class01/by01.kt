package class01

interface Driver{
    fun drive()
}

interface Writer{
    fun write()
}

class Manager:Driver,Writer{
    override fun write() {
    }

    override fun drive() {
    }

}

class SenionManager(val driver: Driver,val writer: Writer):Driver by driver,Writer by writer


interface B1{
    fun x():Int=1
}

interface B2{
    fun x():Int=0
}

abstract class A{
    open fun x():Int=5
}

class C(var y:Int=0):A(),B1,B2{
    override fun x(): Int {
        if (y>0){
            return y
        }else if (y<-100){
            return super<B1>.x()
        }else{
            return super<B2>.x()
        }
    }

}

fun main(args: Array<String>) {
    println(C(6).x())
    println(C(-10).x())
    var latitude=Latitude.ofDouble(3.0)

}

object MusicPlayer{
    var state:Int=0
    fun play(url:String){

    }

}



class Latitude private constructor(val value:Double){
    companion object {
        @JvmStatic
        fun ofDouble(double: Double):Latitude{
            return Latitude(double)
        }

        fun ofLatitude(latitude: Latitude):Latitude{
            return Latitude(latitude.value)
        }
    }
}