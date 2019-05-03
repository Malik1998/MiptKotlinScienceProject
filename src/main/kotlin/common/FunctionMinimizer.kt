package common

interface FunctionMinimizer {


    var function: (Double) -> Double

    fun minimize() : MinimizationResult

}

