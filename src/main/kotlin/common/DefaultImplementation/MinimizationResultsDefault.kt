package common.DefaultImplementation

import common.MinimizationResult

class MinimizationResultsDefault(
    override var minPoint: Double,
    override var minResult: Double
) : MinimizationResult {
}