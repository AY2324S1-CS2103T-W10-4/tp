package seedu.address.model.stall;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a review for a stall in the address book.
 */
public class StallReview {
    public static final String MESSAGE_CONSTRAINTS =
            "Review should only contain alphanumeric characters and spaces, and it should not be blank! ";
    public static final String STAR_CONSTRAINTS =
            "Rating should only be an integer between 1-5.";
    public final String review;
    public final int star;

    /**
     * Constructs a {@code StallReview}.
     *
     * @param review A valid review.
     * @param star The rating of the review (1-5).
     */
    public StallReview(String review, int star) {
        requireNonNull(review);
        requireNonNull(star);
        checkArgument(isValidReview(review), MESSAGE_CONSTRAINTS);
        checkArgument(isValidStar(star), STAR_CONSTRAINTS);
        this.review = review;
        this.star = star;
    }

    /**
     * Returns true if a given string is a valid review.
     *
     * @param test The review string to validate.
     * @return True if the review is valid, false otherwise.
     */
    public static boolean isValidReview(String test) {
        return test.matches("[\\p{Alnum}][\\p{Alnum} ]*");
    }

    /**
     * Returns true if a given integer is a valid star rating (1-5).
     *
     * @param test The star rating to validate.
     * @return True if the star rating is valid, false otherwise.
     */
    public static boolean isValidStar(int test) {
        return test >= 1 && test <= 5;
    }

    @Override
    public String toString() {
        return "Rating: " + this.star + "/5\nReview: " + review;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof StallReview)) {
            return false;
        }

        StallReview otherReview = (StallReview) other;
        return review.equals(otherReview.review) && star == otherReview.star;
    }

    @Override
    public int hashCode() {
        return review.hashCode() + Integer.hashCode(star);
    }
}
