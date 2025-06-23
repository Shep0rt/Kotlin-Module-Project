package menu

import models.Archive
import models.Note

class ArchiveMenu(
    private val archives: MutableList<Archive>
) : AbstractMenu<Archive>("Список архивов:") {

    override val items: List<Archive>
        get() = archives

    override fun createNew() {
        println("Введите название архива:")

        val name = readlnOrNull()?.trim()
        if (name.isNullOrEmpty()) {
            println("Название не может быть пустым, попробуйте снова.")
            return
        }

        archives.add(Archive(name))
        println("Архив с названием $name успешно создан.")
    }

    override fun itemSelected(index: Int) {
        val archive = archives[index]
        NoteMenu(archive).showMenu()
    }
}