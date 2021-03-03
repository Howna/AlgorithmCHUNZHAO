# 第五周学习总结

## 1.AVL树与红黑树

1.树的三种遍历

```java
def preorder(self,root):

	if root:
		self traverse_path append(root val)
		self preorder(root left)
		self preorder(root right)

def inorder(self,root):

	if root:
		self inorder(root left):
		self traverse_path append(root val)
    		self inorder(root right)

def postorder(self,root):

        if root:
		self postorder(root left)
   		self postorder(root right)
		self traverse_path append(root val)
```

AVL树：右子树的高度-左子树的高度 的 绝对值 小于1

四种旋转：

右右子树：左旋

左左子树：右旋

先左子树再右子树：左右子树型→左右旋

先右后左

2.红黑树

红黑树是一种近似平衡的二叉搜索树（Binary search tree）,它能够确保任何一个结点的左右子树的高度差小于2倍。具体来说，红黑树是满足如下条件的二叉搜索树：

1.每个结点要么是红色，要么是黑色。

2.根节结是黑色

3.每个叶结点（NIL节点，空节点）是黑色的。

4.不能有相邻接的两个红色结点

5.从任一节点到其每个叶子结点的所有路径都包含相同数目的黑色结点。

AVL树和红黑树的对比

1）AVLtrees provide faster lookups than Red Black Trees because they are more strictly balanced.

AVL树比红黑树能够提供更快的查询因为它是更加严格的平衡的。（即从读和查找性能来说AVL是更好的）

2）Red Black Trees provide faster insertion and removal operations than AVLtrees as fewer rotations are done due to relatively relaxed balancing.

红黑树比AVL树能够提供更快的插入和删除操作，因为AVL 的旋转操作会更多。红黑树相对少，因为红黑树只是一个近似平衡树。

3）AVLtrees store balance factors or heights with each node, thus requires storageforan integer per node whereas Red Black Tree requires only 1 bit of infomation pernode.

AVL要存的额外的信息更多，需要更多的内存，附加在每个结点来存额外的信息。而红黑树要的信息非常少，只需一个bit 存0和1表示黑或红，对额外的空间消耗较少。

4）Red BlackTrees are used in most of the language libraries like map, multimap, multisetin C++whereasAVLtrees are usedin databases wherefaster retrievals are required.

在读操作非常多写操作比较少的情况下，用AVL 就好，AVL插入删除调整较为繁琐，优点是平衡，所以查询快。如果插入操作较多或插入和查找一半一半，用红黑树，因为红黑树更简洁，容易实现。

## 2.异或

1.或：只要有一个是1，两者相或就为1

2.与：只要有一个二进制位是0，两者相与为0

3.按位取反：把0变成1，把1变成0

4.按位异或：相同为0，不同为1

x^0 = x 只要x和0相同的就是0，不同的就是1

 x ^1s=~s [//1s=~0](//1s=~0)  1s指的是全1 全1就是0取反

x^(~x)=1s

x^x = 0

c = a^b ⇒ a^c=b, b^c = a /交换两个数

a^b^c=a^(b^c) = （a^b）^c

1.将×最右边的n位清零: x &(~0<<n)

2.获取×的第n位值（0或者1): (x >>n) &1

3.获取×的第n位的幂值:x & (1<<n)

4.仅将第n位置为1: x | (1<<n)

5.仅将第n位置为0: x&(~(1<<n))

6.将×最高位至第n位(含）清零: x &((1<<n)-1)

判断奇偶：

x%2==1—>(x&1)==1

     x%2==0>(x&1)==0

    

x >>1—>x/2

即:x=x/2;—>x=x >>1;

mid =(left +right)/ 2; →>mid =(left +right) >>1;

X=X&(X-1)清零最低位的1

X&-X→>得到最低位的1· x&~X=>0

x&~X=>0
