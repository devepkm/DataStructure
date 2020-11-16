

import java.util.Arrays;

public class ArrayList<E> {

    private E[] data;
    private int size;


    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }


    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E element) {
        insert(size, element);
    }

    public void addFirst(E element) {
        insert(0, element);
    }


    private void resize(int size) {
        E[] temp = (E[]) new Object[size];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }


    public void insert(int index, E element) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal Index");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];

        }
        data[index] = element;
        size++;

    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void set(int index, E e) {
        checkIndex(index);
        data[index] = e;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("ILLegal Index");
        }
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    public E remove(int index) {
        checkIndex(index);
        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;

        if (size < data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeIfExist(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("ArrayList: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}