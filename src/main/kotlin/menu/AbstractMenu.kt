package menu

abstract class AbstractMenu<T>(private val title: String) {
    protected abstract val items: List<T>
    protected abstract fun itemSelected(index: Int)
    protected abstract fun createNew()

    fun showMenu() {
        while(true) {
            println("\n$title")
            println("0. Создать")
            items.forEachIndexed { index, item -> println("${index + 1}. $item") }
            println("${items.size + 1}. Выход")
            println("Выберите пункт меню, указав нужную цифру:")
            val inputUser = readlnOrNull()
            val choiceUser = inputUser?.toIntOrNull()

            if (choiceUser == null) {
                println("Ошибка, введите число из представленных в списке.")
                continue
            }

            when (choiceUser) {
                0 -> createNew()
                in 1..items.size -> itemSelected(choiceUser - 1)
                items.size + 1 -> return
                else -> println("Ошибка, такой пункт отсутствует, попробуйте снова.")
            }
        }
    }

}