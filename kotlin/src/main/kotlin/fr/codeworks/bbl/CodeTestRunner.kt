package fr.codeworks.bbl
fun main() {
    val codeTest = Interview()
    codeTest.addCat("SQL")
    codeTest.addCan("firstname", "lastname", "email")
    val score = codeTest.run("Java")
    println("The candidate as a total of $score points.")
}
