package menu

import navigate.NavigationAction

// menu item representation
data class MenuItem(val index: Int, val text: String, val process: () -> NavigationAction)
