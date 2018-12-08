import kotlinx.coroutines.*

fun main(args: Array<String>) {
    println("Start")

    val deferred = (1..1_000_000).map { n ->
        GlobalScope.async {
            n
        }
    }




    // Start a coroutine
    GlobalScope.launch {
        println("Hello1")
        delay(1000)
        println("Hello2")
    }


    runBlocking {
        delay(2000)
        println("Hello3")

        val sum = deferred.sumBy { it.await() }
        println("Sum: $sum")
    }

//    Thread.sleep(2000) // wait for 2 seconds
//    println("Stop")
}