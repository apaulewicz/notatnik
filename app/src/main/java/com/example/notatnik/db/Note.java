package com.example.notatnik.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {


    @PrimaryKey(autoGenerate = true)
    public int noteId;

    @ColumnInfo(name = "title")
    public String noteTitle;

    @ColumnInfo(name = "text")
    public String noteText;


}
