package tutorial

// Creating comments

// Single line comment

/*
    Multi-line comment
 */

// Creating a variable using 'var' makes it mutable:
// Meaning the value of that variable can be changed
// within the context of the class or scope

var number: Int = 8
var anotherNumber = 9
var someType: Any = 7

// Creating a variable using 'val' makes it immutable:
// Meaning the value of that variable cannot be changed
val someValue: Int = 345


fun main(args: Array<String>) {
//    println(someType)
//    someType = "Dennis Bilson"
//    println(someType)

//    doSomething()

    // Expecting: 64
//    println(anotherNumber.square())

//    println(number.sum(anotherNumber))

//    println("7890".toInt())

//    val daniel = HumanBeing("Daniel", "Brown", 20, 50.8)

    val student1 = Student("Dennis")
    val student2 = Student("Daniel", 120545878)

    println(student1.id)
    println(student2.id)

}

/*
    Extension functions
 */
fun Int.square(): Int = this.times(this)

fun Int.sum(newNumber: Int): Int = this.plus(newNumber)

fun Int.fromString(valueInString: String): Int = Integer.parseInt(valueInString)

fun doSomething() = println("Hello Kotlin")

/*
    This function accepts a number and returns its square
 */
fun squareOfNumber(x: Int): Int = x.times(x)




