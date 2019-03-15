package by.epam.javatraining.aksenov.task4.model.container;

import java.util.Arrays;
import java.util.Objects;

public class Stack<T> {
    private static final int SIZE_DEFAULT = 5;

    private T[] elements;
    private int count;

    public Stack() {
        elements = (T[]) new Object[SIZE_DEFAULT];
    }

    public Stack(int size) {
        if (size >= 0) {
            elements = (T[]) new Object[size];
        }
    }

    public Stack(T[] elements) {
        if (elements != null) {
            this.elements = elements;
            count = elements.length;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    public int size() {
        return elements.length;
    }

    public T peek() {
        return elements[count - 1];
    }

    public void resize(int size) {
        if (size > elements.length) {
            T[] tempElements = (T[]) new Object[size];
            for (int i = 0; i < count; i++) {
                tempElements[i] = elements[i];
            }
            elements = tempElements;
        }
    }

    public void push(T element) {
        if (count == elements.length) {
            resize(elements.length * 2);
        }
        elements[count++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T element = elements[--count];
        elements[count] = null;

        if (count > 0 && count == elements.length / 4){
            resize(elements.length / 2);
        }

        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack<?> stack = (Stack<?>) o;
        return count == stack.count &&
                Arrays.equals(elements, stack.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                ", count=" + count +
                '}';
    }
}
