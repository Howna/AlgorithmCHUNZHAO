### 高效学习算法的方法
#### 学习方法误区：<br /> 
死磕一道题  一道题只做一遍

###### 练习步骤
1.5-10分钟：读题和思考<br />
2.有思路：自己开始做和写代码；不然，马上看题解！<br />
3.默写背诵、熟练<br />
4.然后开始自己写（闭卷）<br />

###### 算法题面试四件套：<br />
1.clarification（和面试官确认题目的含义）<br />
2.possible solutions(compare,optimal)（思考所有可能的解法，找到最优解法）<br />
3.coding（写代码）<br />
4.test cases （测试）
###### 五毒神掌学习法
1.读题+思考；看解法并比较不同解法的优缺点<br />
2.直接写，提交-->优化<br />
3.一天后再进行练习<br />
4.一周后练习<br />
5.面试之前进行薄弱环节的练习（恢复性）<br />

#### 1.数组 链表 跳表

##### 数组
prepend&nbsp;&nbsp;O(1)<br />
append&nbsp;&nbsp;&nbsp;O(1)<br />
lookup&nbsp;&nbsp;&nbsp;&nbsp;O(n)<br />
insert&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O(n)<br />
delete&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O(n)<br />
##### 注意：
<font color='red'>注意: 正常情况下数组的prepend操作的时间复杂度是0==(n)，但是可以进行特殊优化到0(1)。采用的方式是申请稍大一些的内存空间，然后在数组最开始预留一部分空间，然后prepend的操作则是把头下标前移一个位置即可。 </font> :(
##### 普通链表
prepend&nbsp;&nbsp;O(1)<br />
append&nbsp;&nbsp;&nbsp;O(1)<br />
lookup&nbsp;&nbsp;&nbsp;&nbsp;O(n)<br />
insert&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O(1)<br />
delete&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O(1)<br />

##### 跳表
只能用于元素有序的情况。）对标的是平衡树（AVL Tree）和二分查找， 是一种 插入/删除/搜索 都是 O(log n)的数据结构。最大的优势是原理简单、容易实现、方便扩展、效率更高。因此在一些热门的项目里用来替代平衡树，如 Redis、LevelDB 等。
![image](507CBA618FAF4D3AA71BD441FF89A5F4)
##### 跳表查询的时间复杂度 O(logn)
##### 空间复杂度是 O(n)

#### 2.栈 队列 优先队列 双端队列
###### <font color='red'>优先队列</font>
1.插入操作：O(1)

2.取出操作：O(logN) - 按照元素的优先级取出

3.底层具体实现的数据结构较为多样和复杂：heap、bst、treap

Java 的 PriorityQueue https://docs.oracle.com/javase/10/docs/api/java/util/ PriorityQueue.html 

Stack 和 Queue 的实现
Java 源码分析:

Stack: http://developer.classpath.org/doc/java/util/Stacksource.html 
 
Queue: http://fuseyism.com/classpath/doc/java/util/Queuesource.html 
复杂度分析：
![image](1A0396290AAB45EC9D8D0ACE16E07CB9)

#### 3.哈希表 映射 集合
HashMap 的详细解释：https://tech.meituan.com/2016/06/24/java-hashmap.html

###  学习心得
1.本期练习的很多题目都是之前做过的，但是只做了一遍，发现很多又完全没有印象变成了新题。所以一道题多做几遍是很有必要的，主要是时间看上的管理和控制。前3遍是最重要的，当天/隔天/一周，需要在时间上做调整，否则每天都只是做新题，无法起到练习的效果。<br />

2.java语言不熟，文档也没有按照要求去看，依然是时间上的问题，需要调整。upup！
