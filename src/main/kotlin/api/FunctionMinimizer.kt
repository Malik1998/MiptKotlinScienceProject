package api

interface FunctionMinimizer {


    var function: (Double) -> Double

    fun minimize() : MinimizationResult

}

