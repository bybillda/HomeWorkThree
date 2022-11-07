package com.example.homeworkthree.ui;

import com.example.homeworkthree.model.Calculator;
import com.example.homeworkthree.model.Operator;

import java.text.DecimalFormat;

public class CalculatorPresenter {private DecimalFormat formater = new DecimalFormat("#.##");

    private CalculatorView view;
    private Calculator calculator;
    //private Calculator calculator;

    private double argOne;

    private Double argTwo;

    private Operator selectedOperator;


    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void OnDigitPressed(int digit) {

        if (selectedOperator == null) {

            argOne = argOne * 10 + digit;

            showFormatted(argOne);
        } else {
            argTwo = argTwo * 10 + digit;

            showFormatted(argTwo);
        }

    }

    public void OnOperatorPressed(Operator operator) {
        if (selectedOperator != null) {

            argOne = calculator.perform(argOne, argTwo, selectedOperator);

            showFormatted(argOne);
        }

        argTwo = 0.0;

        selectedOperator = operator;
    }

    public void onDotPressed() {
    }

    private void showFormatted(double value) {
        view.showResult(formater.format(value));
    }

}
