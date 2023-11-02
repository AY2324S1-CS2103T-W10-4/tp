package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STALL;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteItemCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteItemCommand object
 */
public class DeleteItemCommandParser implements Parser<DeleteItemCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteItemCommand
     * and returns a DeleteItemCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteItemCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_STALL, PREFIX_ITEM);

        if (!arePrefixesPresent(argMultimap, PREFIX_STALL, PREFIX_ITEM)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteItemCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_STALL, PREFIX_ITEM);
        Index stallIndex = ParserUtil.parseStallIndex(argMultimap.getValue(PREFIX_STALL).get());
        Index itemIndex = ParserUtil.parseItemIndex(argMultimap.getValue(PREFIX_ITEM).get());
        return new DeleteItemCommand(stallIndex, itemIndex);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
