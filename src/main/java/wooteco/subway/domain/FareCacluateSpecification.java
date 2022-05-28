package wooteco.subway.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import wooteco.subway.util.NullChecker;

public class FareCacluateSpecification {

    private List<Section> sections;
    private Map<Long, Line> lineById;

    public FareCacluateSpecification(List<Section> sections, List<Line> lines) {
        NullChecker.validateNonNull(sections, lines);
        this.sections = sections;
        lineById = lines.stream()
                .collect(Collectors.toMap(Line::getId, it -> it));
    }

    public List<Section> getSections() {
        return sections;
    }

    public Map<Long, Line> lineMapById() {
        return lineById;
    }
}
