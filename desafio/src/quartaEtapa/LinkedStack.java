package quartaEtapa;

import quartaEtapa.Stack;
import quartaEtapa.Node;
import terceiraEtapa.OverflowException;
import terceiraEtapa.UnderflowException;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> topNode; // Referência para o nó do topo da pilha
    private int size; // Contador para acompanhar o número de elementos na pilha

    public LinkedStack() {
        topNode = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false; // Como é uma pilha encadeada, ela não tem limite de capacidade
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element, topNode);
        topNode = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        
        E removedElement = topNode.getData();
        topNode = topNode.getNext();
        size--;
        
        return removedElement;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        
        return topNode.getData();
    }
}