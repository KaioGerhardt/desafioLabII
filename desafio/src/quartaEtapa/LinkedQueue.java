package quartaEtapa;

import quartaEtapa.Queue;
import quartaEtapa.Node;
import terceiraEtapa.UnderflowException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> frontNode;
    private Node<E> backNode;
    private int size; 

    public LinkedQueue() {
        frontNode = null;
        backNode = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            frontNode = newNode;
        } else {
            backNode.setNext(newNode);
        }
        backNode = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        E removedElement = frontNode.getData();
        frontNode = frontNode.getNext();
        size--;

        if (isEmpty()) {
            backNode = null;
        }

        return removedElement;
    }

    @Override
    public E front() {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return frontNode.getData();
    }

    @Override
    public E back() {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return backNode.getData();
    }
}
