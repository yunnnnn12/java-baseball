package baseball.ServiceTest;

import baseball.model.Result;
import baseball.service.BaseballService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompareTest {
    @DisplayName("번호 비교 테스트")
    @Test
    void compareNumTest(){
        //given
        BaseballService baseballService = new BaseballService();
        List<Integer> inputNum = Arrays.asList(4,2,5);
        List <Integer> randNum = Arrays.asList(4,5,6);

        //when
        Result result = baseballService.compareNum(randNum, inputNum);

        //then
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);
    }
}
