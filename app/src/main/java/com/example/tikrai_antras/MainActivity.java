package com.example.tikrai_antras;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //deklaruoju elementus
    private EditText textInputEditText;
    private Spinner countTypeSpinner;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //inicijuoju elementus
        textInputEditText = findViewById(R.id.editText_textInput);
        countTypeSpinner = findViewById(R.id.spinner_countType);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.textView_result);

        //Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countTypeSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(v -> calculateResult());
    }

    private void calculateResult() {
        //gauname ir apdorojam teksta
        String input = textInputEditText.getText().toString().trim();

        //tikrina
        if (input.isEmpty()) {
            Toast.makeText(this, getString(R.string.toast_empty_input), Toast.LENGTH_SHORT).show();
            resultTextView.setText(getString(R.string.text_initial_result));
            return;
        }

        //duoda pasirinkti simbolius ar žodžius
        String selectedType = countTypeSpinner.getSelectedItem().toString();
        int count = 0;
        String unit;

        //Skaičiuoja
        if (selectedType.equals("Žodžiai")) {
            count = Until.countWords(input);
            unit = "žodžių";
        } else if (selectedType.equals("Simboliai")) {
            count = Until.countCharacters(input);
            unit = "simbolių";
        } else {
            return;
        }

        //parodo rezultatus
        String resultText = "Rezultatas: " + count + " " + unit;
        resultTextView.setText(resultText);
    }
}