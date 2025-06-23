import menu.ArchiveMenu
import models.Archive

class NoteApp {
    private val archives = mutableListOf<Archive>()

    fun run() {
        ArchiveMenu(archives).showMenu()
        println("Вы вышли из приложения. Всего доброго.")
    }
}