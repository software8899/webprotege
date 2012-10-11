package edu.stanford.bmir.protege.web.server.owlapi.notes.api;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 28/08/2012
 */
public interface MutableNoteStore extends NoteStore {

    void addNote(Note note) throws NoteStoreException;

    void removeNote(NoteId note) throws NoteStoreException;
}
