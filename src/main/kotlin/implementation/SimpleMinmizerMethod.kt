package implementation

import api.FunctionMinimizer
import api.MinimizationResult
import api.ParamsWithN


/**
 *
 * Just iterate through N points
 */
class SimpleMinmizerMethod(
    override var function: (Double) -> Double,
    var params: ParamsWithN = ParamsWithN()
) : FunctionMinimizer {

    override fun minimize(): MinimizationResult {

        var minX = params.boarderA
        var minVal = function(params.boarderB)

        for (i in 0..params.N) {
            val curX = params.boarderA + i * (params.boarderB - params.boarderA)
            val curVal = function(curX)

            if (curVal < minVal) {
                minX = curX
                minVal = curVal
            }

        }


        return MinimizationResult(minX, minVal)

    }
}