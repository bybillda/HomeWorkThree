package com.example.homeworkthree.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homeworkthree.R;
import com.example.homeworkthree.model.CalculatorImpl;
import com.example.homeworkthree.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView resultTxt;

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        resultTxt = findViewById(R.id.key_result);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        Map<Integer, Integer> digit = new HashMap<>();
        digit.put(R.id.key_1, 1);
        digit.put(R.id.key_2, 2);
        digit.put(R.id.key_3, 3);
        digit.put(R.id.key_4, 4);
        digit.put(R.id.key_5, 5);
        digit.put(R.id.key_6, 6);
        digit.put(R.id.key_7, 7);
        digit.put(R.id.key_8, 8);
        digit.put(R.id.key_9, 9);
        digit.put(R.id.key_0, 0);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnDigitPressed(digit.get(view.getId()));
            }
        };

        findViewById(R.id.key_1).setOnClickListener(digitClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitClickListener);
        findViewById(R.id.key_0).setOnClickListener(digitClickListener);

        Map<Integer, Operator> operator = new HashMap<>();
        operator.put(R.id.key_plus, Operator.ADD);
        operator.put(R.id.key_minus, Operator.SUB);
        operator.put(R.id.key_divide, Operator.DIV);
        operator.put(R.id.key_multiply, Operator.MULT);

        View.OnClickListener operatorsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnOperatorPressed(operator.get(view.getId()));
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_divide).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_multiply).setOnClickListener(operatorsClickListener);

        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDotPressed();
            }
        });

    }

    @Override
    public void showResult(String result) {
        resultTxt.setText(result);
    }
}