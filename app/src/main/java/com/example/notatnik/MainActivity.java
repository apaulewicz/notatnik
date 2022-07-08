package com.example.notatnik;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.notatnik.db.AppDatabase;
import com.example.notatnik.db.Note;
import com.example.notatnik.db.NoteDao;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteListAdapter noteListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deleteAllNoteList();

        Button addNewNoteButton = findViewById(R.id.addNewNote);
        addNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, AddNewNoteActivity.class), 100);
            }

        });

        initRecyclerView();
        loadNoteList();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        noteListAdapter = new NoteListAdapter(this);
        recyclerView.setAdapter(noteListAdapter);

    }
    private void loadNoteList(){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Note> noteList = db.noteDao().getAllNotes();
        noteListAdapter.setNoteList(noteList);

    }
    private void deleteAllNoteList(){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        db.noteDao().deleteAllNotes();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadNoteList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}