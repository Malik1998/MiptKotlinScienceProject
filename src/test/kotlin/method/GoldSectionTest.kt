package method


import api.Params
import implementation.MethodOfGoldSection
import org.junit.Assert
import org.junit.Test

class GoldSectionTest {

    @Test
    fun SimpleTest() {
        val minimizer = MethodOfGoldSection(
            { x -> 2 * x * x - 1 },
            Params.of(0.0, 1.0, 1e-2)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }


    @Test
    fun SimpleTestWithNotNull() {
        val minimizer = MethodOfGoldSection(
            { x -> 2 * x * x - 1 },
            Params.of(1.0, 2.0, 1e-5)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult - 1) <= 1e-5)
    }
}
