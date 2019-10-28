package pl.portfolio.foodforhunger.utils;

import java.util.LinkedList;
import java.util.List;

public class Row<T> {
    List<T> content = new LinkedList<>();

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

}