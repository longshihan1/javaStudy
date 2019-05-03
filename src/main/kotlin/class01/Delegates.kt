package class01

import kotlin.reflect.KProperty

class Delegates{

    val hello by lazy {
        "Hello World"
    }


    val hello2 by X()
    val hello3 by X()
}

class X{
    private var value:String?=null

    operator fun getValue(thisRef:Any?,property:KProperty<*>):String{
        print("")
        return value?:""
    }

    operator fun setValue(thisRef:Any?,property:KProperty<*>,value: String){
        this.value=value
    }
}