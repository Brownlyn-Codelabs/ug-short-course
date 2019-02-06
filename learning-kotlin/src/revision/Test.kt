package revision

fun main() {

//    val computer = Computer(123, "Dell")
//    computer.color = Computer.COLOR_RED
//    computer.brandName = "Lenovo"
//    println(computer.brandName)

//    val whites = Whites("Green", "Yellow")
//    val blacks = Blacks(skinColor = "Pink")
//
//    blacks.canTalk()
//    println(blacks.skinColor)


    val person= Person("Kwaku")
    println(person.age)
}


class Person constructor(){
    var name:String=""
    var sex : Char = 'm'
    var age: Int= 5

    constructor(name:String):this(){
        this.name = name
    }

    fun canEat(){
      println("am eating")
    }

}


//todo: 1. Create a new class called: Person

//todo: 2. Create two constructors for that class: No-Arg & P. constructor

// todo: 3. Print out one state of that class in the main function


