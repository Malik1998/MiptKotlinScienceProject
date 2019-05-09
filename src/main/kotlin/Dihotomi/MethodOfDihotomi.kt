package Dihotomi

import common.*
import common.DefaultImplementation.DefaultParametrizer
import common.DefaultImplementation.MinimizationResultsDefault


/**
 *
 * Dihotomii method of function minimization
 *
 */
class MethodOfDihotomi(override var function: (Double) -> Double,
                       var params: Params = DefaultParametrizer()
) : FunctionMinimizer {
    override fun minimize(): MinimizationResult {

        var a = params.boarderA
        var b = params.boarderB

        do {
            val x0 = (a + b - params.EPS * 0.5) * 0.5
            val x1 = (a + b + params.EPS * 0.5) * 0.5

            if (function(x0) <= function(x1)) {
                b = x1
            } else {
                a = x0
            }
        } while(Math.abs(b - a) > params.EPS)

        return MinimizationResultsDefault(a, function(a))
    }
}