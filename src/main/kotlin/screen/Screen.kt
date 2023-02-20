package screen

import navigate.Navigation

// basic screen representation
abstract class Screen : Navigation {
    abstract var title : String
}