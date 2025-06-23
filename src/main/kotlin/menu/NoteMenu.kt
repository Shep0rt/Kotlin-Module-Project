package menu

import models.Archive
import models.Note

class NoteMenu(private val archive: Archive
) : AbstractMenu<Note>("Список заметок из архива: ${archive.name}") {

    override val items: List<Note>
        get() = archive.notes

    override fun createNew() {
        println("Введите имя заметки: ")
        val name = readlnOrNull()?.trim()
        if(name.isNullOrEmpty()) {
            println("Ошибка, имя заметки не может быть пустым, попробуйте снова.")
            return
        }

        println("Отлично! Введите текст заметки:")
        val content = readlnOrNull()?.trim()
        if (content.isNullOrEmpty()) {
            println("Ошибка, текст заметки не может быть пустым, попробуйте снова.")
            return
        }

        archive.notes.add(Note(name, content))
        println("Заметка с именем $name успешно добавлена.")
    }

    override fun itemSelected(index: Int) {
        val note = archive.notes[index]
        println("------------------------------")
        println("Имя заметки:\n${note.name}")
        println("------------------------------")
        println("------------------------------")
        println("Содержимое заметки:\n${note.content}")
        println("------------------------------")
    }
}