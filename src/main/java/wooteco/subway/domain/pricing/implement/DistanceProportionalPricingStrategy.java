package wooteco.subway.domain.pricing.implement;

import java.util.List;
import wooteco.subway.domain.Section;
import wooteco.subway.domain.pricing.PricingStrategy;
import wooteco.subway.domain.pricing.distancepricing.PricingBySection;

public class DistanceProportionalPricingStrategy implements PricingStrategy {

    private static final DistanceProportionalPricingStrategy strategy = new DistanceProportionalPricingStrategy();

    private DistanceProportionalPricingStrategy() {}

    public static DistanceProportionalPricingStrategy of() {
        return strategy;
    }

    @Override
    public int calculateFee(List<Section> sections) {
        int distance = calculateDistance(sections);
        List<PricingBySection> pricingBySections = PricingBySection.getAllStrategies();
        return pricingBySections.stream()
                .mapToInt(it -> it.calculateFee(distance))
                .sum();
    }

    private int calculateDistance(List<Section> sections) {
        return sections.stream()
                .map(Section::getDistance)
                .reduce(0, Integer::sum);
    }
}
