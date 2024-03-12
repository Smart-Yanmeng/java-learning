# Lambda表达式

## 1.需求分析

创建一个新的线程，指定线程要执行的任务

```java
public static void main(String[] args) {
        // 开启一个新的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程中执行的代码：" + Thread.currentThread().getName());
            }
        }).start();
        System.out.println("主线程中的代码：" + Thread.currentThread().getName());
    }
```

代码分析：

1. Thread类需要一个Runnable接口作为参数，其中的抽象方法run方法是用来指定线程任务内容的核心
2. 为了指定run方法，不得不需要Runnable的实现类
3. 为了省去定义一个Runnable的实现类，不得不使用匿名内部类
4. 必须覆盖重写抽象的run方法，所有的方法名称，方法参数，方法返回值不得不都重写一遍，而且不能出错
5. 而实际上，我们只在乎方法体中的代码



## 2.Lambda表达式初体验

Lambda表达式是一个匿名函数，可以理解为一段可以传递的代码
```java
new Thread(() -> {
            System.out.println("新线程Lambda表达式..." + Thread.currentThread().getName());
        }).start();
```

Lambda表达式的优点：简化了匿名内部类的使用，语法更加简单

匿名内部类语法冗余，体验了Lambda表达式后，发现Lambda表达式事简化匿名内部类的一种方式



## 3.Lamda的语法规则

Lambda省去了面向对象的条条框框，Lambda的标准格式由三个部分组成：
```java
(参数类型 参数名称) -> {
    代码体;
}
```

格式说明：

- (参数类型 参数名称)：参数列表
- {代码体;}：方法体
- ->：箭头，分割参数列表和方法体



## 4.1 Lambda练习一

​	练习无参无返回值的Lambda

定义一个接口
```java
public interface UserService {
    void show();
}
```

然后创建主方法使用
```java
public static void main(String[] args) {
        goShow(new UserService() {
            @Override
            public void show() {
                System.out.println("show 方法执行了...");
            }
        });
        System.out.println("-------------------------------");
        goShow(() -> {
            System.out.println("Lambda show 方法执行了...");
        });
    }

    public static void goShow(UserService userService) {
        userService.show();
    }
```

输出
```bash
show 方法执行了...
-------------------------------
Lambda show 方法执行了...
```



## 4.2 Lambda练习二

​	完成一个有参且有返回值的案例

创建一个Person对象
```java
public class Person {

    private String name;

    private Integer age;

    private Integer height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
```

在List集合中保存多个Person对象，然后对这些对象根据age排序操作
```java
public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("周杰伦", 33, 175));
        list.add(new Person("刘德华", 43, 185));
        list.add(new Person("周星驰", 38, 177));
        list.add(new Person("郭富城", 23, 170));

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (Person person : list) {
            System.out.println(person.toString());
        }
    }
```

发现在sort方法的第二个参数是一个Comparator接口的匿名内部类，且执行的方法有参数和返回值，那么我们可以改写为Lambda表达式
```java
public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("周杰伦", 33, 175));
        list.add(new Person("刘德华", 43, 185));
        list.add(new Person("周星驰", 38, 177));
        list.add(new Person("郭富城", 23, 170));
    
        Collections.sort(list, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();
        });
        for (Person person : list) {
            System.out.println(person.toString());
        }
}
```

输出结果
```bash
Person{name='郭富城', age=23, height=170}
Person{name='周杰伦', age=33, height=175}
Person{name='周星驰', age=38, height=177}
Person{name='刘德华', age=43, height=185}
```



## 4.@FunctionalInterface注解

```java
/**
 * @FunctionalInterface
 *
 * 这是一个标志注解，被该注解修饰的接口只能声明一个抽象方法
 */
@FunctionalInterface
public interface UserService {
    void show();
}
```



## 5.Lambda表达式的原理

匿名内部类的本质事在编译时生成一个class文件，xxxx$0.class

还可以通过反编译工具来查看生成的代码XJad工具查看

那么Lambda表达式的原理是什么呢？
写的有Lambda表达式的class文件，我们通过XJad查看报错。这时我们可以通过JDK自带的一个工具：javap对字节码进行反汇编操作

```shell
javap -c -p 文件名.class
-c：表示对代码进行反汇编
-p：显示所有的类和成员
```

在这个反编译的源码中，出现了一个静态方法，通过debug方式查看
为了更加直观地理解这个内容，我们可以在运行的时候添加-Djdk.internal.lambda.dumpProxyClasses，加上这个参数会将内部class码输出到一个文件中

```shell
-Djdk.internal.lambda.dumpProxyClasses 要运行的包名
```

可以看到这个匿名内部类实现了UserService接口，并重写了show()方法。在show方法中调用了Demo03Lambda.lambda$main$0()，就是调用了Lambda中的内容

小结：
匿名内部类在编译的时候会产生一个class文件。
Lambda表达式在程序运行的时候会形成一个类。

1. 在类中新增了一个方法，这个方法的方法体就是Lambda表达式中的代码
2. 还会形成一个匿名内部类，实现接口，重写抽象方法
3. 在接口中重写方法会调用新生成的方法

## 6.Lambda表达式的省略写法

在Lambda表达式的标准写法基础上，可以使用省略写法的规则为：

1. 小括号内的参数类型可以省略
2. 如果小括号内有且仅有一个参数，则小括号可以省略
3. 如果大括号内有且仅有一个语句，可以同时省略大括号，return关键字及语句分号

```java
public static void main(String[] args) {
        goStudent((String name, Integer age) -> {
            return name + age + " 666...";
        });
        // 省略写法
        goStudent((name, age) -> name + age + " 666...");

        System.out.println("----------------------------");
        goOrder((String name) -> {
            System.out.println("--->" + name);
            return 666;
        });
        // 省略写法
        goOrder(name -> {
            System.out.println("--->" + name);
            return 666;
        });
    }

    public static void goStudent(StudentService studentService) {
        studentService.show("张三", 22);
    }

    public static void goOrder(OrderService orderService) {
        orderService.show("李四");
    }
```



## 7.Lambda表达式的使用前提

Lambda表达式的语法是非常简洁的，但是Lambda表达式不是随便使用的，使用时有几个条件要特别注意

1. 方法的参数或局部变量类型必须为接口才能使用Lambda
2. 接口中有且仅有一个抽象方法(@FunctionalInterface)



## 8.Lambda和匿名内部类的对比

1. 所需类型不一样
   1. 匿名内部类的类型可以是类，抽象类，接口
   2. Lambda表达式需要的类型必须是接口
2. 抽象方法的数量不一样
   1. 匿名内部类所需的接口中的抽象方法的数量是随意的
   2. Lambda表达式所需的接口中只能有一个抽象方法
3. 实现原理不一样
   1. 匿名内部类狮子啊编译后形成一个class
   2. Lambda表达式实在程序运行的时候动态生成class