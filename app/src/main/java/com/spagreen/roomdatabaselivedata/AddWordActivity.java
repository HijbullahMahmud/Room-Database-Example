package com.spagreen.roomdatabaselivedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AddWordActivity extends AppCompatActivity {
    private TextInputEditText addWordET;
    private MaterialButton addButton;
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        addWordET = findViewById(R.id.new_word_field);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //add to database
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(addWordET.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = addWordET.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();

            }
        });

    }
}