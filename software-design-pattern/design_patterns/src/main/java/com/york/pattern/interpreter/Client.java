package com.york.pattern.interpreter;

public class Client {

    public static void main(String[] args) {

        Context context = new Context();

        Variable x = new Variable("x");
        Variable y = new Variable("y");

        context.assign(x, 1);
        context.assign(y, 2);

        AbstractExpression expression = new Plus(new Plus(new Minus(x, y), y), new Plus(x, y));

        System.out.println(expression + " = " + expression.interpret(context));
    }
}
