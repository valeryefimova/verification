package com.efimova.verification.ltl;

import com.efimova.verification.LtlVisitor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public abstract class Formula {
    public abstract Formula transformName(Function<String, String> transformer);

    public abstract void accept(LtlVisitor visitor);


    public String ltlToAutomaton() {
        Map<String, String> oldToNeNamesMap = new HashMap<>();

        // replace all names with vX, where x is a number:
        Formula lowercaseLTL = this.transformName(name ->
                oldToNeNamesMap.computeIfAbsent(name, v -> "v" + oldToNeNamesMap.size()));

        // replace Release to V in orders to comply spin syntax:
        String spinSyntaxFormula = lowercaseLTL.toString().replace("R", "V");
        return spinLtlToBA(spinSyntaxFormula);
    }


    @SneakyThrows
    private String spinLtlToBA(String ltl) {
        String cygwinBash = "C:\\lib\\cygwin64\\bin\\bash.exe";
        String ltl2baExecutable = "ltl2ba/ltl2ba.exe";
        String configFile = "src/main/resources/config.properties";

        BufferedReader reader = new BufferedReader(new FileReader(configFile));
        String s = reader.readLine();
        if (!s.isEmpty()) {
            cygwinBash = s;
            s = reader.readLine();
            ltl2baExecutable = s;
        } else {
            System.err.println("Unable to read config file: " + configFile);
        }

        String command = ltl2baExecutable + " -f \\\"" + ltl + "\\\"";  // windows way

        Process process = Runtime.getRuntime().exec(new String[]{cygwinBash, "-c", command});
        process.waitFor();

        StringWriter errorWriter = new StringWriter();
        IOUtils.copy(process.getErrorStream(), errorWriter);
        if (errorWriter.toString().length() > 0) {
            System.err.println(errorWriter.toString());
        }

        StringWriter writer = new StringWriter();
        IOUtils.copy(process.getInputStream(), writer);
        return writer.toString();
    }
}
