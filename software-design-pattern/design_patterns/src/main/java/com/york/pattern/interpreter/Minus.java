package com.york.pattern.interpreter;

public class Minus extends AbstractExpression {

    private final AbstractExpression left;

    private final AbstractExpression right;

    public Minus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }

    @Override
    public String toString() {
        return "Minus{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
