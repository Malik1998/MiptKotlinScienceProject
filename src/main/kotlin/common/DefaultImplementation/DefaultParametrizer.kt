package common.DefaultImplementation

import common.Params


/**
 *
 * Params to minimization function
 *
 * Include left boarder, right boarder, and eps - difference of real x and given answer
 *
 */
open class DefaultParametrizer(override var boarderA: Double = 0.0,
                               override var boarderB: Double = 1.0,
                               override var EPS: Double = 1e-5) : Params {
}