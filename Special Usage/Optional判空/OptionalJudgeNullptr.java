import java.util.Optional;

public class OptionalJudgeNullptr {

  public static void main(String[] args) {

    Person person1 = new Person();
    Person person2 = new Person();
    person1 = null;

    // 传统判空
    if (null == person1) {

      System.out.println("person 为 null");
    } else {

      System.out.println(123);
    }

    // Optional 判空
    // 空则输出 false
    System.out.println(Optional.ofNullable(person1).isPresent());

    person2.setAge(18);
    person2.setName("York");

    // 获取对象的值
    // 若为空则抛出异常
    System.out.println(Optional.ofNullable(person2).get());
  }
}

class Person {

  Integer age;

  String name;

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}