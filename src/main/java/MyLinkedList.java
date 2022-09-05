import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public MyLinkedList(){
        lastNode = new Node<>(null, firstNode, null);
        firstNode = new Node<>(null, null, lastNode);
    }

    public void add(E value) {
        final Node<E> l = lastNode;
        final Node<E> newNode = new Node<>(value, l, null);
        lastNode = newNode;
        if (l == null)
            firstNode = newNode;
        else
            l.nextElement = newNode;
        size++;
    }

    public void remove(int index) {
        Node<E> result = firstNode.nextElement;
        for (int i = 0; i < index; i++) {
            result = result.nextElement;
        }
        final Node<E> nextElement = result.nextElement;
        final Node<E> prevElement = result.prevElement;
        prevElement.nextElement = nextElement;
        result.prevElement = null;
        nextElement.prevElement = prevElement;
        result.nextElement = null;
        result.element = null;
        size--;
    }

    public void clear() {
        for (Node<E> x = firstNode; x != null; ) {
            Node<E> next = x.nextElement;
            x.element = null;
            x.nextElement = null;
            x.prevElement = null;
            x = next;
        }
        firstNode = lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < (size >> 1)) {
            Node<E> x = firstNode;
            for (int i = 0; i < index; i++)
                x = x.nextElement;
            return x.element;
        } else {
            Node<E> x = lastNode;
            for (int i = size - 1; i > index; i--)
                x = x.prevElement;
            return x.element;
        }
    }

    private static class Node<E> {
        private E element;
        private Node<E> nextElement;
        private Node<E> prevElement;

        Node(E element, Node<E> prevElement, Node<E> nextElement) {
            this.element = element;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
    }
}
