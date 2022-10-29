package com.cactt4ck.bqe.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    public static boolean initDirectory(File file) {
        ArrayList<String> subFiles = new ArrayList<String>(Arrays.asList(file.list())),
                missingFiles = new ArrayList<>(),
                requiredFiles = new ArrayList<String>(Arrays.asList(
                        "objectives.yml",
                        "events.yml",
                        "package.yml",
                        "conversations"
                ));
        requiredFiles.forEach(subFile -> {
            if (!subFiles.contains(subFile))
                missingFiles.add(subFile);
        });

        if (missingFiles.isEmpty())
            return true;
        missingFiles.forEach(subFile -> {
            if (subFile.equalsIgnoreCase("conversations")) {
                try {
                    Files.createDirectory(Paths.get(file.getPath() + "/" + subFile));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                try {
                    new File(file.getPath() + "/" + subFile).createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return false;
    }

    public static void initQuest(File file) {
        ArrayList<String> requiredFiles = new ArrayList<String>(Arrays.asList(
                "objectives.yml",
                "events.yml",
                "package.yml",
                "conversations"
        ));
        requiredFiles.forEach(subFile -> {
            if (subFile.equalsIgnoreCase("conversations")) {
                try {
                    Files.createDirectory(Paths.get(file.getPath() + "/" + subFile));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                try {
                    new File(file.getPath() + "/" + subFile).createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
