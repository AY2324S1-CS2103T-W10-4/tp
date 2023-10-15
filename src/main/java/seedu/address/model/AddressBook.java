package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.stall.Stall;
import seedu.address.model.stall.UniqueStallList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameStall comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniqueStallList stalls;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        stalls = new UniqueStallList();
    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the stalls in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the stall list with {@code stalls}.
     * {@code stalls} must not contain duplicate stalls.
     */
    public void setStalls(List<Stall> stalls) {
        this.stalls.setStalls(stalls);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        setStalls(newData.getStallList());
    }

    //// stall-level operations

    /**
     * Returns true if a stall with the same identity as {@code stall} exists in the address book.
     */
    public boolean hasStall(Stall stall) {
        requireNonNull(stall);
        return stalls.contains(stall);
    }

    /**
     * Adds a stall to the address book.
     * The stall must not already exist in the address book.
     */
    public void addStall(Stall p) {
        stalls.add(p);
    }

    /**
     * Replaces the given stall {@code target} in the list with {@code editedStall}.
     * {@code target} must exist in the address book.
     * The stall identity of {@code editedStall} must not be the same as another existing stall in the address book.
     */
    public void setStall(Stall target, Stall editedStall) {
        requireNonNull(editedStall);

        stalls.setStall(target, editedStall);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeStall(Stall key) {
        stalls.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("stalls", stalls)
                .toString();
    }

    @Override
    public ObservableList<Stall> getStallList() {
        return stalls.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddressBook)) {
            return false;
        }

        AddressBook otherAddressBook = (AddressBook) other;
        return stalls.equals(otherAddressBook.stalls);
    }

    @Override
    public int hashCode() {
        return stalls.hashCode();
    }
}
