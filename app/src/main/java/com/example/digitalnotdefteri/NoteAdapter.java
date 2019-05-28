package com.example.digitalnotdefteri;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    ArrayList<NoteBook> noteBooks = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;

    public NoteAdapter(ArrayList<NoteBook> noteBooks, Context context) {
        this.noteBooks = noteBooks;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.note_row, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.noteTitle.setText(noteBooks.get(i).getNoteTitle());
        viewHolder.noteImg.setImageResource(noteBooks.get(i).getNoteImg());
        viewHolder.noteRowLayout.setTag(viewHolder);
        viewHolder.noteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NoteDetail.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteBooks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView noteTitle;
        ImageView noteImg;
        LinearLayout noteRowLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.noteTitle);
            noteImg = itemView.findViewById(R.id.noteImage);
            noteRowLayout = itemView.findViewById(R.id.noteRowId);

        }
    }


}
