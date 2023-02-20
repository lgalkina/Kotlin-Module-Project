package navigate

import menu.ArchiveMenu

// navigation controller for the app
class AppNavigationController {

    private var navigators : MutableList<Navigation> = mutableListOf(ArchiveMenu())

    fun navigate() {
        while (true) {
            val currentNavigator = getCurrentNavigator()
            when (currentNavigator.navigate()) {
                NavigationAction.OPEN -> {
                    val next = currentNavigator.getNextScreen()
                    if (next != null) {
                        navigators.add(next)
                    }
                }
                NavigationAction.CONTINUE -> {}
                NavigationAction.EXIT -> {
                    if (removeNavigator()) {
                        continue
                    }
                   break
                }
            }
        }
    }

    private fun getCurrentNavigator(): Navigation {
        return navigators[navigators.size-1]
    }

    private fun removeNavigator(): Boolean {
        if (navigators.size > 1) {
            navigators.removeAt(navigators.size-1)
            return true
        }
        return false
    }
}