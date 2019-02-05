package tutorial

data class Student(var name: String, var id: Int = 0) {

    // No-Argument constructor
    constructor() : this("", 0)

}