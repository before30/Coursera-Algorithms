import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Created by before30 on 2016. 2. 9..
 */
public class Deque<Item> implements Iterable<Item> {
    private java.util.Deque<Item> deque;
//    private class Node {
//        private Item item;
//        private Node prev;
//        private Node next;
//
//        Node(Item item) {
//            this.item = item;
//            this.prev = null;
//            this.next = null;
//        }
//
//        public Item getItem() {
//            return item;
//        }
//
//        public Node getPrev() {
//            return prev;
//        }
//
//        public Node getNext() {
//            return next;
//        }
//
//        public void setPrevNode(Node node) {
//            this.prev = node;
//        }
//
//        public void setNextNode(Node node) {
//            this.next = node;
//        }
//    }
//
//    private Node head;
//    private Node tail;
//    private int size;

    // construct an empty deque
    public Deque() {
        deque = new ArrayDeque<>();
//        head = new Node(null);
//        tail = new Node(null);
//
//        head.setNextNode(tail);
//        tail.setPrevNode(head);
//        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
//        return head.next == tail;
        return deque.isEmpty();
    }

    // return the number of items on the deque
    public int size() {
        return deque.size();
//        int size = 0;
//        Node node = head.getNext();
//        while(node != tail) {
//            size++;
//            node = node.getNext();
//        }
//        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }

        deque.addFirst(item);

//        Node node = new Node(item);
//        Node oldFirst = head.getNext();
//        head.setNextNode(node);
//        oldFirst.setPrevNode(node);
//        node.setPrevNode(head);
//        node.setNextNode(oldFirst);
//        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }

        deque.addLast(item);
//        Node node = new Node(item);
//        Node oldLast = tail.getPrev();
//        tail.setPrevNode(node);
//        oldLast.setNextNode(node);
//        node.setNextNode(tail);
//        node.setPrevNode(oldLast);
//        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        return deque.removeFirst();
//        Node curNode = head.getNext();
//        Node nextNode = curNode.getNext();
//        head.setNextNode(nextNode);
//        nextNode.setPrevNode(head);
//        size--;
//        return curNode.getItem();
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        return deque.removeLast();
//        Node curNode = tail.getPrev();
//        Node prevNode = curNode.getPrev();
//        tail.setNextNode(prevNode);
//        prevNode.setNextNode(tail);
//        size--;
//        return curNode.getItem();
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return deque.iterator();
    }

//    private class DequeIterator implements Iterator<Item> {
//
//        private Node currentNode = head.getNext();
//
//        @Override
//        public boolean hasNext() {
//            return currentNode != tail;
//        }
//
//        @Override
//        public Item next() {
//            if (!hasNext()) throw new java.util.NoSuchElementException();
//            Item item = currentNode.getItem();
//            currentNode = currentNode.next;
//            return item;
//        }
//
//        @Override
//        public void remove() {
//            throw new java.lang.UnsupportedOperationException();
//        }
//    }

    // unit testing
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(0);

        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println(deque.size());

        deque.removeFirst();
        iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println(deque.size());

        deque.removeLast();
        iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println(deque.size());

    }
}