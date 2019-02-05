package tutorial

data class HumanBeing(
    override var firstName: String,
    var surname: String,
    var age: Int,
    var weight: Double
) : Person {
    override fun canWalk() {
        println("$firstName can walk perfectly fine")
    }

    override fun canEat() {
        println("$firstName has a bad eating habit")
    }

    override fun isAlive(): Boolean {
        return surname.isNotEmpty()
    }
}