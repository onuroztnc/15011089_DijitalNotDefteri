package com.example.digitalnotdefteri;

import android.content.Context;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NoteBook> noteBooks = new ArrayList<>();
    RecyclerView recyclerView;
    PdfDocument pdf;
   File file;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false);

        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new NoteAdapter(noteBooks, context));



    }

    public void init(){

        recyclerView = findViewById(R.id.mainRecyclerView);
        noteBooks.add(new NoteBook(R.mipmap.ic_launcher, "Onur Öztunç"));
        noteBooks.add(new NoteBook(R.mipmap.ic_launcher_round, "Guray Özgödek"));
        noteBooks.add(new NoteBook(R.mipmap.ic_launcher_round, "Oft"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newNote:
                startActivity(new Intent(this, NoteDetail.class));
                return true;



            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        /*
        MenuItem menuItem = menu.findItem(R.id.newNote);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(getApplicationContext(), NoteDetail.class);
                startActivity(intent);
                return true;
            }
        });
        */
        return super.onCreateOptionsMenu(menu);
    }

}
