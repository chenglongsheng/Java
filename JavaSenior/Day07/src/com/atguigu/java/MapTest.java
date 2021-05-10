package com.atguigu.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * |----Map：双列数据，储存key-value对的数据    ---类似于高中的函数：y=f(x)
 *     |----HashMap：作为Map的主要实现类；线程不安全的，效率高；储存null的key和value
 *          |----LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *          原因：在原有的HashMap底层结构基础上，添加一对指针，指向前一个和后一个元素。
 *          对于频繁的遍历操作，此类执行效率高于HashMap。
 *     |----TreeMap：保证按照添加的key-value对进行排序，是先排序遍历。此时考虑key的自然排序或者定制排序
 *                   底层使用红黑树
 *     |----TreeTable：作为古老的实现类；线程安全的，效率低；不能储存null的key和value；
 *          |----Properties：常用来处理配置文件。key和value都是String类型
 *
 *   HashMap的底层：数组+链表（jdk 7 及之前）
 *                 数组+链表+红黑树（jsk 8）
 * 面试题：
 *  1.HashMap的底层实现原理？
 *  2.HashMap 和 Hashtable的异同？
 *  3.CurrentHashMap 与 Hashtable的异同？
 *
 * 二、Map结构的理解：
 *      Map中的key：无序的、不可重复的，使用Set储存所有的key -->key所在的类要重写equals()和hashCode() （以HashMao为例）
 *      Map中的value：无序的、可重复的，使用Collection储存所有的value -->key所在的类要重写equals()
 *      一个键值对：key-value构成了一个Entry对象。
 *      Map中的entry：无序的、不可重复的，使用Set储存所有的entry
 *
 * 三、HashMap的底层实现原理？（以 jdk 7 为例）
 *      HashMap map = new HashMap();
 *      在实例化以后，底层创建了长度为16的一维数组Entry[] table。
 *      。。。可能执行过多次put。。。
 *      map.put(key1, value1);
 *      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法以后，得到再Entry数组中的存放位置。
 *      如果此位置上的数据为空，此时的key1-value1添加成功。---（1）
 *      如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表方式存在）），比较key1和已经存在的一个或多个数据的哈希值：
 *          如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功---（2）
 *          如果key1的哈希值和已经存在的某一个数据（key2-value2）的哈希值相同继续比较：调用key1所在类的equals(key2)方法，比较：
 *              如果equals()返回false：此时key1-value1添加成功。---（3）
 *              如果equals()返回true：使用value1替换value2
 *      补充：（2）（3）：此时key1-value1和原来的数据以链表方式存储
 *
 *      在不断添加的过程中，会涉及到扩容问题，当超出临界值（且要存放的位置非空）时，扩容。默认的扩容方式：扩容为原来容量的两倍，并将原有的数据复制过来
 *
 *      jdk8 相较于 jdk7 在底层实现原理的不同：
 *          1.new HashMap();底层没有创建一个长度为16的数组
 *          2.jdk8 底层的数组是Node[]，而非Entry[]
 *          3.首次调用put()时，底层创建长度16的数组
 *          4.jdk7 底层结构只有数组+链表。jdk8中底层结构：数组+链表+红黑树
 *              4.1.形成链表时，七上八下，（jdk7：新元素指向旧的元素。jdk8：旧的元素指向新的元素）
 *              4.2.当数组上的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前的数组的长度 > 64时，此时此索引位置上的所有数据改为使用红黑树存储
 *
 * DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 * DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 * threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
 * TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
 * MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
 *
 * 四、linkedHashMap的底层实现原理
 *  源码中：
 *        static class Entry<K,V> extends HashMap.Node<K,V> {
 *              Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *              Entry(int hash, K key, V value, Node<K,V> next) {
 *                 super(hash, key, value, next);
 *              }
 *          }
 *
 * @author chenglongsheng
 * @create 2021-05-07 11:03
 */
public class MapTest {

    @Test
    public void test2() {
        Map map = new HashMap();

        map.put(123,"AA");
        map.put(456,"BB");
        map.put(789,"CC");

        System.out.println(map);
    }

    @Test
    public void test1() {
        Map map = new HashMap();

        map.put(null,null);

    }
}
