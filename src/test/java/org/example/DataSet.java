package org.example;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class DataSet {
    private final int valueA;
    private final int expectedResult;

    public DataSet(int valueA, int expectedResult) {
        this.valueA = valueA;
        this.expectedResult = expectedResult;
    }

    public static Stream<DataSet> parseRuleFile(String filePath) {
        try {
            URI resource = Objects.requireNonNull(DataSet.class.getClassLoader().getResource(filePath)).toURI();
            return Files.lines(Paths.get(resource)).map(DataSet::parseRule);
        } catch (IOException | URISyntaxException e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    private static DataSet parseRule(String rule) {
        String[] equationSplit = StringUtils.split(rule, '|');
        int valueA = Integer.parseInt(equationSplit[0].trim());
        int expectedResult = Integer.parseInt(equationSplit[1].trim());
        return new DataSet(valueA, expectedResult);
    }

    public int getValueA() {
        return valueA;
    }



    public int getExpectedResult() {
        return expectedResult;
    }
}