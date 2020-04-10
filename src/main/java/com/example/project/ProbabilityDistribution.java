package com.example.project;

import java.util.Map;

import static java.util.Map.entry;

public class ProbabilityDistribution {
    private Integer dices;
    private Long rolls;
    private Map<Integer, Long> expectedDiceResults;

    public ProbabilityDistribution(Integer dices, Long rolls) {
        this.dices = dices;
        this.rolls = rolls;
    }

    public Map<Integer, Long> calculateExpectedDiceResults(){
         if(dices == 1){
            expectedDiceResults = Map.ofEntries(
                    entry(1, (long)Math.ceil(rolls/6)),
                    entry(2, (long)Math.ceil(rolls/6)),
                    entry(3, (long)Math.ceil(rolls/6)),
                    entry(4, (long)Math.ceil(rolls/6)),
                    entry(5, (long)Math.ceil(rolls/6)),
                    entry(6, (long)Math.ceil(rolls/6)));
        }else {
            expectedDiceResults = Map.ofEntries(
                    entry(2, (long)Math.round(rolls/36)),
                    entry(3, (long)Math.round(rolls/18)),
                    entry(4, (long)Math.round(rolls/12)),
                    entry(5, (long)Math.round(rolls/9)),
                    entry(6, (long)Math.round(5*rolls/36)),
                    entry(7, (long)Math.round(rolls/6)),
                    entry(8, (long)Math.round(5*rolls/36)),
                    entry(9, (long)Math.round(rolls/9)),
                    entry(10, (long)Math.round(rolls/12)),
                    entry(11, (long)Math.round(rolls/18)),
                    entry(12, (long)Math.round(rolls/36))
            );
            }
         return expectedDiceResults;
    }
}
