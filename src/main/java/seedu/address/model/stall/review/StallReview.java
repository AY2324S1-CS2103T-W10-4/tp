package seedu.address.model.stall.review;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.review.Description;
import seedu.address.model.review.Rating;

import java.util.Objects;

/**
 * Represents a review of a stall in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class StallReview {
    public static final String MESSAGE_CONSTRAINTS =
            "Review should only contain alphanumeric characters, punctuations and spaces, and it should not be BLANK!";
    private final Rating rating;
    private final Description description;

    /**
     * Constructs a StallReview object.
     *
     * @param description A valid review.
     * @param rating   A rating representing the star rating.
     */
    public StallReview(Description description, Rating rating) {
        requireAllNonNull(rating, description);
        this.rating = rating;
        this.description = description;
    }

    public Rating getRating() {
        return rating;
    }

    public Description getDescription() {
        return description;
    }

    /**
     * Returns the string representation of the StallReview.
     *
     * @return The formatted string representation of the StallReview.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("rating", rating)
                .add("description", description)
                .toString();
    }

    /**
     * Generates a hash code for the StallReview object.
     *
     * @return The hash code of the StallReview object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(rating,description);
    }
}
