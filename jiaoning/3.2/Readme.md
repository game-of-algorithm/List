A C E  H R S X 

如果被访问概率不平均，那么就是网上所讲的动态规划那种？
如果概率平均，那么就保证树的深度最小， 也就是满二叉树？
达到平衡就是这种   
H
C        S
A   E   R   X
这里正好是7个结点  应该是 深度为2的完全二叉树
所以根结点只能是H  划分两部分
同上将 C 和 S 分别为 H 的子结点。
同上A E为C的子节点  R X 为S的子节点

第一次需要插入H ，第二次需要插入C 或者S，剩余的4个数随便如何顺序插入
可以有1*2*4*3*2*1 = 48种组合
