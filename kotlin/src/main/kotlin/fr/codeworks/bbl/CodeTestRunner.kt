package fr.codeworks.bbl
fun main() {
    val codeTest = Interview()
    codeTest.addCat("SQL")
    codeTest.addCan("firstname", "lastname", "email")
    val score = codeTest.play("Java")
    println("The candidate as a total of $score points.")
}
