package method


import Prabola.ParabolaMethodMinimizer
import org.junit.Test
import common.DefaultImplementation.DefaultParametrizer
import org.junit.Assert
import java.lang.Math.*

class ParabolaMethodTest {

    @Test
    fun SimpleTest() {
        val minimizer = ParabolaMethodMinimizer({ x -> 2 * x * x - 1 },
            DefaultParametrizer(0.0, 1.0, 1e-2)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }


    @Test
    fun SimpleTestWithNotNull() {
        val minimizer = ParabolaMethodMinimizer({ x -> cos(x) },
            DefaultParametrizer(0.5 * Math.PI, 1.5 * Math.PI, 1e-5)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult + 1) <= 1e-5)
    }
}
