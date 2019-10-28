package pl.portfolio.foodforhunger.utils;

import org.springframework.data.domain.Page;

import java.util.LinkedList;
import java.util.List;

//Wrap around standard Spring Page that supports printing results in rows of exact size.
public class PageOfRows<T> {

    private List<Row<T>> content;
    private int number;
    private int totalPages;

    public PageOfRows(Page<T> page, int rowSize) {
        this.number = page.getNumber();
        this.totalPages = page.getTotalPages();
        this.content = new LinkedList<>();

        Row<T> row = new Row<>();
        List<T> pageContent = page.getContent();
        int i = 0;
        for (T elem: pageContent) {
            row.content.add(elem);
            i++;
            if (i % rowSize == 0 || i == pageContent.size()) {
                content.add(row);
                row = new Row<>();
            }
        }
    }

    public List<Row<T>> getContent() {
        return content;
    }

    public void setContent(List<Row<T>> content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
