package com.example.calculatorclonefull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR {

            PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL

    }
    private TextView txtCalculations, txtResult;

    //intsance variables
    private String currentNumber;
    private String stringNumberAtLeft; //5 * //in txt calculation
    private String stringNumberAtRight; //9 //in txt calculation
    private OPERATOR currentOperator;
    private int calculationResult;
    private String calculationsString; //making users see the calculations




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //when app runs
        currentNumber = "";
        calculationResult = 0;

        calculationsString = "";


        txtCalculations = findViewById(R.id.txtCalculations);
        txtResult = findViewById(R.id.txtResult);

        findViewById(R.id.btnEqual).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btnSubtract).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnEqual:

                operatorIsTapped(OPERATOR.EQUAL);

                break;

            case R.id.btn7:
                numberIsTapped(7);
                break;

            case R.id.btn8:
                numberIsTapped(8);
                break;

            case R.id.btn9:
                numberIsTapped(9);
                break;


            case R.id.btnPlus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationsString = calculationsString +  " + ";
                break;

            case R.id.btn4:
                numberIsTapped(4);
                break;

            case R.id.btn5:
                numberIsTapped(5);
                break;

            case R.id.btn6:
                numberIsTapped(6);
                break;

            case R.id.btnSubtract:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationsString = calculationsString +  " - ";
                break;

            case R.id.btn1:
                numberIsTapped(1);
                break;

            case R.id.btn2:
                numberIsTapped(2);
                break;

            case R.id.btn3:
                numberIsTapped(3);
                break;

            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString = calculationsString +  " * ";
                break;

            case R.id.btnClear:
                clearTapped();

                break;

            case R.id.btn0:
                numberIsTapped(0);
                break;

            case R.id.btnDivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString = calculationsString +  " / ";
                break;



        }
        txtCalculations.setText(calculationsString);


    }

    private void numberIsTapped(int tappedNumber) {

        currentNumber = currentNumber + (tappedNumber);
        txtResult.setText(currentNumber);

        calculationsString = currentNumber;
        txtCalculations.setText(calculationsString);

    }

    private void operatorIsTapped(OPERATOR tappedOperator){

        if (currentOperator != null ) {

            if (currentNumber != "") {


                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {


                    case PLUS:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) +
                                Integer.parseInt(stringNumberAtRight);

                        break;

                    case SUBTRACT:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) -
                                Integer.parseInt(stringNumberAtRight);
                        break;

                    case MULTIPLY:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) *
                                Integer.parseInt(stringNumberAtRight);
                        break;

                    case DIVIDE:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) /
                                Integer.parseInt(stringNumberAtRight);
                        break;


                }

                //in txtcalc 5 +
                //           2 +
                //           10
                stringNumberAtLeft = String.valueOf(calculationResult);
                txtResult.setText(stringNumberAtLeft);

                calculationsString = stringNumberAtLeft;

            }
        } else {

            //if we didnt press any operator so current number will be showed only
            stringNumberAtLeft = currentNumber;
            currentNumber = "";

        }
        //every time the user presses on an operator
        currentOperator = tappedOperator;

    }
    private void clearTapped(){

        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculationResult = 0;
        currentNumber = "";
        currentOperator = null;
        txtResult.setText("0");
//        calculationsString = "";
//        txtCalculations.setText("0");
        calculationsString = "0";

    }
}
