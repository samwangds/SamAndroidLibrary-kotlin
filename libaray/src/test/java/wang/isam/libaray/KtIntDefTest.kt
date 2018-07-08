package wang.isam.libaray

import android.support.annotation.IntDef
import junit.framework.Assert
import org.junit.Test

class KtIntDefTest {
    companion object {

        @IntDef(SLOW, NORMAL, FAST)
        @Retention(AnnotationRetention.SOURCE)
        annotation class Speed

        const val SLOW = 0
        const val NORMAL = 1
        const val FAST = 2
    }

    @Speed
    private var speed: Int=SLOW

    public fun setSpeed(@Speed speed: Int) {
        this.speed = speed
    }

    @Test
    fun test() {
        val test = KtIntDefTest()
        test.setSpeed(3)
        Assert.assertEquals(3, test.speed)

    }
}