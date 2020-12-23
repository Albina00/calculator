package com.example.logics;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Main {



        public static void main (String[]args){
            SimpleCalculator simpleCalculator = new SimpleCalculator();




            while (true) {
                    int num1 = simpleCalculator.getInt(), num2 = simpleCalculator.getInt();
                    char operation = simpleCalculator.getOperation();
                    double value = simpleCalculator.calc(num1, num2, operation);
                    System.out.println("Результат операции: " + value);
                    value = simpleCalculator.rounding(value);
                    simpleCalculator.setValue(value);
                    simpleCalculator.saveValue();
                    System.out.println("Результат tg в градусах: " + value);
                    System.out.println("Последние резульаты" + simpleCalculator.getArrayList());



            }

    }

}
