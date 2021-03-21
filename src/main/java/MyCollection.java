import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E>, Iterable<E> {
    private int size;

    private Object[] elementData = new Object[10];


    @Override
    public boolean add(final E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public boolean contains(final Object o) {
        return elementData.equals(o);
    }

    @Override
    public Object[] toArray() {
        return new Object[size()];
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean remove(final Object o) {
        if (elementData.equals(o)) {
            System.arraycopy(elementData, 0, elementData, 0, size - 1);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return c.equals(elementData);
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        boolean ifRemove = false;
        for (Object e : c) {
            if (c.equals(elementData)) {
                remove(e);
                ifRemove = true;
            }
            ifRemove = false;
        }
        return ifRemove;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        boolean ifRetain = false;
        for (Object e : c) {
            if (!c.equals(elementData)) {
                remove(e);
                ifRetain = true;
            }
            ifRetain = false;
        }
        return ifRetain;
    }

    @Override
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }

    private class MyIterator<T> implements Iterator<T> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            if (cursor == 0) {
                throw new IllegalStateException();
            }
            if (cursor < size) {
                System.arraycopy(elementData, cursor + 1, elementData, cursor, size - cursor - 1);
            }
            size--;
        }
    }
}
