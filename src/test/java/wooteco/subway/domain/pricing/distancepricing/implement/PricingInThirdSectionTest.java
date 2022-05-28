package wooteco.subway.domain.pricing.distancepricing.implement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import wooteco.subway.domain.Fare;
import wooteco.subway.domain.pricing.distancepricing.PricingBySection;

class PricingInThirdSectionTest {

    @DisplayName("요금을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"8,0", "32,0", "50,0", "58,100", "59,200", "66,200", "67,300"}, delimiter = ',')
    void calculateFee(int distance, int expectFee) {
        PricingBySection strategy = new PricingInThirdSection();
        Fare result = strategy.calculateFare(distance);
        assertThat(result.getValue()).isEqualTo(expectFee);
    }
}
