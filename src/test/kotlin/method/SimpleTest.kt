package method


import api.ParamsWithN
import implementation.SimpleMinmizerMethod
import org.junit.Assert
import org.junit.Test

class SimpleTest {

    @Test
    fun SimpleTest() {
        val minimizer = SimpleMinmizerMethod(
            { x -> 2 * x * x - 1 },
            ParamsWithN(0.0, 1.0, 1e-2, 1000)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }


    @Test
    fun SimpleTestWithNotNull() {
        val minimizer = SimpleMinmizerMethod(
            { x -> 2 * x * x - 1 },
            ParamsWithN(1.0, 2.0, 1e-5, 100)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult - 1) <= 1e-5)
    }
}
