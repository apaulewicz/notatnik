package com.example.notatnik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.notatnik.db.AppDatabase;
import com.example.notatnik.db.Note;

public class AddNewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);

        final EditText titleInput = findViewById(R.id.titleInput);
        final EditText textInput = findViewById(R.id.textInput);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                saveNewNote(titleInput.getText().toString(), textInput.getText().toString());
            }
        });

    }


    private void saveNewNote(String titleInput, String textInput){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        Note note = new Note();

        note.noteTitle = titleInput;
        note.noteText = textInput;

        db.noteDao().insertNote(note);

        finish();

    }
}