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

class MethodOfGoldSection(
    override var function: (Double) -> Double,
    var params: Params = Params.default
) : FunctionMinimizer {

    override fun minimize(): MinimizationResult {

        var a = params.boarderA
        var b = params.boarderB
        val tau = 0.618

        var lam = 0.0
        var qui = 0.0


        do {

            lam = a + (1 - tau) * (b - a)

            qui = a + tau * (b - a)

            if (function(lam) > function(qui)) {
                a = lam
                lam = tau
            } else {
                b = qui
                qui = lam

            }

        } while ((b - a) > params.EPS)

        return MinimizationResult(a, function(a))

    }
}