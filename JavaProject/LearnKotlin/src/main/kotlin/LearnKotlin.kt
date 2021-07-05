fun main() {

//    val student = Student("Jack", 80)
//    doStudy(student)


    val cellphone1 = Cellphone("xiaomi", 1999.0)
    val cellphone2 = Cellphone("huawei", 12999.0)
    println(cellphone1)
    println("cellphone1 equal cellphone2 " + (cellphone1 == cellphone2))


    val list = mutableListOf("Apple", "xiaomi", "huawei", "OPPO", "ViVO")
    list.add("samsung")
    for (phone in list) {
        println(phone)
    }

    println("-----------------")

    val map = HashMap<String, Int>()
    map["Apple"] = 1
    map["Huawei"] = 2
    map["Xiaomi"] = 3
    map["OPPO"] = 4
    map["ViVO"] = 5

    for ((phone, number) in map) {
        println("$phone is $number")
    }

}

fun doStudy(study: Study) {
    study.readBooks()
    study.doHomework()
}


fun add(a: Int, b: Int): Int {
    return a + b
}

fun getScore(name: String) = when (name) {
    "Tom" -> 80
    "Song" -> 90
    "Jack" -> 67
    else -> 0
}