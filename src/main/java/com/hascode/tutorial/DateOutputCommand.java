package com.hascode.tutorial;

import com.google.inject.Inject;

import io.bootique.cli.Cli;
import io.bootique.cli.CliOption;
import io.bootique.command.CommandMetadata;
import io.bootique.command.CommandOutcome;
import io.bootique.command.CommandWithMetadata;

public class DateOutputCommand extends CommandWithMetadata {
    private static final String PARAM_DATEFORMAT = "dateFormat";

    public DateOutputCommand() {
        super(CommandMetadata.builder(DateOutputCommand.class)
                .addOption(CliOption.builder(PARAM_DATEFORMAT, "The date format used to format the current date")
                        .valueOptional().build())
                .description("Print out the current date (specify format with --dateFormat)"));
    }

    @Inject
    private DateService dateService;

    @Override
    public CommandOutcome run(Cli cli) {
        try {
            String dateFormat = cli.optionString(PARAM_DATEFORMAT);
            if (dateFormat == null) {
                System.out.println(dateService.getDate());
                return CommandOutcome.succeeded();
            }

            System.out.println(dateService.getDate(dateFormat));
            return CommandOutcome.succeeded();
        } catch (IllegalArgumentException e) {
            return CommandOutcome.failed(1, e);
        }
    }

}
