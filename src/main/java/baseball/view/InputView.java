package baseball.view;

import baseball.model.Number;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.validate.InputNumValidator.validate;

public class InputView {
    public Number makeNum(){
        List<Integer> list = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");

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
