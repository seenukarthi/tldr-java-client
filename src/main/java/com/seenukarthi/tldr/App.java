package com.seenukarthi.tldr;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        Options opts = new Options();
        JCommander jct = JCommander.newBuilder()
                .addObject(opts)
                .programName("tldr")
                .build();

        jct.setUsageFormatter(new TldrUsageFormatter(jct));

        try {
            jct.parse(args);
        } catch (ParameterException pe) {
            log.error("Invalid options: {}", pe.getMessage());
            System.exit(1);
        }

        Executor executor = new Executor(opts, jct);
        try {
            executor.doRun();
        } catch (TldrCommandNotFoundException exception) {
            log.info(AnsiColor.RED);
            log.info("This page doesn't exist yet!{}",System.lineSeparator());
            log.info("Submit new pages here: https://github.com/tldr-pages/tldr{}",System.lineSeparator());
            log.info(AnsiColor.RESET);
        } catch (TldrException exception) {
            log.error("Error: {}{}{}",AnsiColor.RED,exception.getMessage(),AnsiColor.RESET);
            System.exit(2);
        }
    }
}
