package screen

import data.Notes
import navigate.Navigation
import navigate.NavigationAction

class NotesScreen (private val notes: Notes): Screen() {

    override var title = "Заметка ${notes.name}:"

    override fun navigate(): NavigationAction {
        user.showText(title)
        user.showText(notes.text)
        return NavigationAction.EXIT
    }

    override fun getNextScreen(): Navigation? {
        return null
    }
}