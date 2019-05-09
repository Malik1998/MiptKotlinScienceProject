package method


import Deriviative.MinimizerWithDerviativeWithBoarders
import Deriviative.MinimizerWithDerviativeWithoutBoarders
import org.junit.Test
import common.DefaultImplementation.DefaultParametrizerDerviative
import org.junit.Assert

class WithDerviativeTest {

    @Test
    fun SimpleTestWithoutBoarders() {
        val minimizer = MinimizerWithDerviativeWithoutBoarders(
            function = { x -> 2 * x * x - 1 }, deriviative = {x -> 4 * x})

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }


    @Test
    fun SimpleTestWithBoarders() {
        val minimizer = MinimizerWithDerviativeWithBoarders(
            function = { x -> 2 * x * x - 1 },
            deriviative = {x -> 4 * x},
            params = DefaultParametrizerDerviative(-5.0, 5.0))

        val results = minimizer.minimize()

        Assert.assertTrue((results.minResult) <= 1e-2)
    }
}
