package code.dataStructures.redBlackSearchTree;

import java.util.Collection;
import java.util.Iterator;

public class RedBlackSearchTree<E> implements Collection {

    private int _size;
    private Node<E> _root;


    @Override
    public int size() {
        return _size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    /**
     * This is a generic node in a binary search tree
     * @param <E> the type that the Tree stores
     */
    private class Node<E> {

        public Node<E> left, right, parent;
        public Color color;
        public E elem;
    }
    enum Color{
        RED, BLACK
    }
}
