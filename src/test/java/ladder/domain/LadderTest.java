package ladder.domain;

import ladder.view.exception.InvalidLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderTest {
    private static final int COUNT_OF_PERSON_DEFAULT = 5;
    private static final int HEIGHT_DEFAULT = 5;
    private static final LadderResult ladderResult = LadderResult.getInstance(new String[] {"꽝","5000","200","꽝","40"});

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 10})
    @DisplayName("주어진 높이만큼의 사다리를 생성")
    public void generateLadderSuccess(int height) {
        Ladder ladder = Ladder.getInstance(height, ladderResult);

        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("유효하지 않은 높이 값이 주어진 경우 exception")
    public void generateLadderThrowException(int height) {
        assertThatExceptionOfType(InvalidLadderHeightException.class)
                .isThrownBy(() -> Ladder.getInstance(height, ladderResult));

    }

    @Test
    @DisplayName("주어진 사다리 결과의 수만큼을 넓이로 가지는 사다리 생성 확인")
    public void generateLadderSuccess() {
        Ladder ladder = Ladder.getInstance(HEIGHT_DEFAULT, ladderResult);

        assertThat(ladder.getLadderResult().getWidth()).isEqualTo(COUNT_OF_PERSON_DEFAULT);
    }
}
