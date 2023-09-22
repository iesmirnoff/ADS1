package com.iesmirnoff;
import java.util.*;

public class Deque<T>
{
    private final LinkedList<T> buffer;

    public Deque()
    {
        // инициализация внутреннего хранилища
        buffer = new LinkedList<>();
    }

    public Deque(T[] array)
    {
        buffer = new LinkedList<>(Arrays.asList(array));
    }

    public void addFront(T item)
    {
        // добавление в голову
        buffer.addFirst(item);
    }

    public void addTail(T item)
    {
        // добавление в хвост
        buffer.addLast(item);
    }

    public T removeFront()
    {
        // удаление из головы
        try {
            return buffer.removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public T removeTail()
    {
        // удаление из хвоста
        try {
            return buffer.removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public int size()
    {
        return buffer.size(); // размер очереди
    }

    public boolean checkPalindrome() {
        while (size() > 1) {
            T front = removeFront();
            T tail = removeTail();
            try {
                if (!front.equals(tail)) {
                    return false;
                }
            } catch (NullPointerException e) {
                if (front != tail) {
                    return false;
                }
            }
        }
        return true;
    }
}