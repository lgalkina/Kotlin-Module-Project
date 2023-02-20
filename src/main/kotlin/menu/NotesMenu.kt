package menu

import data.Notes
import manager.NotesManager
import navigate.Navigation
import screen.NotesScreen
import user.getName

// notes menu representation
class NotesMenu(archiveName: String, private val manager: NotesManager) : Menu() {

    override var title = "Список заметок архива ${archiveName}:"
    override var createMenuItemMessage = "Создать заметку"

    override fun getMenuItems(): List<String> {
        val items: MutableList<String> = ArrayList()
        manager.notes.forEach{
            items.add(it.name)
        }
        return items
    }

    override fun createItem() {
        val name = getName()
        val existingNotes = manager.findNotesByName(name)
        if (existingNotes != null) {
            user.showText("Заметка с таким названием уже существует в архиве")
            return
        }
        val notes = Notes(name)
        notes.text = user.getNotes()
        manager.addNotes(notes)
    }

    override fun getNextScreen(): Navigation {
        return NotesScreen(manager.getNotes(choosenIndex))
    }
}