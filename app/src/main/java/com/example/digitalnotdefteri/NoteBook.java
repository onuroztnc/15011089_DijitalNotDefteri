package com.example.digitalnotdefteri;

import java.util.ArrayList;
import java.util.Date;

public class NoteBook {
    private int noteImg;
    private String noteTitle;
    private ArrayList<String> pictures;
    private ArrayList<String> documents;
    private int priority;
    private Date date;

    public ArrayList<String> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }

    public void addPicture(String pict){
        pictures.add(pict);
    }

    public void addDocument(String doc){
        documents.add(doc);
    }

    public ArrayList<String> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<String> documents) {
        this.documents = documents;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NoteBook(int noteImg, String noteTitle) {
        this.noteImg = noteImg;
        this.noteTitle = noteTitle;
    }

    public int getNoteImg() {
        return noteImg;
    }

    public void setNoteImg(int noteImg) {
        this.noteImg = noteImg;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

}
