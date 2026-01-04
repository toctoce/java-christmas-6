package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.common.ChristmasException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefaultTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void 테스트이름() {
        assertThat(true).isEqualTo(true);
        assertThatThrownBy(() -> {
        }).isInstanceOf(ChristmasException.class);
    }
}
