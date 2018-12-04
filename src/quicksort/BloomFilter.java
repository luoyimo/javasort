package quicksort;

/**
 * @Author hu
 * @Description: 布隆过滤  用于判断某个元素在亿级数据中是否存在
 * 精确度有一定损失，建议使用Guava 中的布隆过滤
 * @Date Create In 12:00 2018/12/4 0004
 */
public class BloomFilter {

    private int arraySize;

    private int[] array;

    public BloomFilter(int arraySize) {
        this.array = new int[arraySize];
        this.arraySize = arraySize;
    }

    private int firstHash(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i) {
            hash = 31 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    private int secondHash(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    private int thirdHash(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }


    /**
     * 写入数据
     *
     * @param key
     */
    public void add(int key) {
        int first = firstHash(key + "");
        int second = secondHash(key + "");
        int third = thirdHash(key + "");

        array[first % arraySize] = 1;
        array[second % arraySize] = 1;
        array[third % arraySize] = 1;

    }


    /**
     * 判断数据是否存在
     *
     * @param key
     * @return
     */
    public boolean check(int key) {
        int first = firstHash(key + "");
        int second = secondHash(key + "");
        int third = thirdHash(key + "");

        int firstIndex = array[first % arraySize];
        if (firstIndex == 0) {
            return false;
        }

        int secondIndex = array[second % arraySize];
        if (secondIndex == 0) {
            return false;
        }

        int thirdIndex = array[third % arraySize];
        if (thirdIndex == 0) {
            return false;
        }

        return true;

    }


    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(100000000);
        for (int i = 1000; i < 100000000; i++) {
            bloomFilter.add(i);
            i = i + 2;
        }
        boolean check = bloomFilter.check(10000009);
        System.out.println(check);
    }
}
