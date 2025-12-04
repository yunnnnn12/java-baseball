package baseball.service;

import baseball.model.Number;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballService {
    private InputView inputView = new InputView();

    //425, 456이 주어졌을때(given), 이 함수를 실행하면(when) 볼 : 1, 스트라이크 : 1이 나온다(then)
    public Result compareNum(List<Integer> randNum, List <Integer> inputNum){
        int ball =0;
        int strike = 0;
        for(int i = 0; i < 3; i++){
            if(randNum.get(i) == inputNum.get(i)){
                strike++;
            }
            else{
                for(int j = 0; j < 3; j++){
                    if(randNum.get(i) == inputNum.get(j)){
                        ball++;
                    }
                }
            }
        }
        Result result = new Result(ball, strike);

        return result;
    }

    ///숫자가 주어졌을때, 이 함수를 실행하면 1에서 9까지 서로 다른 임의의 수 3개여야 한다.
    public List<Integer> makeRandNum(){
        Set<Integer> nums = new HashSet<>();
        int i = 0;
        while(i <= 2){
            int randNum = Randoms.pickNumberInRange(1,9);
            nums.add(randNum);
            i++;
        }
        //Number number = new Number(nums);

        return new ArrayList<>(nums);
    }

    //
    public void run() {
        boolean isGameRunning = true;
        List<Integer> randNum = makeRandNum();

        while (isGameRunning) {
            OutputView outputView = new OutputView();
            Number inputNum = inputView.makeNum();  // readLine 1


            Result result = compareNum(randNum, inputNum.getList());
            String printResult = outputView.printResult(result);

            //System.out.println(printResult);

            if (printResult.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int num = Integer.parseInt(Console.readLine()); // readLine 2
                if (num == 2) {
                    isGameRunning = false; // 루프 종료
                }
                // num == 1이면 루프 반복
            }
            else{
                isGameRunning = true;
            }
        }
    }

}
