package SimpleMinimizer

import common.*
import common.DefaultImplementation.MinimizationResultsDefault
import common.DefaultImplementation.DefaultParametrizerWithN


/**
 *
 * Just iterate through N points
 */
class SimpleMinmizerMethod(override var function: (Double) -> Double,
                           var params: ParamsWithN = DefaultParametrizerWithN()
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


        return MinimizationResultsDefault(minX, minVal)

    }
}