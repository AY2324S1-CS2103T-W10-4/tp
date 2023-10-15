package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteStallCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteStallCommand object
 */
public class DeleteCommandParser implements Parser<DeleteStallCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteStallCommand
     * and returns a DeleteStallCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteStallCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeleteStallCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteStallCommand.MESSAGE_USAGE), pe);
        }
    }

}
