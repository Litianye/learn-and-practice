package tianye.learn.practice.base;
/**
 * Created by litianye on 2019-04-02
 */


/**
 * @program: learn_and_practice
 *
 * @description: own hash map
 *
 * @author: litianye
 *
 * @create: 2019-04-02
 **/

public class OHashMap<K, V> {
    /**
     * 拉链表：数组+链表
     * 其他参数：容量，
     */
    private Entry<K, V>[] table;
    private int capacity = 16;
    private double loadFactor = 0.75;
    private int threshold = 12;
    private int size = 0;
    private int eCount = 0;

    OHashMap() {}
    OHashMap(int size) {initTable(size);}

    /**
     * @param key
     * @return value
     * 1. null key单独从[0]里找
     * 2. 根据hash，取得下标，便利链表
     */
    public V get(K key) {
        if (key == null) {return getForNullKey();}
        Entry<K, V> e = getEntry(key);
//        if ((e = (Entry<K,V>)UNSAFE.getObject(segments, (j << SSHIFT) + SBASE)) == null)
//        s = ensureSegment(j);

        return e == null ? null : e.getValue();
    }

    //普通的get
    private Entry<K, V> getEntry(K key) {
        if (size == 0) return null;

        int hash = hash(key);
        int index = indexForKey(hash, capacity);

        Entry<K, V> entry = table[index];
        while(entry != null) {
            if (hash == entry.hash &&
                    (entry.getKey() == key || entry.getKey().equals(key))
            ) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }
    //key为null的get
    private V getForNullKey() {
        Entry<K, V> entry = table[0];
        while(entry != null) {
            if (entry.getKey() == null) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    /**
     * @param key
     * @param value
     * @return OldValue
     * 1 数组未初始化则会初始化
     * 2 key为null时特殊处理
     * 3 取得hash和下标
     * 4 如果对应key已经存在，更改value
     * 5 如果对应key不存在，新添加value
     */
    public V put(K key, V value) {
        //初始化table
        if (table == null) {
            initTable(threshold);
        }

        //key为null
        if (key == null) {
            return putForNullKey(value);
        }

        //key不为null，计算hash和下标
        int hash = hash(key);
        int index = indexForKey(hash, capacity);

        Entry<K, V> entry = table[index];

        //已存在key时，更新value
        while (entry != null) {
            if (hash == entry.hash && (key == entry.key || entry.key.equals(key))) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
            entry = entry.next;
        }

        //新增元素
        addEntry(hash, key, value, index);
        //总数++
        eCount ++;
        return null;
    }

    /**
     * 初始化数组
     * 保证是2^n
     */
    private void initTable(int initSize) {
        capacity = roundUpToPowerOf2(initSize);
        //重新计算阈值
        threshold = (int)(capacity * loadFactor);
        table = (Entry<K, V>[]) new Entry[capacity];
    }

    private V putForNullKey(V value) {
        Entry<K, V> entry = table[0];
        if (entry == null) {
            table[0] = new Entry<>(null, value, 0, null);
            return null;
        }

        while (entry != null) {
            if (entry.key == null && entry.hash == 0) {
                V oldValue = entry.value;
                entry.setValue(value);
                return oldValue;
            }
            entry = entry.next;
        }

        table[0] = new Entry<>(null, value, 0, table[0]);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        //当table中已用位置达到阈值，且新插入元素所在下标对应位置不为空，扩容
        if ((size >= threshold) && (null != table[index])) {
            //扩容为原本的两倍
            resize(2 * table.length);
            //新的hash以及下标
            hash = hash(key);
            index = indexForKey(hash, 2*table.length);
        }
        //添加元素
        createEntry(hash, key, value, index);
    }

    private void createEntry(int hash, K key, V value, int index) {
        //头插入元素
        Entry<K, V>  entry = table[index];
        if (entry==null) size++;
        table[index] = new Entry<>(key, value, hash, entry);
    }

    //扩容
    private void resize(int newCapacity) {
        Entry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;

        //旧table达到上限时不再扩大
        if (oldCapacity == Integer.MAX_VALUE) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry<K, V>[] newTable =(Entry<K, V>[]) new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        capacity = newCapacity;
        threshold = (int)(capacity * loadFactor);
    }

    //重新插入元素
    private void transfer(Entry<K, V>[] newTable) {
        Entry<K, V>[] oldTable = table;
        int newCapacity = newTable.length;

        for (int i=0; i<oldTable.length; i++) {
            Entry<K, V> entry = oldTable[i];

            if (entry != null) {
                //将旧table对应位置置空
                oldTable[i] = null;

                do {
                    Entry<K, V> next = entry.next;
                    //在新数组中的下标
                    int newIndex = indexForKey(entry.hash, newCapacity);

                    //位置置换
                    entry.next = newTable[newIndex];
                    newTable[newIndex] = entry;
                    entry = next;
                }while (entry != null);
            }
        }
    }

    public int size() {
        return eCount;
    }

    public int tableSize() {
        return capacity;
    }

    //工具方法

    //移位操作保证是2的倍数
    private int roundUpToPowerOf2(int toSize) {
        int init = 1;
        while (init < toSize) {
            init <<= 1;
        }
        return init;
    }

    private int indexForKey(int hash, int capacity) {
        return hash & (capacity-1);
    }

    private int hash(K key) {
        return key.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                stringBuilder.append("(").append(entry.key).append(":").append(entry.value).append("),");
                entry = entry.next;
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    //元素
    class Entry<K, V> {
        final K key;
        V value;
        final int hash;
        Entry<K,V> next;

        public Entry(K key, int hash) {
            this.key = key;
            this.hash = hash;
        }

        public Entry(K key, V value, int hash, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
