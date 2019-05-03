import common.*

class SimpleMethod(override var function: (Double) -> Double,
                   var params: Params = DefaultParametrizer()
) : FunctionMinimizer {

    override fun minimize(): MinimizationResult {

        var a = params.boarderA
        var b = params.boarderB

       // for ()


        return MinimizationResultsDefault(a, function(a))

    }
}