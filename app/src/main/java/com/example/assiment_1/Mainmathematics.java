package com.example.assiment_1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Mainmathematics extends AppCompatActivity {

    private EditText editTextItem;
    private TextView textView;
    private Button addButton, deleteButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.mainmathematics);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        editTextItem = findViewById(R.id.editTextItem);
        textView = findViewById(R.id.textView);
        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);


        sharedPreferences = getSharedPreferences("com.example.assiment_1.preferences", MODE_PRIVATE);


        loadText();


        addButton.setOnClickListener(view -> {
            String inputText = editTextItem.getText().toString();
            if (!inputText.isEmpty()) {
                String currentText = textView.getText().toString();
                String newText = currentText.isEmpty() ? inputText : currentText + "\n" + inputText;
                updateTextView(newText);
                saveText(newText);
                editTextItem.setText("");
            }
        });


        deleteButton.setOnClickListener(view -> {
            String inputText = editTextItem.getText().toString();
            if (!inputText.isEmpty()) {
                String currentText = textView.getText().toString();
                String newText = deleteWord(currentText, inputText);
                updateTextView(newText);
                saveText(newText);
            }
        });



    }

    private String deleteWord(String currentText, String wordToDelete) {

        String[] lines = currentText.split("\n");
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {

            if (!line.contains(wordToDelete)) {
                builder.append(line).append("\n");
            }
        }
        return builder.toString().trim(); // Remove the last newline character
    }

    private void updateTextView(String text) {
        textView.setText(text);
    }

    private void saveText(String text) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("storedText", text);
        editor.apply();
    }

    private void loadText() {
        String storedText = sharedPreferences.getString("storedText", "");
        textView.setText(storedText);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveText(textView.getText().toString());
    }
}
