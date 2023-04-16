package org.example;

import java.util.Comparator;
import java.util.Objects;

/**
 * Класс MyArrayList<E> представляет собой список объектов,
 * который может хранить элементы любого типа. Он позволяет
 * добавлять, удалять, получать и изменять элементы в списке.
 * Также класс поддерживает сортировку элементов списка при помощи
 * быстрой сортировки и заданного компаратора.
 */


public class MyArrayList<E> {
    private Object[] data;
    private int size;

    /**
     * Создает пустой список объектов MyArrayList с начальной
     * емкостью 10 элементов.
     */

    public MyArrayList() {
        this.data = new Object[10];
        this.size = 0;
    }


    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент, который нужно добавить
     */

    public void add(E element) {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = element;
    }

    /**
     * Добавляет элемент в указанную позицию в списке.
     *
     * @param index   позиция, куда нужно добавить элемент
     * @param element элемент, который нужно добавить
     * @throws IndexOutOfBoundsException если указанный индекс выходит за границы списка
     */

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /**
     * Добавляет все элементы, переданные в качестве аргументов, в конец списка.
     *
     * @param elements элементы, которые нужно добавить
     */
    public void addAll(E... elements) {
        for (E element : elements) {
            add(element);
        }
    }

    /**
     * Изменяет элемент в указанной позиции в списке.
     *
     * @param index   позиция элемента, который нужно изменить
     * @param element новое значение элемента
     * @throws IndexOutOfBoundsException если указанный индекс выходит за границы списка
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = element;
    }

    /**
     * Возвращает элемент в указанной позиции в списке.
     *
     * @param index позиция элемента, который нужно вернуть
     * @return элемент в указанной позиции
     * @throws IndexOutOfBoundsException если указанный индекс выходит за границы списка
     */

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) data[index];
    }

    /**
     * Удаляет элемент в указанной позиции из списка.
     *
     * @param index позиция элемента, который нужно удалить
     * @throws IndexOutOfBoundsException если указанный индекс выходит за границы списка
     */

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E element = (E) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */

    public int size() {
        return size;
    }

    /**
     * Быстрая сортировка списка методом "разделяй и властвуй".
     *
     * @param left       индекс левой границы подмассива
     * @param right      индекс правой границы подмассива
     * @param comparator компаратор, используемый для сравнения элементов списка
     * Сортировка не работает, если в массиве есть значение NULL !!!
     */
    public void quickSort(int left, int right, Comparator<E> comparator) {
        if (left >= right) {
            return;
        }
        int pivotIndex = (left + right) / 2;
        E pivot = (E) data[pivotIndex];
        int i = left;
        int j = right;
        while (i <= j) {
            while (Objects.compare((E) data[i], pivot, comparator) < 0 || (data[i] == null && pivot != null)) {
                i++;
            }
            while (Objects.compare((E) data[j], pivot, comparator) > 0 || (data[j] != null && pivot == null)) {
                j--;
            }
            if (i <= j) {
                Object temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(left, j, comparator);
        quickSort(i, right, comparator);
    }
}


