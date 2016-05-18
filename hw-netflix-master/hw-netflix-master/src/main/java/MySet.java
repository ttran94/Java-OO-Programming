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
