package common.DefaultImplementation

import common.ParamsDerviative

class DefaultParametrizerDerviative(override var boarderA: Double = 0.0,
                                    override var boarderB: Double = 1.0,
                                    override var EPS: Double = 1e-5,
                                    override var learningRate: Double = 1e-2) : ParamsDerviative