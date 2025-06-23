package models

data class Note(val name: String, val content: String) {
    override fun toString(): String = name
}