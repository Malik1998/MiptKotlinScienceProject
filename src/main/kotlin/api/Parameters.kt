package api


data class MinimizationResult(val minPoint: Double, val minResult: Double)

interface Params {
    val boarderA: Double
    val boarderB: Double
    val EPS: Double

    companion object {
        fun of(boarderA: Double = 0.0, boarderB: Double = 1.0, EPS: Double = 1e-5): Params =
            ParamsImpl(boarderA, boarderB, EPS)

        val default = of()
    }
}

/**
 *
 * Params to minimization function
 *
 * Include left boarder, right boarder, and eps - difference of real x and given answer
 *
 */
private class ParamsImpl(
    override var boarderA: Double = 0.0,
    override var boarderB: Double = 1.0,
    override var EPS: Double = 1e-5
) : Params


/**
 *  As instance of [Params] that includes learning rate constant, this
 *  constant will be multiplied to derviative function will minimization
 */
data class ParamsDerivative(
    override val boarderA: Double = 0.0,
    override val boarderB: Double = 1.0,
    override val EPS: Double = 1e-5,
    val learningRate: Double = 1e-2
) : Params

/**
 *  As ParamsImpl but includes count of
 *  parts to divide boarders
 */
data class ParamsWithN(
    override val boarderA: Double = 0.0,
    override val boarderB: Double = 1.0,
    override val EPS: Double = 1e-5,
    val N: Int = 100
) : Params