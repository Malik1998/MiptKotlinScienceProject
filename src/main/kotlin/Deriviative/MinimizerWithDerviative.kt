package Deriviative

import common.*
import common.DefaultImplementation.DefaultParametrizerDerviative
import common.DefaultImplementation.MinimizationResultsDefault

open class MinimizerWithDerviativeWithBoarders(override var function: (Double) -> Double,
                                               override var deriviative: (Double) -> Double,
                                               override var params: ParamsDerviative = DefaultParametrizerDerviative()
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

        return MinimizationResultsDefault(curX, function(curX))
    }
}

class MinimizerWithDerviativeWithoutBoarders(
    override var deriviative: (Double) -> Double,
    override var function: (Double) -> Double
) : FunctionMinimizerWithDerviativeWithoutBoarders,  MinimizerWithDerviativeWithBoarders(function, deriviative) {

    override fun isIn(x: Double) : Boolean {
        return true
    }

}