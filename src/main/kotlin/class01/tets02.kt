package class01


fun main(args: Array<String>) {
    var names= listOf<Girl>(Girl("1",1),Girl("2",2),Girl("3",3))
    names.forEach{
        println(it)
    }
    names findage 3

}

infix fun List<Girl>.findage(age:Int){
    filter {
        it.age<age
    }.forEach(::println)
}