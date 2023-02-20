package navigate

interface Navigation {
    fun navigate(): NavigationAction
    fun getNextScreen(): Navigation?
}