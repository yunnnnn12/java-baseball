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
    //425, 456이 주어졌을때(given), 이 함수를 실행하면(when) 볼 : 1, 스트라이크 : 1이 나온다(then)
    //비교만 해야함
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

    //숫자가 주어졌을때, 이 함수를 실행하면 '1에서 9'까지 '서로 다른' '수' '3개'여야 한다.
    public List<Integer> makeRandNum(){
        Set<Integer> nums = new HashSet<>();
        while(nums.size() < 3){
            int randNum = Randoms.pickNumberInRange(1,9);
            nums.add(randNum);
        }
        return new ArrayList<>(nums);
    }

    public void run() {
        boolean isGameRunning = true;
        List<Integer> randNum = makeRandNum();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        while (isGameRunning) {

            Number inputNum = new Number(inputView.makeNum().getList());
            // readLine 1


            Result result = compareNum(randNum, inputNum.getList());
            String printResult = outputView.printResult(result);

            System.out.println(printResult);
            System.out.println("컴퓨터:"+ randNum);

            if (printResult.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                // ⭐️ [DEBUG] 3. readLine 호출 직전 메시지 추가
                System.out.println("[DEBUG] run - 재시작/종료 readLine 호출 직전");

                int num = Integer.parseInt(Console.readLine()); // readLine 2

                // ⭐️ [DEBUG] 4. 입력 값을 출력하여 확인
                System.out.println("[DEBUG] run - 재시작/종료 선택 값: " + num);

                if (num == 2) {
                    isGameRunning = false; // 루프 종료
                    // ⭐️ [DEBUG] 5. num=2 선택 후 루프 종료 예정 메시지 추가

                    //System.out.println("[DEBUG] run - isGameRunning=false 설정, 루프 종료 예정");
                    return;

                }
                if(num == 1){
                    randNum = makeRandNum();
                    isGameRunning=true;
                }

                // 새로운 랜덤 숫자를 생성하는 로직이 이 위치에 있어야 합니다. (필요 시 추가)

            }
            else{
                //randNum = makeRandNum();
                isGameRunning = true;
            }
        }
    }

}
