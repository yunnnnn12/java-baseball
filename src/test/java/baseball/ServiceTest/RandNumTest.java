package baseball.ServiceTest;

import baseball.service.BaseballService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RandNumTest {
    @DisplayName("랜덤 넘버 조건 테스트")
    @Test
    void checkRandomNumberSize(){
        BaseballService baseballService = new BaseballService();
        List<Integer> randNum = baseballService.makeRandNum();

        assertThat(randNum).hasSize(3);
    }
}
