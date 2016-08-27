import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
* This class implements the SimpleSet interface
*
* @param <T> Param Type
* @version 1.0
* @author _insert_name_
*/
public class MySet<T> implements Set<T> {

    private T[] backingArray;
    private int numElements;

    /* Implement methods here */

    @Override
    public int size() {
        return 0;
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
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

/*
    ----------------------------------------------
    These methods are provided to help you, DO NOT MODIFY!
    Refer to the slides on Iterators if you want to learn more
    http://cs1331.org/slides/iterators.pdf
    */

    /**
    * Returns an iterator if you wish to use it
    * @return An iterator for the SimpleSet
    */
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    private class MySetIterator implements Iterator {

        private int index = 0;
        public boolean hasNext() {
            return index < numElements;
        }

        public T next() {
            return backingArray[index++];
        }

        public void remove() {
            MySet.this.remove(backingArray[index]);
            index--;
        }
    }

}
