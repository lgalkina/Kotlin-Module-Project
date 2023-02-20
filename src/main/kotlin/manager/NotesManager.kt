package manager

import data.Archive
import data.Notes

// manager for list of notes
class NotesManager (var notes: MutableList<Notes>) {

    fun addNotes(n: Notes) {
        notes.add(n)
    }

    fun getNotes(index: Int): Notes {
        return notes[index]
    }

    fun findNotesByName(name: String): Notes? {
        notes.forEach{
            if (it.name == name) {
                return it
            }
        }
        return null
    }
}