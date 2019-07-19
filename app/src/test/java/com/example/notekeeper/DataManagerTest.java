package com.example.notekeeper;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {

    @Test
    public void createNewNote() {
        final DataManager dataManager = DataManager.getInstance();
        final CourseInfo course = dataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";
        int noteIndex = dataManager.createNewNote();
        NoteInfo newNote = dataManager.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);
        NoteInfo compareNote = dataManager.getNotes().get(noteIndex);
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteTitle, compareNote.getTitle());
        assertEquals(noteText, compareNote.getText());
    }
    @Test
    public void createNewNoteOneStepCreate(){
        final DataManager dataManager = DataManager.getInstance();
        final CourseInfo course = dataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";

        int noteIndex = dataManager.createNewNote(course, noteTitle, noteText);
        NoteInfo compareNote = dataManager.getNotes().get(noteIndex);
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteTitle, compareNote.getTitle());
        assertEquals(noteText, compareNote.getText());
    }
}