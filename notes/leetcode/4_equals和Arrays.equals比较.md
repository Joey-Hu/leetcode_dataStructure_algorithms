## ==，equals和Arrays.equals的比较

Arrays.equals比较的是两个数组的元素是否相等。

== 比较的是变量(栈)内存中存放的对象的(堆)内存地址，用来判断两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作。

equals用来比较的是两个对象的内容是否相等，由于所有的类都是继承自java.lang.Object类的，所以适用于所有对象，如果没有对该方法进行覆盖的话，调用的仍然是Object类中的方法，而Object中的equals方法返回的却是==的判断。



### Object.equal() 重写/覆盖步骤

1. 比较两个引用是否指向同一个对象；
2. 判断 obj 是否为空；
3. 判断两个引用指向的实际对象的类型是否一致；（obj.getClass()方法或 instanceof）
4. 强制类型转换；
5. 依次比较各个属性是否相同

```java
public boolean equals(Object another) {
 
        //先判断是不是自己,提高运行效率
		if (this == another){
			return true;
		}
		
		if(another == null){
		    return false;
		}
 
        //再判断是不是Person类,提高代码的健壮性
		if (another instanceof Person) {
 
            //向下转型,父类无法调用子类的成员和方法
			Person anotherPerson = (Person) another;
 
            //最后判断类的所有属性是否相等，其中String类型和Object类型可以用相应的equals()来判断
			if ((this.getName().equals(anotherPerson.getName())) && (this.getAge() == anotherPerson.getAge()))
				return true;
		} else {
			return false;
		}
 
		return false;
	}
```



### 参考

https://www.jianshu.com/p/2303cdea87d5
https://blog.csdn.net/skisqibao/article/details/81157745


