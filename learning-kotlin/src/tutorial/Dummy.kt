package tutorial

fun main() {
    val user1 = User("Kwasi Broni")
    val user2 = User()
    val user3 = User("Dandesey",67)

    println("User1's Name is: ${user1.name}")
    println("User2's Name is: ${user2.name}")
    println("User3's Name is: ${user3.name}")

    user1.doSomething()
}