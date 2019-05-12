package implementation

import api.FunctionMinimizer
import api.MinimizationResult
import api.Params


/**
 *
 * Dihotomii method of function minimization
 *
 */
class MethodOfDihotomi(
    override var function: (Double) -> Double,
    var params: Params = Params.default
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
        } while (Math.abs(b - a) > params.EPS)

        return MinimizationResult(a, function(a))
    }
}