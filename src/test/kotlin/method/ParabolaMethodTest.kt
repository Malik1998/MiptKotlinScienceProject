package method


import api.Params
import implementation.ParabolaMethodMinimizer
import org.junit.Assert
import org.junit.Test
import java.lang.Math.PI
import java.lang.Math.cos

class ParabolaMethodTest {

    @Test
    fun SimpleTest() {
        val minimizer = ParabolaMethodMinimizer(
            { x -> 2 * x * x - 1 },
            Params.of(0.0, 1.0, 1e-2)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }


    @Test
    fun SimpleTestWithNotNull() {
        val minimizer = ParabolaMethodMinimizer(
            { x -> cos(x) },
            Params.of(0.5 * PI, 1.5 * PI, 1e-5)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult + 1) <= 1e-5)
    }
}
