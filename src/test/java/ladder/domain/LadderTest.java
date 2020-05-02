package ladder.domain;

import ladder.view.exception.InvalidLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderTest {
    public static final int COUNT_OF_PERSON_DEFAULT = 5;
    public static final int COUNT_OF_PERSON_DEFAULT_TEST = 2;
    public static final int HEIGHT_DEFAULT = 1;
    public static final Ladder LADDER_PERSON_2 = Ladder.getInstance(Arrays.asList(LineTest.LINE_PERSON2));

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 10})
    @DisplayName("주어진 높이만큼의 사다리를 생성")
    public void generateLadderSuccess(int height) {
        Ladder ladder = Ladder.getInstance(height, COUNT_OF_PERSON_DEFAULT);

        assertThat(ladder.isHeightSame(height)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("유효하지 않은 높이 값이 주어진 경우 exception")
    public void generateLadderThrowException(int height) {
        assertThatExceptionOfType(InvalidLadderHeightException.class)
                .isThrownBy(() -> Ladder.getInstance(height, COUNT_OF_PERSON_DEFAULT));

    }
}
