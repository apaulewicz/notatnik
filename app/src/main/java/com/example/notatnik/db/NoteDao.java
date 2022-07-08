package com.example.notatnik.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note")
    List<Note> getAllNotes();

    @Query("DELETE FROM note")
    void deleteAllNotes();

    @Insert
    void insertNote(Note... notes);

    @Delete
    void delete(Note note);




}
