package data

// archive representation
data class Archive (val name: String) {
    var notes: MutableList<Notes> = ArrayList()
}