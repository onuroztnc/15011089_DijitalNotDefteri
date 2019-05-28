package com.example.digitalnotdefteri;

import android.content.Context;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfRenderer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.util.*;
import android.widget.Toast;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsProvider;
import android.provider.*;
import android.content.ContentUris;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.database.Cursor;
import android.os.Environment;
import android.net.Uri;
import android.util.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.Util;

import java.io.File;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class NoteDetail extends AppCompatActivity {
    Button button;
    PDFView pdfview;
    AutoCompleteTextView textNote;
    TextView txt;
    Date date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        //button = (Button)findViewById(R.id.button) ;
        //pdfview = (PDFView)findViewById(R.id.pdfViewId);
        //txt = (TextView) findViewById(R.id.txtView);
        date = Calendar.getInstance().getTime();
        textNote = (AutoCompleteTextView) findViewById(R.id.note);

    }



    void clickButn(View v){
        Intent intent;
        intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, 7);
        PdfDocument abc;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        switch(requestCode){

            case 7:

                if(resultCode==RESULT_OK){

                    File file = new File(data.getData().getPath());
                    Uri temp_u;
                    String temp;
                    temp = data.getData().toString();
                    temp_u = Uri.parse(temp);
                    //viewPdf(temp_u);
                    InputStream fileInputStream;
                    /*
                    try  {

                        fileInputStream = getContentResolver().openInputStream(data.getData());
                        //viewPdf(fileInputStream);

                        txt.setVisibility(View.VISIBLE);
                        BufferedReader r = new BufferedReader(new InputStreamReader(fileInputStream));
                        StringBuilder total = new StringBuilder();
                        for (String line; (line = r.readLine()) != null; ) {
                            total.append(line).append('\n');
                        }
                        String result = total.toString();

                        txt.setText(result);

                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    */
                    Bitmap bitmap;
                    ImageView picture = (ImageView)findViewById(R.id.pict);
                    picture.setVisibility(View.VISIBLE);
                    Uri selectedImage = data.getData();

                    try {
                        bitmap = (Bitmap) MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                        picture.setImageBitmap(bitmap);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }



                }
                break;

        }
    }

    void viewPdf(InputStream uri){
        try{

            pdfview.setVisibility(View.VISIBLE);
            pdfview.fromStream(uri)
                    .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                    .enableSwipe(true) // allows to block changing pages using swipe
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                    .password(null)
                    .scrollHandle(null)
                    .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                    // spacing between pages in dp. To define spacing color, set view background
                    .spacing(0)
                    .autoSpacing(false)
                    .pageFitPolicy(FitPolicy.WIDTH)
                    .pageSnap(true) // snap pages to screen boundaries
                    .pageFling(false) // make a fling change only a single page like ViewPager
                    .nightMode(false) // toggle night mode
                    .load();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }




}
