package api


interface MinimizationResult {
    var minPoint: Double
    var minResult: Double
}

interface Params {

    var boarderA : Double
    var boarderB : Double
    var EPS  : Double
}

interface ParamsDerivative : Params {

    val learningRate : Double
}

interface ParamsWithN : Params {

    val N : Int
}