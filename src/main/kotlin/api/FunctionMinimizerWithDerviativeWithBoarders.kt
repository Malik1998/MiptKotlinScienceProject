package api

interface FunctionMinimizerWithDerviativeWithBoarders : FunctionMinimizerWithDerviativeWithoutBoarders {
    var params: ParamsDerviative
}