package gb.linkedList;

import gb.impl.GBDeque;
import gb.impl.GBList;

import java.util.Iterator;

public class GBLinkedList<T> implements GBList<T>, GBDeque<T> {
    // модификатор transient указывает на то, что данное свойство класса нельзя
    // сериализировать
    transient int size = 0;
    transient Node<T> first = null;
    transient Node<T> last = null;

    public GBLinkedList() {
    }

    private static class Node<T> {
        T currentEl;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T currentEl, Node<T> next) {
            this.currentEl = currentEl;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public boolean addFirst(T type) {
        try {
            final Node<T> temp = first;
            final Node<T> newNode = new Node<>(null, type, temp);
            first = newNode;
            if (temp == null)
                last = newNode;
            else
                temp.prev = newNode;
            size++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addLast(T type) {
        try {
            final Node<T> temp = last;
            final Node<T> newNode = new Node<>(temp, type, null);
            last = newNode;
            if (temp == null)
                first = newNode;
            else
                temp.next = newNode;
            size++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void add(int index, T type) {
        if (index == size) addLast(type);
        else addBefore(type, node(index));
    }

    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    Node<T> node(int index) {
        if (index < (size - 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private void addBefore(T type, Node<T> succ) {
        Node<T> pred = succ.prev;
        Node<T> newNode = new Node<>(pred, type, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        try {
            checkPositionIndex(index);
            unlink(node(index));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    T unlink(Node<T> x) {
        final T element = x.currentEl;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.currentEl = null;
        size--;
        return element;
    }

    @Override
    public boolean add(T type) {
        addLast(type);
        return true;
    }

    @Override
    public T get(int index) {
        checkPositionIndex(index);
        return node(index).currentEl;
    }

    @Override
    public int size() {
        return this.size;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                return get(counter++);
            }
        };
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public T next() {
                return get(counter--);
            }
        };
    }
}

