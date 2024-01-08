package com.global.commtech.test.anagramfinder;

import java.io.File;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AnagramCommandLineRunner implements CommandLineRunner {

    private AnagramFileMatcher anagramFileMatcher;

    public AnagramCommandLineRunner(AnagramFileMatcher anagramFileMatcher){
        this.anagramFileMatcher = anagramFileMatcher;
    }

    @Override
    public void run(final String... args) throws Exception {
        Assert.isTrue(args.length == 1, "Please ensure that the input file is provided");

        final File file = new File(args[0]);
        Assert.isTrue(file.exists(), args[0] + " Does not exist");

        anagramFileMatcher.processFile(file.getAbsolutePath());
    }
}
