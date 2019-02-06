package revision


// Object / Class
/*class User {

    // States
    var firstName: String = ""
    var lastName = ""
    var address = ""
    var height: Double = 0.0


    // Behaviour
    fun canWalk() {}

    fun canEat() {}

    fun canTalk() {}

}*/


// User data class
data class User(
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var height: Double = 0.0
) {

    fun canWalk() {}

    fun canEat() {}

    fun canTalk() {}

}

// Pen data class
data class Pen(var color: Int, var manufacturer: String = "") {

    fun canWrite() {

    }

    fun canDraw() {

    }

}