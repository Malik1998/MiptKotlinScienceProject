package method

import org.junit.Test
import Dihotomi.MethodOfDihotomi;
import common.DefaultImplementation.DefaultParametrizer
import org.junit.Assert

class DihotomiTest {

    @Test
    fun SimpleTest() {
        val minimizer = MethodOfDihotomi({ x -> 2 * x * x - 1 },
            DefaultParametrizer(0.0, 1.0, 1e-2)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }


    @Test
    fun SimpleTestWithNotNull() {
        val minimizer = MethodOfDihotomi({ x -> 2 * x * x - 1 },
            DefaultParametrizer(1.0, 2.0, 1e-2)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult - 1) <= 1e-5)
    }
}
