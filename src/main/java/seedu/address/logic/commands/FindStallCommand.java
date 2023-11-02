package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.stall.NameContainsKeywordsPredicate;

/**
 * Finds and lists all stalls in FoodNotes whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindStallCommand extends Command {

    public static final String COMMAND_WORD = "find-stall";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all stalls whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " japanese western noodle";

    private final NameContainsKeywordsPredicate predicate;

    public FindStallCommand(NameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredStallList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_STALLS_LISTED_OVERVIEW, model.getFilteredStallList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindStallCommand)) {
            return false;
        }

        FindStallCommand otherFindStallCommand = (FindStallCommand) other;
        return predicate.equals(otherFindStallCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
