package implementation

import api.FunctionMinimizer
import api.MinimizationResult
import api.Params
import java.lang.Math.abs


/**
 * Approximate function with parabola
 *  get f(x - h), f(x), f(x+h)
 *  built parabola by this 3 points
 *  find minimum of parabola
 *  update x
 *
 */

class ParabolaMethodMinimizer(
    override var function: (Double) -> Double,
    var params: Params = Params.default
) : FunctionMinimizer {

    override fun minimize(): MinimizationResult {


        var xPred = (params.boarderB + params.boarderA) * 0.5
        var xCur = xPred
        val h = params.EPS

        do {

            val temp = xPred - 0.5 * h * (function(xPred + h) - function(xPred + h)) /
                    (function(xPred + h) - 2 * function(xPred) + function(xPred - h))

            xPred = xCur
            if (temp >= params.boarderA && temp <= params.boarderB) {
                xCur = temp
            } else {
                break
            }

        } while (abs(xPred - xCur) > params.EPS * 0.5)

        return MinimizationResult(xCur, function(xCur))

    }
}