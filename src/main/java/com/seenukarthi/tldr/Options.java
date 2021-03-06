package com.seenukarthi.tldr;

import com.beust.jcommander.Parameter;
import lombok.Getter;

import java.io.File;


public class Options {

    @Getter
    @Parameter(description = "SEARCH")
    private String command;

    @Getter
    @SuppressWarnings("FieldMayBeFinal")
    @Parameter(names = {"--version"}, description = "Print version and exit")
    private boolean version;

    @Getter
    @SuppressWarnings("FieldMayBeFinal")
    @Parameter(names = {"--help", "-h"}, description = "Print help information and exit", help = true)
    private boolean help = false;

    @Getter
    @Parameter(names = {"--update", "-u"}, description = "Update local database", hidden = true)
    private boolean updateCache;

    @Getter
    @Parameter(names = {"--clear-cache", "-c"}, description = "Clear local cache", hidden = true)
    private boolean clearCache;

    @Getter
    @Parameter(names = {"--platform", "-p"}, description = "Platform [windows, macos|osx, linux]")
    private String platform;

    @Getter
    @Parameter(names = {"--render", "-r"}, description = "Render local file")
    private File localFile;
}
