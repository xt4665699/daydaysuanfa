package tow_to_four;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node, E e) {

        if (node ==  null){
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else {
            node.right = add(node.right,e);
        }

        return node;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if (node == null){
            return false;
        }
        if (e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur  = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (! q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null){
                q.add(cur.left);
            }
            if (cur.right != null){
                q.add(cur.right);
            }
        }
    }
    //寻找二分搜索树的最小元素
    public E minimum(){
        if (size == 0)
            return  null;
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }
    //寻找二分搜索树的最大元素
    public E maximum(){
        if (size == 0)
            return  null;
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return minimum(node.right);
    }


}
