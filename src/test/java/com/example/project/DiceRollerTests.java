package com.example.project;

import com.example.controllers.DiceRollerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiceRollerTests {
    @ParameterizedTest
    @CsvSource({
            "1,6,1000",
            "2,6,1000",
            "1,6, 2000",
            "2,6, 2000",
            "1, 6, 10000",
            "2, 6, 10000"
    })
    void verifyHypothesisDeviationOfDiceResults(Integer dices, Integer faces, long rolls){
        //calculate probability distribution
        Map<Integer, Long> expectedMap = new ProbabilityDistribution(dices, rolls)
                .calculateExpectedDiceResults();
        //get the values of all rolls
        List<String> list = new DiceRollerController()
                .roleDice(dices,faces,rolls);
        //grouping by points
        Map<Integer, Long> actualMap = new ListParser(list)
                .groupingByPoints();
        //filtering non-compliant items
        Map<Integer,Long> result = actualMap.entrySet().stream()
                .filter(elem -> (double)Math.abs((elem.getValue() - expectedMap.get(elem.getKey())))/expectedMap.get(elem.getKey())*100 > 5.0)
                .collect(Collectors.toMap((entry) -> entry.getKey(), (entry) -> entry.getValue()));

        Assertions.assertTrue(result.isEmpty(),
                "Deviation of dice results is more than 5% for: " +result+
                        "\n Expected: "+expectedMap+
                        "\n Actual: "+actualMap);
    }
}
