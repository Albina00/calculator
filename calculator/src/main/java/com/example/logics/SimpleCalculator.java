package com.example.logics;

import com.example.logics.Calculator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;
public class SimpleCalculator implements Calculator {
    static Scanner scanner = new Scanner(System.in);

    private Double value = 0.0d;
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

    public static int getInt() {
        System.out.println("Введите значение:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе значения. Попробуйте еще раз.");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе значения. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }


    @Override
    public String ExpressionToRPN(String Expr) {
        return null;
    }


    @Override
    public String transformText(String text) {
        return text.replaceAll("[a-zA-Z()]", "");
    }

    @Override
    public Double rounding(Double expression) {
        double result = Math.tan(Math.toRadians(expression));
        double scale = Math.pow(10, 2);
        return expression = Math.ceil(result * scale) / scale;
    }

}