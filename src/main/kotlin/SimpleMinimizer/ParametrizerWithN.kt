package SimpleMinimizer

import common.Params

class ParametrizerWithN(override var boarderA: Double = 0.0,
                        override var boarderB: Double = 1.0,
                        override var EPS: Double = 1e-5,
                        var N : Int = 100) : Params {
}