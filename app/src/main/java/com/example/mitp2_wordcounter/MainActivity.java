package com.example.mitp2_wordcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerOptions;
    private Button btnCount;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        spinnerOptions = findViewById(R.id.spinnerOptions);
        btnCount = findViewById(R.id.btnCount);
        textViewResult = findViewById(R.id.textViewResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInput.getText().toString();
                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Įveskite tekstą!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String selectedOption = spinnerOptions.getSelectedItem().toString();

                int result;
                if (selectedOption.equals("Zodziai")) {
                    result = WordCounter.getWordsCount(inputText);
                } else if (selectedOption.equals("Rasybos Zenklai")) {
                    result = WordCounter.getPunctuationCount(inputText);
                } else {
                    result = 0;
                }

                textViewResult.setText("Rezultatas: " + result);
            }
        });
    }
}
