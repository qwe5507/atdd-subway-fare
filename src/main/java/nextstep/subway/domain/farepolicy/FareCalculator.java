package nextstep.subway.domain.farepolicy;

import java.util.List;

import nextstep.subway.domain.Path;
import nextstep.subway.domain.farepolicy.base.FarePolicy;
import nextstep.subway.domain.farepolicy.discountcondition.FareDiscountCondition;

public class FareCalculator {
    private final List<FarePolicy> farePolicies;

    public FareCalculator(List<FarePolicy> farePolicies) {
        this.farePolicies = farePolicies;
    }

    public int calculate(Path path, FareDiscountCondition fareDiscountPolicy) {
        int totalCost = farePolicies.stream()
                                    .mapToInt(eachPolicy -> eachPolicy.calculate(path))
                                    .sum();
        return fareDiscountPolicy.discount(totalCost);
    }
}
