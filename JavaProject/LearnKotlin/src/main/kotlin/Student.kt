class Student(name: String, age: Int) : Person(), Study {
    override fun readBooks() {
        println("$name is reading")
    }

    override fun doHomework() {
        println("$name is doing homework")
    }

}