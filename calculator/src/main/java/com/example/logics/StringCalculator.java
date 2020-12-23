package com.example.logics;

import com.example.logics.Calculator;

import java.util.ArrayList;
import java.util.Stack;

public class StringCalculator implements Calculator {
    private Double value =  0.0d;
    private ArrayList<Double> arrayList = new ArrayList<Double>();
    public void setValue(Double value) {
        this.value = value;
    }
    public ArrayList<Double> getArrayList() {
        return arrayList;
    }
    public void saveValue(){
        if (value != null) arrayList.add(value);
    }

    public Double getValue() {
        return value;
    }

    public void setArrayList(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }
    public String ExpressionToRPN(String Expr) {
        String current = "";
        Stack<Character> stack = new Stack<Character>();

        int priority;
        for (int i = 0; i < Expr.length(); i++) {
            priority = getPriority(Expr.charAt(i));

            if (priority == 0) current += Expr.charAt(i);
            if (priority == 1) stack.push(Expr.charAt(i));
            if (priority > 1) {
                current += ' ';
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) current += stack.pop();
                    else break;
                }
                stack.push(Expr.charAt(i));
            }
            if (priority == -1) {
                current += ' ';
                while (getPriority(stack.peek()) != 1) current += stack.pop();
                stack.pop();
            }
        }
        while (!stack.empty()) current += stack.pop();
        System.out.println(current);
        return current;
    }


    public double RPNtoAnswer(String rpn) {
        String operand = new String();
        Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') continue;
            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length()) break;
                }

                stack.push(Double.parseDouble(operand));
                operand = new String();
            }
            if (getPriority(rpn.charAt(i)) > 1) {
                double a = stack.pop();
                double b = stack.pop();
                if (rpn.charAt(i) == '+') stack.push(b + a);
                if (rpn.charAt(i) == '-') stack.push(b - a);
                if (rpn.charAt(i) == '*') stack.push(b * a);
                if (rpn.charAt(i) == '/') stack.push(b / a);

            }

        }
        //int parseSin = Integer.parseInt (stack.pop());
        //    System.out.println(stack.pop());
        return stack.pop();
        //      = String.valueOf(parseSin = (int) Math.sin(Math.toRadians(parseSin)));
    }

    private static int getPriority(char token) {
        if (token == '*' || token == '/') return 3;
        else if (token == '+' || token == '-') return 2;
        else if (token == '(') return 1;
        else if (token == ')') return -1;
        else return 0;
    }

    @Override
    public String transformText(String text) {
        return text.replaceAll("[a-zA-Z()]", "");
    }

    @Override
    public Double rounding(Double expression) {
        double result = Math.sin(Math.toRadians(expression));
        double scale = Math.pow(10, 2);
        return expression = Math.ceil(result * scale) / scale;
    }
}