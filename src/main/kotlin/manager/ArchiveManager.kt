package manager

import data.Archive
import menu.ArchiveMenu

// manager for list of archives
class ArchiveManager {

    var archives: MutableList<Archive> = ArrayList()

    fun createArchive(name: String) {
        archives.add(Archive(name))
    }

    fun getArchive(index: Int): Archive {
        return archives[index]
    }

    fun findArchiveByName(name: String): Archive? {
        archives.forEach{
            if (it.name == name) {
                return it
            }
        }
        return null
    }
}