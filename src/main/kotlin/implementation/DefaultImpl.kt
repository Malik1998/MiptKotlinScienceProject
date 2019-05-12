package implementation

import api.MinimizationResult
import api.Params
import api.ParamsDerviative
import api.ParamsWithN


/**
 *
 * Params to minimization function
 *
 * Include left boarder, right boarder, and eps - difference of real x and given answer
 *
 */
open class DefaultParams(override var boarderA: Double = 0.0,
                         override var boarderB: Double = 1.0,
                         override var EPS: Double = 1e-5) : Params



/**
 *  As DefaultParams but includes learning rate constant, this
 *  constant will be multiplied to derviative function will minimization
 */
class DefaultParamsDerivative(override var boarderA: Double = 0.0,
                              override var boarderB: Double = 1.0,
                              override var EPS: Double = 1e-5,
                              override var learningRate: Double = 1e-2) : ParamsDerviative


/**
 *  As DefaultParams but includes count of
 *  parts to divide boarders
 */
class DefaultParamsWithN(override var boarderA: Double = 0.0,
                         override var boarderB: Double = 1.0,
                         override var EPS: Double = 1e-5,
                         override var N : Int = 100) : ParamsWithN


class DefaultMinimizationResults(
    override var minPoint: Double,
    override var minResult: Double
) : MinimizationResult