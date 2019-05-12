package api

interface FunctionMinimizer {
    var function: (Double) -> Double
    fun minimize(): MinimizationResult
}


interface FunctionMinimizerWithDerivativeWithBoarders : FunctionMinimizerWithDerivativeWithoutBoarders {
    var params: ParamsDerivative
}

interface FunctionMinimizerWithDerivativeWithoutBoarders : FunctionMinimizer {
    var deriviative: (Double) -> Double
}

