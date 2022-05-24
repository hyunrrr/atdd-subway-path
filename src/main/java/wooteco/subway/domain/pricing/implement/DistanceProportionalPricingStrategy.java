package wooteco.subway.domain.pricing.implement;

import java.util.List;
import wooteco.subway.domain.FareCacluateSpecification;
import wooteco.subway.domain.Section;
import wooteco.subway.domain.pricing.PricingStrategy;
import wooteco.subway.domain.pricing.distancepricing.PricingBySection;

public class DistanceProportionalPricingStrategy implements PricingStrategy {

    private final List<PricingBySection> pricingBySections;

    public DistanceProportionalPricingStrategy(
            List<PricingBySection> pricingBySections) {
        this.pricingBySections = pricingBySections;
    }

    @Override
    public int calculateFee(FareCacluateSpecification specification) {
        int distance = calculateDistance(specification.getSections());
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
