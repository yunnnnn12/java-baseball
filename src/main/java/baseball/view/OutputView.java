package baseball.view;

import baseball.model.Result;

public class OutputView {
    //Result가 주어졌을 때(given), 이 함수를 실행하면(when)
    //프린트만 해라
    public String printResult(Result result){
        String resultStr = "";

        if(result.getBall() != 0){
            resultStr += result.getBall() + "볼 ";
        }
        if(result.getStrike() != 0){
            resultStr += result.getStrike() + "스트라이크";
        }
        if(result.getBall() == 0 && result.getStrike() == 0){
            resultStr = "낫싱";
        }

        return resultStr;
    }

}
