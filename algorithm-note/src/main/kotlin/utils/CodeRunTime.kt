package freesme.top.utils

fun runTime(funcName: String, func: () -> Unit) {
    val start = System.nanoTime()
    func()
    println("$funcName run time: ${System.nanoTime() - start} ns")
}
