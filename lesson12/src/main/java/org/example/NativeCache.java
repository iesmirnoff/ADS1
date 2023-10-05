
package org.example;

import java.lang.reflect.Array;

@SuppressWarnings("rawtypes, unchecked")
class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    private int quantity;

    public NativeCache(int sz, Class clazz) {

        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[size];
        quantity = 0;
    }

    public T get(String key) {
        int index = find(key);
        if (index >= 0) {
            hits[index]++;
            return values[index];
        } else {
            return null;
        }
    }

    public int put(String key, T value) {
        int index = find(key);
        if (index >= 0) {
            hits[index]++;
            return index;
        }
        if (quantity == size) {
            index = findMaxHit();
            slots[index] = key;
            values[index] = value;
            hits[index] = 1;
            return index;
        }
        if (quantity < size) {
            index = hashFun(key);
            for (int i = (index + 1) % size; i != index; i = (i + 1) % size) {
                if (slots[i] == null) {
                    slots[i] = key;
                    values[i] = value;
                    hits[i] = 1;
                    quantity++;
                    return i;
                }
            }
        }
        return -1;
    }

    private int findMaxHit() {
        int hit = 0;
        for (int i : hits) {
            if (i > hit) {
                hit = i;
            }
        }
        return hit;
    }

    private int hashFun(String value)
    {
        int hashCode = value.hashCode();
        hashCode = hashCode >= 0 ? hashCode : hashCode * -1;
        return hashCode % size;
    }

    private int find(String key)
    {
        int indexByHash = hashFun(key);
        if (key.equals(slots[indexByHash])) {
            return indexByHash;
        }
        for (int i = (indexByHash + 1) % size; i != indexByHash; i = (i + 1) % size) {
            if (key.equals(slots[i])) {
                return i;
            }
        }
        return -1;
    }
}