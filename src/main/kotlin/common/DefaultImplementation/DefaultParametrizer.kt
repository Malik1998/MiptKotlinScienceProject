package common.DefaultImplementation

import common.Params

open class DefaultParametrizer(override var boarderA: Double = 0.0,
                               override var boarderB: Double = 1.0,
                               override var EPS: Double = 1e-5) : Params {
}