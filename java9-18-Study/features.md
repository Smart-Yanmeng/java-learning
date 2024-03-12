# JDK 9

### 1. 模块化

新增 module-info.java 文件来管理 module

### 2. String 底层存储结构升级

将原来的 String 用 char 数组替换成 type 数组  
java 8：
```java
private final char[]value;
```
java 9：
```java
@Stable
private final byte[]value;
private final byte coder; // 如果使用的是 utf-8 字符则 coder 为 0，如果使用的是 utf-16 字符则 coder 为 1
```
优点：提高内存空间的使用率和减少 JVM 垃圾清理的工作量

### 3. 多版本兼容 jar
扩展 JAR 文件格式以允许多个特定于 Java 发行版的类文件在单个存档中共存

### 4. 接口私有方法
+ 私有静态方法
+ 私有方法  
>接口与抽象类的区别是什么呢?
> + 逐渐取代抽象类的功能特性，Java9接口私有方法则进一步代替了抽象类的职责
> + 接口针对于抽象类最大的优势在于多继承

> 那各自使用的时机要如何抉择呢?
> + 如果我们有多重继承的需求，我们应该考虑使用接口实现，如果有大量模板代码可以优先考虑抽象类，毕竟接口在定义参数的时候局限性比较大

### 5. JShell
是一个命令行工具，具有简化交互的功能

### 6. 增强的 try-with-resources
```java
public static void main(String[] args) {
    String s = "A";

    // Java 7 之前
    ByteArrayInputStream stream1 = new ByteArrayInputStream(s.getBytes());

    try {
        System.out.println(stream1.available());
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            stream1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Java 7
//        TestDemo testDemo = new TestDemo();

    try (ByteArrayInputStream stream2 = new ByteArrayInputStream(s.getBytes());
         TestDemo testDemo = new TestDemo()) {
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    // Java 9
    TestDemo testDemo = new TestDemo();

    try(testDemo) {
        testDemo.exec();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
```

### 7. 语法改进
+ 对下划线使用限制
+ 集合增强
```java
// Java 8 - 不可变集合
List<String> list = Collections.unmodifiableList(new ArrayList<>());

// Java 9
List.of("1", "2", "3");
```

### 8. Stream & Optional增强
```java
public static void main(String[] args) {
    List<String> list1 = Stream.of("1", "2", "3").takeWhile("1"::equals).toList();
    System.out.println(list1);

    List<String> list2 = Stream.of("1", "2", "3").dropWhile("1"::equals).toList();
    System.out.println(list2);

    Stream.ofNullable(null).forEach(item -> {
        System.out.println("item" + item);
    });

    test(null);

    // ifPresentOrElse 方法
    Optional.ofNullable(null).ifPresentOrElse(System.out::println, () -> {
        System.out.println("empty list...");
    });

    // or 方法
    System.out.println(Optional.ofNullable(null).or(() -> Optional.of(List.of("4", "5", "6"))));

    // 直接转成流
    System.out.println(Optional.ofNullable("1").stream().toList());
}

public static void test(List<String> list) {
    list = Optional.ofNullable(list).orElse(new ArrayList<>());
    for (String s : list) {
        System.out.println(s);
    }
}
```

# JDK 10

### 1. 局部变量推导
为了省略不必要的局部变量类型的声明
```java
public static void main(String[] args) {
    String s = "1";

    ByteArrayInputStream bytes = new ByteArrayInputStream(s.getBytes());

    var bytesTwo = new ByteArrayInputStream(s.getBytes());

    // 无法使用 var
    Map<String, Map<String, List<String>>> maps = new HashMap<>();

    System.out.println(bytes.available());
    System.out.println(bytesTwo.available());
}
```
该功能并不是一把万能钥匙，我们还需要因地制宜的去使用它，这是一把双刃剑。用的好，可以简化代码，减少复杂度并提高可读性。用错了地方可能会造成反效果

# JDK 11

### 1. 简化启动单个源代码文件的方式
+ 从前的方法
```bash
javac Main.java
java Main
```
+ java 11 以后
```bash
java Main.java
```
但是只能直接运行单个文件，也无法调用外部的类  
同时，当一个文件中有两个 main 方法时，只运行其中的第一个 main 方法
```java
public static void main(String[] args) {
    // 无法调用外部的类
    // Test test = new Test();

    // 可以调用内部的类
    PrintName name = new PrintName();

    System.out.println("Hello world!");
}

static class PrintName {
    public PrintName() {
        System.out.println("My name is ...");
    }

    // 直接运行时只能获取到第一个查找到的 main 方法
    public static void main(String[] args) {
        System.out.println("This is PrintName()'s main");
    }
}
```

并且，Java 11 以后也能通过"shebang"文件和相关技术在脚本中使用（Linux中直接运行）

# JDK 14

### 1. 改进的 NullPointerExceptions
目的是为了通过准确地描述哪个变量为空来提高 JVM 生成的 NullPointerExceptions 的可用性

# JDK 15

### 1. 文字块
为了支持多行字符串文字，避免大多数转义、换行、拼接操作，以可预测的方式自动格式化字符串，并在需要的时候让开发人员控制格式
```java
    String html = """
    @Data
    public class CommonResponse {
        /**
         * 返回业务码用来判断成功失败
         * 200 成功
         * 500 失败
         */
        private String code;
                    
        /** 描述 */
        private String massage;
                    
        /** 描述 */
        private Object date;
                    
        public CommonResponse(String code, String massage, Object date) {
            this.code = code;
            this.massage = massage;
            this.date = date;
        }
                    
        public static CommonResponse succeed(){
            return getCommonResponse(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMassage(), null);
        }
        public static CommonResponse succeed(Object date){
            return getCommonResponse(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMassage(), date);
        }
        public static CommonResponse succeed(String massage,Object date){
            return getCommonResponse(CodeEnum.SUCCESS.getCode(), massage, date);
        }
                    
        public static CommonResponse error(String massage){
            return getCommonResponse(CodeEnum.ERROR.getCode(), massage, null);
        }
        public static CommonResponse error(String code,String massage){
            return getCommonResponse(code, massage, null);
        }
        public static CommonResponse error(){
            return getCommonResponse(CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMassage(), null);
        }
                    
        public static CommonResponse getCommonResponse(String code, String massage, Object date){
            return new CommonResponse(code,massage,date);
        }
    }
    """;
```

# JDK 16

### 1. instanceof 模式匹配
从对象条件中提取组件，可以更加简洁和安全地表达

### 2. 档案类
为了充当不可变数据的透明载体的类，并避免我们去写这些重复的代码，同时拥有不可变的特性可以天然支持我们的高并发操作，因为它是线程安全的
```java
// Java 16 之前
// 不可变的对象
public final class RecordTest1 {
    final String name;

    final Integer age;

    public RecordTest1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "RecordTest1{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordTest1 that = (RecordTest1) o;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```
```java
// Java 16 之后
// Record 类
public record RecordTest2(String name, Integer age) {
    public RecordTest2 {
        System.out.println("My name is " + name);
    }
}
```

### 3. 封闭类
为了解决在可扩展性上实现更细粒度的控制，这种更细粒度的扩展性限制可以防止调用方进行无限扩展，从而造成不可预计的BUG出现，拥有较好的稳定性和安全性
+ Fruit 接口
```java
public sealed interface Fruit permits Apple {
}
```
+ 实现接口方法 1
```java
public final class Banana implements Fruit {
}
```
+ 实现接口方法 2
```java
public non-sealed class Apple implements Fruit {
}
```
+ 嵌套使用
```java
public final class QingApple extends Apple {
}
```
### 4. Switch 表达式
为了解决 switch 语句的一些不规则性称为障碍，比如 case 标签之间的默认控制流行为，case 块中的默认范围，无意义的 break 语句
```java
public static void main(String[] args) {
    int level = new Random().nextInt(4);
    String cnLevel;

    // Java 8
    switch (level) {
        case 1:
            cnLevel = "优秀";
            break;
        case 2:
            cnLevel = "良好";
            break;
        case 3:
            cnLevel = "一般";
            break;
        default:
            cnLevel = "进步空间很大";
            break;
    }
}
```
```java
public static void main(String[] args) {
    var level = new Random().nextInt(4);
    var cnLevel = "";

    // Java 16
    switch (level) {
        case 1 -> cnLevel = "优秀";
        case 2 -> cnLevel = "良好";
        case 3 -> cnLevel = "一般";
        default -> cnLevel = "进步空间很大";
    }

    var cnLevel2 = switch (level) {
        case 1 -> {
            System.out.println("优秀");
            yield "优秀";
        }
        case 2 -> "良好";
        case 3 -> "一般";
        default -> "进步空间很大";
    };
}
```

# JDK 18

### 1. 简单的 Web 服务器
提供命令行工具来启动仅提供静态文件的最小 Web 服务器。没有可用的 CGI 或类似 servlet 的功能。该工具可用于原型设计、临时编码和测试目的，尤其是在教育环境中
```bash
jwebserver
```

# JVM 的升级

1. 统一 JVM 日志
2. 并行全垃圾回收器 G1 取代 CMS 设置为默认垃圾收集器
3. 统一的垃圾回收接口
4. 基于 Java 的实验性 JIT 编译器
5. Epsilon：低开销垃圾回收器
6. 低开销的 Heap Profiling
7. ZGC：可伸缩低延迟垃圾收集器
8. Microbenchmark 测试套件
9. G1 的可中断 mixed GC
10. Shenandoah：低暂停时间垃圾收集器
