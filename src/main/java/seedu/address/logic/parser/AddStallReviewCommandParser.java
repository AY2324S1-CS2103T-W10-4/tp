package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATING;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddStallReviewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.stall.StallReview;

/**
 * Parses input arguments and creates a new AddStallReviewCommand object.
 */
public class AddStallReviewCommandParser implements Parser<AddStallReviewCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddStallReviewCommand
     * and returns an AddStallReviewCommand object for execution.
     *
     * @param args The input arguments.
     * @return A parsed AddStallReviewCommand.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public AddStallReviewCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_RATING, PREFIX_DESCRIPTION);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddStallReviewCommand.MESSAGE_USAGE), pe);
        }

        if (!arePrefixesPresent(argMultimap, PREFIX_RATING, PREFIX_DESCRIPTION)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddStallReviewCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_RATING, PREFIX_DESCRIPTION);
        StallReview stallReview = ParserUtil.parseStallReview(argMultimap.getValue(PREFIX_DESCRIPTION).get(),
                argMultimap.getValue(PREFIX_RATING).get());

        return new AddStallReviewCommand(stallReview, index);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     *
     * @param argumentMultimap The parsed arguments.
     * @param prefixes The prefixes to check.
     * @return True if all prefixes are present, false otherwise.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
