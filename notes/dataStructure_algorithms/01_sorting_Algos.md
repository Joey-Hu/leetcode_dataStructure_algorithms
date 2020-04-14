## 十大排序算法

### 1. 排序算法分类

十种常见排序算法可以分为两大类：

> 比较类：通过比较来决定元素间的相对次序，由于**其时间复杂度不能突破O(nlogn)**，因此也称为非线性时间比较类排序。
> 非比较类：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为**线性时间**非比较类排序。 

!["算法分类.png"](/img/算法分类.png)

算法复杂度

!["时间复杂度.png"](/img/时间复杂度.png)

> 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。
> 不稳定：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。

#### 2. 排序算法简介

#### 2.1 冒泡排序

算法描述：

重复遍历要排序的数组，比较相邻的两个元素的大小，如果顺序错误就交换，直到没有再要交换的元素。

!["bubbleSort.gif"](/img/bubbleSort.gif)

代码实现：

```java
    public void bubleSort(int[] nums){

        int length = nums.length;

        for(int i=0; i<length-1; i++){
            for(int j=1; j<=length-1-i;j++){
                if(nums[j]<nums[j-1]){
                    swap(nums, j, j-1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
    }
```



#### 2.2 选择排序

算法描述：

首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

!["selectionSort"](/img/selectionSort.gif)

代码实现：

```java
public void selectionSort(int[] nums){

        int length = nums.length;
        int minIndex;

        for(int i=0; i<length-1; i++){
            minIndex = i;
            for(int j=i+1; j<length; j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
    }
```

### 参考

https://www.cnblogs.com/onepixel/articles/7674659.html