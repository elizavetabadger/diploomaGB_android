package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAddIncome = findViewById(R.id.btnAddIncome);
        Button btnAddExpense = findViewById(R.id.btnAddExpense);
        Button btnShowBalance = findViewById(R.id.btnShowBalance);

        btnAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddIncomeClick();
            }
        });

       btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddExpenseClick();
            }
        });

        btnShowBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShowBalanceClick();
            }
        });
    }

    private void onAddIncomeClick() {
        EditText incomeEditText = findViewById(R.id.editTextIncome);
        String incomeStr = incomeEditText.getText().toString();


         if (!incomeStr.isEmpty()) {
             try {
                  double incomeAmount = Double.parseDouble(incomeStr);
                  balance = incomeAmount + balance;
                  showToast("Доход добавлен: " + incomeAmount);
         } catch (NumberFormatException e) {
            showToast("Ошибка при внесении суммы дохода");
        }
              } else {
                  showToast("Введите сумму дохода");
              }
    }

   private void onAddExpenseClick() {
        EditText expenseEditText = findViewById(R.id.editTextExpense);
        String expenseStr = expenseEditText.getText().toString();

        if (!expenseStr.isEmpty()) {
            try {
                double expenseAmount = Double.parseDouble(expenseStr);
                balance = - (expenseAmount) + balance;
                showToast("Расход добавлен: " + expenseAmount);
            } catch (NumberFormatException e) {
                showToast("Ошибка при внесении суммы расхода");
            }
        } else {
            showToast("Введите сумму расхода");
        }
    }
    Double balance = 0.00;
    private void onShowBalanceClick() {
        TextView balanceTextView = findViewById(R.id.textViewBalance);
        balanceTextView.setText("Баланс: " + balance);
    }

        private void showToast (String message){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
}