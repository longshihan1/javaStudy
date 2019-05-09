package suanfabook.B3

import jdk.nashorn.internal.ir.BinaryNode
import java.util.*


fun main(args: Array<String>) {
    val linkedList = LinkedList<String>()
    linkedList.addFirst("s")
    linkedList.add("d")
    linkedList.add("c")
    linkedList.removeAt(2)
    print(linkedList)
    val stack1 = Stack<String>()
    stack1.push("4.99")
    stack1.push("1.06")
    stack1.push("*")
    stack1.push("5.99")
    stack1.push("+")
    stack1.push("6.99")
    stack1.push("1.06")
    stack1.push("*")
    stack1.push("+")
    print(stack1)
    print(stack1.peek())

    val trrree = TreeSet<String>()
    trrree.add("1")
    trrree.add("2")
    print(trrree)


}