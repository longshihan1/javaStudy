package suanfabook.B4

class AVLTree{
    //根节点
    private var root: Node? = null

    fun add(item:Int){
        if(root == null) {
            root = Node(item)
        }else{
            var parent:Node?
            var temp= root
            loop@ do {
                parent=temp
                temp = when{
                    parent==null->break@loop
                    item < parent.value-> parent.left
                    item > parent.value-> parent.right
                    else ->break@loop
                }
            }while (temp!=null)

            if (temp!=null){
                temp.value=item
            }else if (parent!=null){
                var node=Node(item)
                node.parent=parent
                if (item<parent.value){
                    parent.left=node
                    if (parent.right==null){

                    }


                }
            }


        }
    }
}