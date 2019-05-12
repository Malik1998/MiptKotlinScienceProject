package implementation

import api.FunctionMinimizerWithDerviativeWithBoarders
import api.FunctionMinimizerWithDerviativeWithoutBoarders
import api.MinimizationResult
import api.ParamsDerviative

open class MinimizerWithDerivativeWithBoarders(override var function: (Double) -> Double,
                                               override var deriviative: (Double) -> Double,
                                               override var params: ParamsDerviative = DefaultParamsDerivative()
) : FunctionMinimizerWithDerviativeWithBoarders {

    open fun isIn(x : Double) : Boolean {
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

        } while (Math.abs(curX - predX) > params.EPS * 0.5  && isIn(curX))

        return DefaultMinimizationResults(curX, function(curX))
    }
}

class MinimizerWithDerivativeWithoutBoarders(
    override var deriviative: (Double) -> Double,
    override var function: (Double) -> Double
) : FunctionMinimizerWithDerviativeWithoutBoarders,  MinimizerWithDerivativeWithBoarders(function, deriviative) {

    override fun isIn(x: Double) : Boolean {
        return true
    }

}