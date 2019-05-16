package suanfabook.B4

class Node(var value: Int) {
    var parent: Node? = null
    var left: Node? = null
    var right: Node? = null
    var avl: Int = 0

    val brother: Node?
        get() = when {
            parent == null -> null
            this === parent!!.left -> parent!!.right
            else -> parent!!.left
        }

    init {
        this.avl = 0
    }

    fun subAVL(): Int {
        avl -= 1
        return avl
    }

    fun addAVL(): Int {
        avl += 1
        return avl
    }

    override fun toString(): String {
        return value.toString()
    }

    fun hasBrother(): Boolean {
        return when {
            parent == null -> false
            this === parent!!.left && parent!!.right != null -> true
            else -> this === parent!!.right && parent!!.left != null
        }
    }

    fun hasChild(): Boolean {
        return left != null || right != null
    }

    fun deleteChildNode(child: Node?) {
        when {
            child == null -> return
            child === left -> left = null
            child === right -> right = null
        }
    }
}
