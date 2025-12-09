package baseball.validate;

public class InputNumValidator {
    public static void validate(String nums){
        validateLength(nums);
        ifDuplite(nums);
        validateNumericAndRange(nums);
    }

    public static void validateLength(String nums){
        if(nums.length() != 3){
            throw new IllegalArgumentException("3자리 숫자여야 합니다.");
        }
    }

    public static void ifDuplite(String nums){
        if(nums.length() != nums.chars().distinct().count()){
            throw new IllegalArgumentException("값들은 중복되지 않아야 합니다.");
        }
    }

    public static void validateNumericAndRange(String nums){
        if(!nums.matches("[1-9]+")){
            throw new IllegalArgumentException("1~9범위의 숫자여야 합니다.");
        }
    }
}
