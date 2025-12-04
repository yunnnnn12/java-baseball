package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private List<Integer> list = new ArrayList<>();

    public Number(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

}
