package baseball.view;

import baseball.model.Number;
import baseball.validate.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.validate.InputValidator.validate;

public class InputView {

    public Number makeNum(){ // 123이 주어졌을때 이 함수를 실행하면 각각의 값들이 1-9사이의 범위여야 하고, 서로 다른 숫자여야한다.
        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> list = new ArrayList<>();
        String input = Console.readLine();

        validate(input);

        String[] splitNum = input.split("");
        for(int i = 0; i < splitNum.length; i++){
            list.add(Integer.parseInt(splitNum[i]));
        }

        Number number = new Number(list);

        return number;
    }
}
