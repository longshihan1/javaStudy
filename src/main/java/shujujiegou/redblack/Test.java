/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shujujiegou.redblack;

import java.util.Comparator;

/**
 *
 * @author Tobias
 */
public class Test
{
    public static void main(String[] args)
    {
        RedBlackBST<String> myTree = new RedBlackBST<String>(Comparator.naturalOrder());
        myTree.insert("Q"); 
        myTree.insert("A");
        myTree.insert("Z");
        myTree.insert("E");
        myTree.insert("D");
        myTree.insert("C");
       
    }
}
