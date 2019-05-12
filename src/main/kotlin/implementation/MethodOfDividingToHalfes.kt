package implementation

import api.FunctionMinimizer
import api.MinimizationResult
import api.Params

/**
 * Used if Function Has only one local minimum otherwise, it will
 * not give reasonable answer
 *
 * 
 */

class MethodOfDividingToHalfes(override var function: (Double) -> (Double),
                               var params: Params = DefaultParams()
                                ) : FunctionMinimizer {


    override fun minimize(): MinimizationResult {

        var a = params.boarderA
        var b = params.boarderB
        var curX = (a + b) * 0.5

        do {
            val L = b - a
            val x1 = a + L * 0.25
            var x2 = b - L * 0.25

            if (function(x1) < function(curX)) {
                b = curX
                curX = x1
            } else {
                if (function(x2) < function(curX)) {
                    a = curX
                    curX = x2
                } else {
                    a = x1
                    b = x2
                }
            }

        } while (L > params.EPS)

        return DefaultMinimizationResults(curX, function(curX))

    }
}