package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Anthony Derfler (cderfler)

/**
 * This is a doubly linked list with a private Node class inside
 * 
 * @author Anthony Derfler (cderfler)
 * @version 19.4.15
 */
public class LinkedList<E> {

    /**
     * private Doubly Linked Node class that contains references to both the
     * previous and next node
     * 
     * @author Anthony Derfler (cderfler)
     *
     * @param <E>
     *            general object
     */
    private class DoublyLinkedNode<E> {
        // next node in the list
        private DoublyLinkedNode<E> nextNode;

        // previous node in the list
        private DoublyLinkedNode<E> prevNode;

        // data contained in the node
        private E data;


        /**
         * standard constructor with modifiable next, previous, and data
         * parameters
         * 
         * @param next
         *            next node
         * @param prev
         *            previous node
         * @param data
         *            data held in node
         */
        public DoublyLinkedNode(
            DoublyLinkedNode<E> next,
            DoublyLinkedNode<E> prev,
            E data) {
            this.nextNode = next;
            this.data = data;
        }


        /**
         * constructor with only data held inside
         * 
         * @param data
         *            data held in node
         */
        public DoublyLinkedNode(E data) {
            this(null, null, data);
        }


        /**
         * sets the next node in the list
         * 
         * @param next
         *            the next node
         */
        public void setNext(DoublyLinkedNode<E> next) {
            this.nextNode = next;
        }


        /**
         * sets the previous node in the list
         * 
         * @param prev
         *            the previous node
         */
        public void setPrevious(DoublyLinkedNode<E> prev) {
            this.prevNode = prev;
        }


        /**
         * getter method that retrieves the next node
         * 
         * @return the next node
         */
        public DoublyLinkedNode<E> getNext() {
            return nextNode;
        }


        /**
         * getter method that retrieves the previous node
         * 
         * @return the previous node
         */
        public DoublyLinkedNode<E> getPrevious() {
            return prevNode;
        }


        /**
         * getter method that retrieves the data
         * 
         * @return the data held in node
         */
        public E getData() {
            return data;
        }


        /**
         * links the node with the node you want after it
         * 
         * @param nextNode
         *            the node being linked to
         */
        public void linkWith(DoublyLinkedNode<E> nextNode) {
            this.setNext(nextNode);
            nextNode.setPrevious(this);
        }


        /**
         * adds a node after another node
         * 
         * @param node
         *            the node this is being added after
         */
        public void addAfter(DoublyLinkedNode<E> node) {
            if (node.getNext() != null) {
                this.linkWith(node.getNext());
            }
            node.linkWith(this);
        }
    }

    // size of the list
    int size;

    // first sentinel node
    DoublyLinkedNode<E> head;

    // last sentinel node
    DoublyLinkedNode<E> tail;


    /**
     * standard constructor that sets everything to null
     */
    public LinkedList() {
        size = 0;
        head = new DoublyLinkedNode<E>(null);
        tail = new DoublyLinkedNode<E>(null);

        head.setNext(tail);
        tail.setPrevious(head);
    }


    /**
     * getter method that returns the size of the list
     * 
     * @return the size
     */
    public int getSize() {
        return size;
    }


    /**
     * adds a new node to the end of the list
     * 
     * @param data
     *            the data being held by the new node
     */
    public void add(E data) {
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(data);
        if (data == null) {
            throw new NullPointerException();
        }
        else {
            newNode.addAfter(tail.getPrevious());
            size++;
        }
    }


    /**
     * adds a new node to a specific index
     * 
     * @param index
     *            index being added to
     * @param data
     *            data held by the node
     */
    public void add(int index, E data) {
        if (index == 0) {
            DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(data);
            newNode.addAfter(head);
            size++;
        }
        else if (index == size) {
            DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(data);
            newNode.addAfter(tail.getPrevious());
            size++;
        }
        else if (index > 0 && index < size) {
            DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(data);
            newNode.addAfter(this.getNodeAt(index).getPrevious());
            size++;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }


    /**
     * removes the node holding the specified data
     * 
     * @param data
     *            the data this is removing
     * @return if its was successful or not
     */
    public boolean remove(E data) {
        DoublyLinkedNode<E> iter = head.getNext();

        if (this.isEmpty() || data == null) {
            return false;
        }

        if (head.getNext().getData().equals(data)) {
            head.linkWith(head.getNext().getNext());
            size--;
            return true;
        }

        for (int i = 0; i < size; i++) {
            if (iter.getData().equals(data)) {
                this.getNodeAt(i - 1).linkWith(this.getNodeAt(i + 1));
                size--;
                return true;
            }
            iter = iter.getNext();
        }

        return false;
    }


    /**
     * removes a specified index from the list
     * 
     * @param index
     *            index being targetted
     * @return the contents of the removed node
     */
    public E remove(int index) {
        DoublyLinkedNode<E> iter = head.getNext();

        if (index == 0 && !this.isEmpty()) {
            E removed = head.getNext().getData();
            head.linkWith(head.getNext().getNext());
            size--;
            return removed;
        }
        else if (index == size && !this.isEmpty()) {
            E removed = tail.getPrevious().getData();
            tail.getPrevious().getPrevious().linkWith(tail);
            size--;
            return removed;
        }
        else if (index > 0 && index < size) {
            for (int i = 0; i < index; i++) {
                iter = iter.getNext();
            }

            E removed = iter.getData();
            iter.getPrevious().linkWith(iter.getNext());
            size--;
            return removed;
        }
        else {
            throw new IndexOutOfBoundsException();
        }

    }


    /**
     * returns the front of the list
     * 
     * @return the contents first node
     */
    public E getFront() {
        return head.nextNode.data;
    }


    /**
     * a helper method that gets the node at a specified index
     * 
     * @param index
     *            the index being targeted
     * @return the contents of the chosen node
     */
    private DoublyLinkedNode<E> getNodeAt(int index) {
        if (index >= 0 && index <= size && !this.isEmpty()) {
            DoublyLinkedNode<E> iter = head.getNext();
            for (int i = 0; i < index; i++) {
                iter = iter.getNext();
            }

            return iter;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }


    /**
     * gets the data of a node at a specified index
     * 
     * @param index
     *            the index being looked at
     * @return the contents of the node
     */
    public E get(int index) {
        return this.getNodeAt(index).getData();
    }


    /**
     * sees if the list is empty or not
     * 
     * @return if it's empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * checks if the list contains a certain item
     * 
     * @param item
     *            the item being looked for
     * @return if it's in the list
     */
    public boolean contains(E item) {
        if (item == null) {
            throw new NullPointerException();
        }
        else {
            DoublyLinkedNode<E> iter = head.getNext();
            while (iter.getNext() != null) {
                if (iter.getData().equals(item)) {
                    return true;
                }
                iter = iter.getNext();
            }
            return false;
        }
    }


    /**
     * resets the list back to holding nothing
     */
    public void clear() {
        size = 0;
        head = new DoublyLinkedNode<E>(null);
        tail = new DoublyLinkedNode<E>(null);
        head.linkWith(tail);
    }


    /**
     * converts the contents of the list to a string
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        Iterator<E> i = iterator();
        if (!this.isEmpty()) {
            while (i.hasNext()) {
                string.append(i.next());
                if (i.hasNext()) {
                    string.append(", ");
                }
            }
        }
        return string.toString();
    }


    /**
     * getter method that sees where an item exists in a node
     * 
     * @param item
     *            the item being looked for
     * @return the index where it exists in the list
     */
    public int getIndex(E item) {
        if (this.contains(item)) {
            DoublyLinkedNode<E> iter = head.getNext();
            for (int i = 0; i < size; i++) {
                if (iter.getData().equals(item)) {
                    return i;
                }
                iter = iter.getNext();
            }
        }
        return -1;
    }


    public Iterator<E> iterator() {
        return new ListIterator();
    }


    /**
     * Iterator for the list
     * 
     * @author Anthony
     * @version 19.4.15
     */
    private class ListIterator implements Iterator<E> {
        // iterating node
        private DoublyLinkedNode<E> curr;


        /**
         * standard constructor
         */
        public ListIterator() {
            curr = head;
        }


        /**
         * checks if the iterator node has node after it
         */
        @Override
        public boolean hasNext() {

            return curr.nextNode != null && curr.nextNode != tail;
        }


        /**
         * moves the node forward once
         */
        @Override
        public E next() {
            if (this.hasNext()) {
                curr = curr.nextNode;
                return curr.getData();
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }
}
