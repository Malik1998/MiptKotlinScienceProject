package method

import org.junit.Test
import implementation.MethodOfDihotomi;
import implementation.DefaultParams
import org.junit.Assert

class DihotomiTest {

    @Test
    fun SimpleTest() {
        val minimizer = MethodOfDihotomi(
            { x -> 2 * x * x - 1 },
            DefaultParams(0.0, 1.0, 1e-2)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }


    @Test
    fun SimpleTestWithNotNull() {
        val minimizer = MethodOfDihotomi(
            { x -> 2 * x * x - 1 },
            DefaultParams(1.0, 2.0, 1e-2)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult - 1) <= 1e-5)
    }
}
