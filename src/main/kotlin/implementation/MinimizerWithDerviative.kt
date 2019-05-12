package implementation

import api.FunctionMinimizerWithDerivativeWithBoarders
import api.FunctionMinimizerWithDerivativeWithoutBoarders
import api.MinimizationResult
import api.ParamsDerivative

open class MinimizerWithDerivativeWithBoarders(
    override var function: (Double) -> Double,
    override var deriviative: (Double) -> Double,
    override var params: ParamsDerivative = ParamsDerivative()
) : FunctionMinimizerWithDerivativeWithBoarders {

    open fun isIn(x: Double): Boolean {
        return x <= params.boarderB && params.boarderA <= x
    }

    override fun minimize(): MinimizationResult {
        var curX = (params.boarderB - params.boarderA) * 0.5
        var predX = curX

        do {

            predX = curX

            val temp = predX - params.learningRate * deriviative(predX)

            if (isIn(temp)) {
                curX = temp
            } else {
                break
            }

        } while (Math.abs(curX - predX) > params.EPS * 0.5 && isIn(curX))

        return MinimizationResult(curX, function(curX))
    }
}

class MinimizerWithDerivativeWithoutBoarders(
    override var deriviative: (Double) -> Double,
    override var function: (Double) -> Double
) : FunctionMinimizerWithDerivativeWithoutBoarders, MinimizerWithDerivativeWithBoarders(function, deriviative) {

    override fun isIn(x: Double): Boolean {
        return true
    }

}