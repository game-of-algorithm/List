#排序

###选择排序
* 选择排序
    * 对于长度为N的数组，选择排序需要大约N^2/2次比较和N次交换
    * 运行时间与输入无关、数据移动是最少的
* 插入排序
    * 对于随机排列的长度为N且主键不重复的数组，平均情况下插入排序需要～N^2/4
    次比较以及～N^2/4次交换。最坏情况下需要～N^2/2次比较和～N^2/2次交换
    ，最好的情况下需要N-1次比较和0次交换
    * 插入排序对于实际应用中常见的某些类型的非随机数组很有效（有序数组）。
    * 提高插入速度：内循环中将较大的元素向右移动而不总是交换两个元素（这样访问数组的次数就能减半）。
* 希尔排序
    * 基于插入排序的排序算法，交换不相邻的元素以对数组的局部进行排序，并最终用插入排序将局部
    有序的数组排序
    * 思想：使数组中任意间隔为h的元素都是有序的（h有序数组），一个h有序数组就是h个互相独立的有序数组
    编织在一起组成的一个数组。如果h很大，我们就能将元素移动到很远的地方。将相距某个"增量"的记录组成一个
    序列，这样就能保证在子序列内分别进行直接插入排序后得到的结果是基本有序。
    * 时间复杂度突破n^2,2^3/2左右，增量的选择还是数学难题，常规用increment = increment/3+1;增量值的最后
    一个增量值必须等于1；
    * 由于是跳跃式移动，所以不是稳定的排序算法
* 归并排序
    * 利用归并的思想实现的排序算法；分治思想典型的一个例子；
    * 原理：假设初始序列含有n个记录，则可以看成n个有序的子序列，每个子序列长度为1，然后两两归并，得到n/2个长度
    为2或1的有序子序列；再两两归并，直至得到一个长度为n的有序序列为止
    * 时间复杂度O(NlogN) （整个归并排序需要进行logN次每次需要所有记录扫描一遍N）,空间复杂度O(N) （n个辅助存储空间+logN栈空间）
    * 需要两两比较，不存在跳跃，因此归并排序是一种稳定的排序算法
 