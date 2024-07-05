package com.york.springboot;

import component.TestComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringbootSpringApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SpringbootSpringApplication.class, args);
//
//        TestComponent testComponent = context.getBean("testComponent", TestComponent.class);
//        testComponent.Test();

        Scanner scanner = new Scanner(System.in);

        System.out.println("欢迎使用简单计算器，请输入第一个数字：");
        double num1 = scanner.nextDouble();

        System.out.println("请输入操作符（+、-、*、/）：");
        char operator = scanner.next().charAt(0);

        System.out.println("请输入第二个数字：");
        double num2 = scanner.nextDouble();

        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("结果：" + num1 + " + " + num2 + " = " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("结果：" + num1 + " - " + num2 + " = " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("结果：" + num1 + " * " + num2 + " = " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("错误：除数不能为0");
                } else {
                    result = num1 / num2;
                    System.out.println("结果：" + num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("错误：无效的操作符");
                break;
        }

        scanner.close();
    }


}
