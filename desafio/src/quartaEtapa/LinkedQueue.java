package quartaEtapa;

import quartaEtapa.Queue;
import quartaEtapa.Node;
import terceiraEtapa.UnderflowException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> frontNode; // Referência para o nó da frente da fila
    private Node<E> backNode; // Referência para o nó de trás da fila
    private int size; // Contador para acompanhar o número de elementos na fila

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
        return false; // Como é uma fila encadeada, ela não tem limite de capacidade
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
