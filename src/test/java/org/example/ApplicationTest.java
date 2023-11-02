package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ApplicationTest {
    private Application application;

    @BeforeEach
    public void setUp() {
        application = new Application();
    }

    @TestFactory
    Stream<DynamicTest> fibonacci() {
        return DataSet.parseRuleFile("testdata.txt")
                .map(dataSet -> dynamicTest(getAdditionDisplayName(dataSet), () -> {
                    assertEquals(dataSet.getExpectedResult(),application.getFibonacciNumberAt(dataSet.getValueA()));
                }));
    }

    String getAdditionDisplayName(DataSet dataSet) {
        return dataSet.getValueA() + "has fibonacci: " + dataSet.getExpectedResult();
    }
}

