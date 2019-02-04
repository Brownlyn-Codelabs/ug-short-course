package tutorial

/*
   This is a variable which has
   an explicitly declared data type
   Mutable
 */
var name: String = "Dennis Bilson"

/*
    This is a variable which has
    an implicitly declared data type
    Immutable
 */
val username = "Q_Bilson"

var dummy: Any = 9


// Data Types
var b: Boolean = true
var i: Int = 946456464
var d: Double = 954.95
var f: Float = 9.954564555454545454564545454f
var c: Char = 'r'
var l: Long = 954564564564545454L

fun main() {
    // This is a single line comment
    //println(name)

    // We updated the value of the name field
    //name = "Daniel Owusu"

    // A variable is said to be mutable if it starts with: var
    // A variable is said to be immutable if it starts with: val :i.e. the value can not be changed

    // Print out the name variable again
    //println(name)

    // Variable Concatenation
    println("This is a dummy number $dummy")
    println("Char: $c")
    println("Integer: $i")
    println("Long Integer: $l")
    println("Double: $d")
    println("Float: $f")
    println("Boolean: $b")

    dummy = "Dennis Bilson"
}

/*
    Scopes: private, public, protected
 */

class User {
    // No-Arg constructor
    constructor()

    // Parameterized constructor
    constructor(name: String, age: Int = 90) {
        this.name = name
        this.age = age
    }

    var name: String = "Dennis"
    protected var age: Int = 85
    private var weight: Double = 85.56

    fun doSomething() {
        println("Doing something useful...")
    }

}