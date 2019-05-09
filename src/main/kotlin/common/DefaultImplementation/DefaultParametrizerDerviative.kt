package common.DefaultImplementation

import common.ParamsDerviative

/**
 *  As DefaultParametrizer but includes learning rate constant, this
 *  constant will be multiplied to derviative function will minimization
 */
class DefaultParametrizerDerviative(override var boarderA: Double = 0.0,
                                    override var boarderB: Double = 1.0,
                                    override var EPS: Double = 1e-5,
                                    override var learningRate: Double = 1e-2) : ParamsDerviative