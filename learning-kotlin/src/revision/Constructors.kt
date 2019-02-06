package revision

data class Computer(var modelNumber: Int, var brandName: String, var color: Int = Computer.COLOR_BLACK) {


    companion object {
        const val COLOR_BLACK = 0
        const val COLOR_RED = 1
        const val COLOR_GREEN = 2
    }

}


interface HumanBeing {
    val hairColor: String
    val skinColor: String

    fun canWalk()
    fun canTalk()
}

data class Whites(
    override val hairColor: String = "Gold",
    override val skinColor: String = "Red"
) : HumanBeing {
    override fun canWalk() {

    }

    override fun canTalk() {

    }
}

data class Blacks(
    override var hairColor: String = "Black",
    override var skinColor: String = "Black"
) : HumanBeing {
    override fun canWalk() {
        println("It's like I can't walk")
    }

    override fun canTalk() {
        println("hah hahahaha ..... I'm talking")
    }

}

