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
        for (int i = 0; i < size; i++) {
            if (elementData[i] == null && o == null) {
                return true;
            } else {
                if (elementData[i] != null && (elementData[i]).equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        }
        System.arraycopy(elementData, 0, a, 0, size);
        return a;
    }

    @Override
    public boolean remove(final Object o) {
        MyIterator<E> iter = new MyIterator<E>();
        while (iter.hasNext()) {
            Object newIter = iter.next();
            if ((o == null && newIter == null)
                    || (o != null && o.equals(newIter))) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
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
        int point = 0;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elementData[i])) {
                elementData[point] = elementData[i];
                point++;
            }
        }
        if (point < size) {
            for (int i = point; i < size; i++) {
                elementData[i] = null;
            }
            size = point;
            ifRemove = true;
        }
        return ifRemove;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        boolean ifRetain = false;
        int point = 0;
        for (int i = 0; i < size; i++) {
            if (c.contains(elementData[i])) {
                elementData[point] = elementData[i];
                point++;
            }
        }
        if (point < size) {
            for (int i = point; i < size; i++) {
                elementData[i] = null;
            }
            size = point;
            ifRetain = true;
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
        private boolean repeat;

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
            repeat = false;
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            if (cursor == 0 || repeat) {
                throw new IllegalStateException();
            }
            if (!hasNext()) {
                size--;
            } else {
                if (size - (cursor - 1) >= 0) {
                    System.arraycopy(elementData, cursor, elementData, cursor - 1, size - (cursor - 1));
                }
            }
            size--;
            repeat = true;
        }
    }
}
