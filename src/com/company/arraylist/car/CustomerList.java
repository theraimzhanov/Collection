package com.company.arraylist.car;

import java.util.Iterator;

public class CustomerList implements CarList {
    private Node last;
    private Node first;
    private int size = 0;

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(Car car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
       return      add(car);

        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, car, nodeNext);
        nodeNext.previous = newNode;

        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        }else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return  true;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for (int i=0;i<size;i++){
            if (node.value.equals(car)){
                removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        }
        else {
            last = nodePrevious;
        }
        if (nodePrevious !=null){
        nodePrevious.next = nodeNext;}
        else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }


    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
           private Node node = first;
            @Override
            public boolean hasNext() {
                return node != null ;
            }

            @Override
            public Car next() {
                Car car = node.value;
                node = node.next;
                return car;
            }
        };
    }

    @Override
    public boolean contains(Car car) {
        Node node = first;
        for (int i=0;i<size;i++){
            if (node.value.equals(car)){
                return true;
            }
            node = node.next;
        }

        return false;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;


        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.next = next;
            this.value = value;
        }
    }
}
