package menu

import manager.ArchiveManager
import manager.NotesManager
import navigate.Navigation

// archive menu representation
class ArchiveMenu() : Menu() {

    override var title = "Список архивов:"
    override var createMenuItemMessage = "Создать архив"

    private val manager: ArchiveManager = ArchiveManager()

    override fun getMenuItems(): List<String> {
        val items: MutableList<String> = ArrayList()
        manager.archives.forEach{
            items.add(it.name)
        }
        return items
    }

    override fun createItem() {
        val name = user.getName()
        val existingArchive = manager.findArchiveByName(name)
        if (existingArchive != null) {
            user.showText("Архив с таким названием уже существует")
            return
        }
        manager.createArchive(name)
    }

    override fun getNextScreen(): Navigation {
        val archive = manager.getArchive(choosenIndex)
        return NotesMenu(archive.name, NotesManager(archive.notes))
    }
}