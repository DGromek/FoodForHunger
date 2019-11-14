package pl.portfolio.foodforhunger.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class CommentDTO {

    @NotEmpty(message = "Nie może być puste!")
    private String content;

    @NotEmpty()
    private String receiverUsername;

    @Min(value = 1, message = "Ocena nie może być mniejsza niż 1!")
    @Max(value = 5, message = "Ocena nie może być większa niż 5!")
    private int rating;

    public CommentDTO() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
