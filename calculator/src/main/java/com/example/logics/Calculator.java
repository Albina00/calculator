package com.example.logics;


public interface Calculator {
    String ExpressionToRPN(String Expr);


    String transformText(String text);

    Double rounding(Double expression);

}