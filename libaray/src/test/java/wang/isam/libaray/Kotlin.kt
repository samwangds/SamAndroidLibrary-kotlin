package wang.isam.libaray

import org.junit.Test

class Kotlin {
    @Test
    fun testSamName() {
        hello(1)
    }

    fun hello(num: Int) {
        println(num)
        val num = 3
        print(num)

    }
}