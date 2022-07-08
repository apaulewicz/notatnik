package com.example.notatnik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notatnik.db.Note;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.MyViewHolder> {
    private Context context;
    private List<Note> noteList;

    public NoteListAdapter(Context context){
        this.context = context;
    }

    public void setNoteList(List<Note> noteList){
        this.noteList = noteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteListAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(this.noteList.get(position).noteTitle);
        holder.tvText.setText(this.noteList.get(position).noteText);
    }

    @Override
    public int getItemCount() {
        return this.noteList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvText;
        public MyViewHolder(View view){
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvText = view.findViewById(R.id.tvText);
        }
    }
}
