package ua.lisovoy.data_structure.map;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vladimir on 02.12.16.
 */
public class HashMap extends AbstractMap{

    private final static int INITIAL_CAPACITY = 5;
    private ArrayList<Entry>[] entries;

    public HashMap(ArrayList<Entry>[] entries) {
        this.entries = new ArrayList[INITIAL_CAPACITY];
    }

    private Entry getEntry(Object key) {
        int index = getIndex(key);
        ArrayList<Entry> bucket = entries[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode())  % entries.length;
    }

    @Override
    public Object put(Object key, Object value) {
        Entry entry = new Entry(key, value);
        int index = getIndex(key);
        ArrayList<Entry> bucket = entries[index];
        if (containsKey(key)) {
            Entry entryPrev = getEntry(key);
            int bucketIndex = bucket.indexOf(entryPrev);
            bucket.set(bucketIndex, entry);
            return entryPrev.value;
        } else {
            if (bucket == null) {
                bucket = new ArrayList<Entry>();
                entries[index] = bucket;
            }
            bucket.add(entry);
            size++;
            return null;
        }
    }


    @Override
    public Object get(Object key) {
        int index = getIndex(key);
        ArrayList<Entry> bucket = entries[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }


    @Override
    public boolean containsKey(Object key) {
        int index = getIndex(key);
        ArrayList<Entry> bucket = entries[index];
        if (bucket == null) {
            return false;
        }
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            put(key, value);
            return value;
        }
        return entry.value;
    }

    @Override
    public Object remove(Object key) {
        if (containsKey(key)) {
            int index = getIndex(key);
            ArrayList<Entry> bucket = entries[index];
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).key.equals(key)) {
                    size--;
                    return bucket.remove(i).value;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "entries=" + Arrays.toString(entries) +
                '}';
    }

    private static class Entry {
        Object key;
        Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

    }
}
