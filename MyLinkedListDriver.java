import java.util.*;

class NoSuchElementFoundException extends RuntimeException {

    NoSuchElementFoundException(String desc) {
        super(desc);
    }

}

class MyIndexOutOfBoundsException extends RuntimeException {

    MyIndexOutOfBoundsException(String desc) {
        super(desc);
    }

}

class MyLinkedList<E> {

    Node<E> head;
    Node<E> tail;
    int indx;

    private class Node<E> {
        E ele;
        Node<E> next;

        public Node(E ele) {
            this.ele = ele;
        }
    }

    @Override
    public String toString() {
        String op = "[";
        if (indx == 0) {
            return "[]";
        } else {
            Node<E> currNode = head;
            while (currNode.next != null) {
                op += currNode.ele + " ,";
                currNode = currNode.next;
            }
            op += currNode.ele + "]";
        }
        return op;
    }

    public void add(E ele) {
        Node<E> newNode = new Node<>(ele);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node<E> currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            tail = newNode;
        }
        indx++;

    }

    public int size() {
        return indx;
    }

    public E getFirst() {
        if (indx == 0)
            throw new NoSuchElementFoundException("");
        return head.ele;
    }

    public E getLast() {
        if (indx == 0)
            throw new NoSuchElementFoundException("");
        return tail.ele;
    }

    public E removeFirst() {
        if (indx == 0)
            throw new NoSuchElementFoundException("");
        E temp = head.ele;
        head = head.next;
        if (indx == 1)
            tail = null;
        indx++;
        return temp;
    }

    // public E removeLast() {
    //     if (indx == 0)
    //         throw new NoSuchElementFoundException("");

    //     E temp = tail.ele;

    //     Node<E> currNode = head;
    //     for (int i = 0; i < size()-1; i++) {
    //         System.out.println(currNode.ele);
    //         currNode = currNode.next;
    //     }
    //     currNode.next = null;
    //     tail = currNode;
    //     if (indx == 1) head = null;
    //     indx--;
    //     return temp;
    // }

    public E removeLast() {
    if (indx == 0)
        throw new NoSuchElementFoundException("");

    E temp = tail.ele;

    if (indx == 1) {
        head = null;
        tail = null;
    } else {
        Node<E> currNode = head;
        while (currNode.next != tail) {
            currNode = currNode.next;
        }
        currNode.next = null;
        tail = currNode;
    }
    indx--;
    return temp;
}

    public E get(int indx){

        if(indx < 0 || indx >= size())
        {
            throw new MyIndexOutOfBoundsException("index : " +indx+ ", Size : "+size());
        }
            Node<E> currNode = head ;

            for(int i =0; i< indx; i++)
            {
                currNode = currNode.next;
            }

            return currNode.ele;

        }

    public E set(int indx, E ele)
    {

        if (indx < 0 || indx >= size())
            throw new MyIndexOutOfBoundsException("Index : " + indx + ", Size : " + size());

        Node<E> currNode = head;

        for (int i = 0; i < indx; i++) {
            currNode = currNode.next;
        }
        E temp = currNode.ele;
        currNode.ele = ele;
        return temp;

    }

}



public class MyLinkedListDriver {
    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(55);
        list.add(44);
        list.add(62);
        list.add(12);
        list.add(54);
        System.out.println(list);

       System.out.println( "size :" +list.size());

       System.out.println("get First element : "+list.getFirst());

       System.out.println("Get Last : "+ list.getLast());

      System.out.println("First Removed element : "+ list.removeFirst());

        System.out.println("updated element : "+list.set(2,39));
        System.out.println(list);

        System.out.println("Last Removed element : "+list.removeLast());

        System.out.println(list);

       

    }
}
