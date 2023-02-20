package menu

import navigate.Navigation
import navigate.NavigationAction
import screen.Screen
import java.util.*

// basic menu representation and functionality
abstract class Menu : Screen() {

    var choosenIndex: Int = -1
    private var menuItems: MutableList<MenuItem> = ArrayList()

    abstract var createMenuItemMessage : String
    abstract fun getMenuItems(): List<String>
    abstract fun createItem()

    override fun navigate(): NavigationAction {
        this.buildMenuItems()
        this.showMenu()
        val index = user.getItem(menuItems.size)
        if (index == -1) {
            return NavigationAction.CONTINUE
        }
        choosenIndex = index-1
        return menuItems[index].process()
    }

    // create menu items list
    private fun buildMenuItems() {
        var index = 0
        this.menuItems.clear()
        menuItems.add(MenuItem(index++, createMenuItemMessage, ::processCreateItem))
        for (it in this.getMenuItems()) {
            menuItems.add(MenuItem(index++, it, ::processOpenItem))
        }
        menuItems.add(MenuItem(index, "Выход", ::processExitItem))
    }

    // print menu items
    private fun showMenu() {
        println("\n" + title)
        menuItems.forEach{
            println("${it.index}. ${it.text}")
        }
    }

    private fun processCreateItem(): NavigationAction {
        this.createItem()
        return NavigationAction.CONTINUE
    }

    private fun processExitItem(): NavigationAction {
        return NavigationAction.EXIT
    }

    private fun processOpenItem(): NavigationAction {
        return NavigationAction.OPEN
    }
}