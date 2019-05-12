package method


import implementation.MinimizerWithDerivativeWithBoarders
import implementation.MinimizerWithDerivativeWithoutBoarders
import org.junit.Test
import implementation.DefaultParamsDerivative
import org.junit.Assert

class WithDerviativeTest {

    @Test
    fun SimpleTestWithoutBoarders() {
        val minimizer = MinimizerWithDerivativeWithoutBoarders(
            function = { x -> 2 * x * x - 1 }, deriviative = { x -> 4 * x })

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }


    @Test
    fun SimpleTestWithBoarders() {
        val minimizer = MinimizerWithDerivativeWithBoarders(
            function = { x -> 2 * x * x - 1 },
            deriviative = { x -> 4 * x },
            params = DefaultParamsDerivative(-5.0, 5.0)
        )

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }
}
