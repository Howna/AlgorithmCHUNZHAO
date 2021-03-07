# 第六周学习总结

### 来自威威老师的教导

面试回答问题的时候不要带有个人色彩。在面试回答问题和看待一个人和事物的时候，可参考的回答模式是：具体问题应该具体分析，在什么情况下，用什么样的算法。

参考：[十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)；[威威哥的算法笔记-排序](https://www.yuque.com/liweiwei1419/algo/rxccis)

![image](https://github.com/Howna/AlgorithmCHUNZHAO/blob/main/Week_06/sort_mind.png)

### 相关概念

- **稳定**：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。
- **不稳定**：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。
- **时间复杂度**：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。
- **空间复杂度**:是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数

![image](https://github.com/Howna/AlgorithmCHUNZHAO/blob/main/Week_06/sort_comp.png)
## 一.插入排序

### 1.1简单插入排序

**思路**：从第一个数字开始排 ，每次都把待排序中的一个数字插入到前面的已排序数组当中，成为一个长度更长的有序数组。有限次操作之后，数组就会有序。

- **代码：基于交换**

```java
//插入排序
public class Solution{
	public int[] insertSort(int[] nums){
		int len = nums.lenght;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if (nums[j-1] > nums[j]) {
					 swap(nums, j, j-1);
				} else {
						break;
				}
			}	
		}
	return nums;	
	}
	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}
```

### 1.2.**希尔排序（Shell Sort）**

1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。

## 二.选择排序

### 2.1.简单选择排序

思路：每一轮都选择出未排序部分中最小的元素，把这个最小元素和未排序部分的第一个元素进行交换。重复n-1轮。就能得到升序数组。

```java
//简单选择排序
public class Solution{
	public int[] selectSort(int[] nums){
		int len = nums.lenght;
		for(int i = 0; i < len; i++){
			int minIndex = i;
			for(int j = i+1; j < len; i++){
				if(nums[j] < nums[minIndex]){
					minIndex = j;
				}
			}
			swap(nums, i, minIndex);
		}
	return nums;	
	}
	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

}
```

算法思想：

1.贪心算法：每一次都寻找当前待排序数组的最小值。

2.减治思想：外层循环每一次排定一个元素，问题规模旧减少一个元素，直到所有的元素都被排序。

### 2.2.堆排序

堆排序是对简单选择排序的一种改进，这种改进的效果是非常明显的。

堆是具有下列性质的完全二叉树：

每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。

从堆的定义可以知道，根节点一定是堆中所有结点最大（小）者。

**二叉树的性质5完全适用于堆结构的特点：**

如果对一棵有n个结点的完全二叉树（其深度为【$Log_2n$】+1）的结点按层序编号（从第1层到第【$Log_2n$】+1层，每层从左到右），对任一结点i (1 ≤ i ≤ n) 有：

1.如果 i = 1， 则结点 i 是二叉树的根，无双亲；如果 i  > 1  , 则其双亲是结点[i / 2]

2.如果2i > n , 则结点 i 无左孩子（结点 i 为叶子）； 否则其左孩子是结点2i

3.如果 2i + 1 > n. 则结点 i 无右孩子； 否则其右孩子是结点 2i + 1；

**思想：**堆排序就是利用堆（假设利用大顶堆）进行排序的方法。它的基本思想是，将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根结点。将它移走之后（其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值），然后将剩余的n-1个序列重新构造成一个堆，这样就会得到n个元素中的次大值。如此反复执行，便能得到一个有序序列了。

1.如何由一个无序序列构建成一个堆？

2.如果在输出堆顶元素后，调整剩余元素称为一个新的堆？

```java
/*对顺序表L进行堆排序*/
void HeapSort(SqList *L) {
	int i;
	for(i = L->length/2; i > 0; i--) { /*把L中的r构建成一个大顶堆*/
		HeapAdjust(L, i, L->length);
	}

	for(i=L->length; i > 1; i--) { //
		swap(L，1, i);/*将堆顶记录和当前未经排序子序列的最后一个记录交换*/
		HeapAdjust(L,1,i-1);/*将L->r[1..i-1]重新调整为大顶堆*/
	}
}
```

排序过程分为两个for循环。第一个循环要完成的就是将现在的待排序序列构建成一个大顶堆。第二个for循环就是逐步将每个最大值的的根结点与末尾元素交换，并且再调整为大顶堆。

```java
/*已知L->r[s..m]中记录的关键字除了L-r[s]之外均满足堆的定义*/
/*本函数调整L->r[s]的关键字，使L->r[s..m]成为一个大顶堆*/
void HeapAdjust(SqList *L,int s,int m){
	int temp,j;
	temp = L->r[s];
	for(j=2*s; j<=m; j*=2){  /*沿关键字较大的孩子结点向下筛选*/
		if(j<m && L->r[j]<L->r[j+1])
			++j;             /*j为关键字中较大的记录的下标*/

		if(temp>=L->r[j]) 
			break;           /*rc应该插入在位置s上*/
		L->r[s]=L->r[j];
		s=j;
	}
	L->r[s]=temp;            /*插入*/
}
```

堆排序代码示例：

```java
//堆排序
static void heapify(int[] array, int length, int i) {    
	int left = 2 * i + 1, right = 2 * i + 2;    
	int largest = i;    
	if (left < length && array[left] > array[largest]) {        
		largest = left;    
	}    
	if (right < length && array[right] > array[largest]) {        
		largest = right;    
	}    
	if (largest != i) {        
		int temp = array[i]; 
		array[i] = array[largest]; 
		array[largest] = temp;        
		heapify(array, length, largest);    
	}
}

public static void heapSort(int[] array) {    
	if (array.length == 0) return;    
	int length = array.length;    
	for (int i = length / 2-1; i >= 0; i--)         
	heapify(array, length, i);    
	for (int i = length - 1; i >= 0; i--) {        
		int temp = array[0]; array[0] = array[i]; array[i] = temp;        
		heapify(array, i, 0);    
	}
}
```

## 三.交换排序

### 3.1冒泡排序

1.从头到尾，相邻的两个元素进行比较，把比较大的元素交换到后面。一轮循环下来，就可以找到最大的元素。

2.每一轮循环把一轮循环中最大的元素放到了末尾（未排序的部分的末尾），因此它不需要再参加下一轮的循环。所以，内层循环的终止条件是  **`j < len - i - 1`**

```java
//冒泡排序
public class Solution{
	public int[] bubbleSort(int[] nums){
		int len = nums.lenght;
		for(int i = 0; i < len; i++){
			
			for(int j = 0; j < len - i - 1; i++){
				if(nums[j] < nums[j+1]){
					swap(nums, j, j+1);
				}
			}
		}
	return nums;	
	}
	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

}
```

### 3.2快速排序

思路：快速排序每一次都排定一个元素（这个元素放在了它最终应该在的位置），然后递归地去排它左边的部分和右边的部分，依次进行下去，直到数组有序；

```java
//快速排序
public static void quickSort(int[] array, int begin, int end) {    
	if (end <= begin) return;    
	int pivot = partition(array, begin, end);    
	quickSort(array, begin, pivot - 1);    
	quickSort(array, pivot + 1, end);
}
static int partition(int[] a, int begin, int end) {    
// pivot: 标杆位置，counter: 小于pivot的元素的个数    
	int pivot = end, counter = begin;    
	for (int i = begin; i < end; i++) {        
		if (a[i] < a[pivot]) {            
			int temp = a[counter]; a[counter] = a[i]; a[i] = temp;            
			counter++;        
		}    
	}    
	int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;    
	return counter;
}
```

## 四.归并排序

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。

思路：首先把长度为n的输入序列分成两个长度为n/2的子序列；然后堆对这两个子序列分别采用归并排序；将两个排序好的子序列合并成一个最终的排序序列。

```java
public static void mergeSort(int[] array, int left, int right) {    
	if (right <= left) return;    
	int mid = (left + right) >> 1; // (left + right) / 2    
	mergeSort(array, left, mid);    
	mergeSort(array, mid + 1, right);    
	merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {        
	int[] temp = new int[right - left + 1]; 
	// 中间数组        
	int i = left, j = mid + 1, k = 0;        
	while (i <= mid && j <= right) {            
		temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];        
	}        
	while (i <= mid)   temp[k++] = arr[i++];        
	while (j <= right) temp[k++] = arr[j++];        
		for (int p = 0; p < temp.length; p++) {            
	arr[left + p] = temp[p];        
	}        
	// 也可以用 System.arraycopy(a, start1, b, start2, length)    
}
```

## 五.非比较排序

### 5.1计数排序

计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

当输入的元素是n个0到k之间的整数时，时间复杂度是O(n+k)，空间复杂度也是O(n+k)，其排序速度快于任何比较排序算法。当k不是很大并且序列比较集中时，计数排序是一个很有效的排序算法。

### 简单理解

统计数组中所有的数值出现的次数，然后再从小到大依次填充数值，每一个数值出现了几次就填充几次。

### **算法描述**

- 找出待排序的数组中最大和最小的元素；
- 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
- 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
- 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。

**代码**

```java
//计数排序
public int[] sortArray(int[] nums) {
		int begin = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
		for (int num : nums) {
			begin = Math.min(begin, num);
			end = Math.max(end, num);
		}
		return sortArray(nums, begin, end);
	}
	private int[] sortArray(int[] nums, int begin, int end) {
		int len = end - begin + 1, index = 0;
		int[] array = new int[len];
		for (int num : nums) {
			array[num - begin]++;
		}
		for (int i = 0; i < len; i++) {
			while (array[i]-- != 0) {
				nums[index++] = begin + i;
			}
		}
		return nums;
	}
```

### 5.2桶排序

桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。

桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。

### 简单理解

类似于HashMap下键值对，一个桶相当于一个键值对，一个桶里面可以放好几个数，一个键也可以对应好几个值。（**[HashMap参考](https://zhuanlan.zhihu.com/p/21673805)**）

### **算法描述**

- 设置一个定量的数组当作空桶；
- 遍历输入数据，并且把数据一个一个放到对应的桶里去；
- 对每个不是空的桶进行排序；
- 从不是空的桶里把排好序的数据拼接起来。

**代码**

```java
//桶排序  此代码相当于一个数值一个桶value保存的是该数值出现的次数
public int[] sortArray(int[] nums) {
		int begin = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			begin = Math.min(begin, num);
			end = Math.max(end, num);
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int index = 0, count;
		for (int i = begin; i <= end; i++) {
			count = map.getOrDefault(i, 0);
			while (count-- != 0) {
				nums[index++] = i;
			}
		}
		return nums;
	}
```

### 5.3基数排序

基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。

### 简单理解

基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。

[看动图理解](https://www.cnblogs.com/onepixel/p/7674659.html)

### **算法描述**

- 取得数组中的最大数，并取得位数；
- arr为原始数组，从最低位开始取每个位组成radix数组；
- 对radix进行计数排序（利用计数排序适用于小范围数的特点）

**代码**

```java
public int[] sortArray(int[] nums) {
		int digits = 0, temp = 1, mark = 10;
		for (int num : nums) {
			while (num / temp != 0) {
				digits++;
				temp *= mark;
			}
		}
		return radixSort(nums, digits);
	}
	private int[] radixSort(int[] nums, int digits) {
		Map<Integer, List<Integer>> map = new HashMap<>(10);
		int temp = 1, mark = 10, startNum = -9, endNum = 9;
		while (digits-- > 0) {
			for (int num : nums) {
				int n = num / temp % mark;
				List<Integer> list = map.getOrDefault(n, new ArrayList<>());
				list.add(num);
				map.put(n, list);
			}
			for (int i = startNum, index = 0; i <= endNum; i++) {
				if (!map.containsKey(i)) {
					continue;
				}
				List<Integer> list = map.get(i);
				for (int num : list) {
					nums[index++] = num;
				}
				map.put(i, new ArrayList<>());
			}
			temp *= mark;
		}
		return nums;
	}
```

基数排序基于分别排序，分别收集，所以是稳定的。但基数排序的性能比桶排序要略差，每一次关键字的桶分配都需要O(n)的时间复杂度，而且分配之后得到新的关键字序列又需要O(n)的时间复杂度。假如待排数据可以分为d个关键字，则基数排序的时间复杂度将是O(d*2n) ，当然d要远远小于n，因此基本上还是线性级别的。基数排序的空间复杂度为O(n+k)，其中k为桶的数量。一般来说n>>k，因此额外空间需要大概n个左右。
