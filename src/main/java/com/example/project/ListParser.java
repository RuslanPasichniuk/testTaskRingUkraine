package com.example.project;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListParser {

    List<String> list;

    public ListParser(List<String> list) {
        this.list = list;
    }

    public Double getAverageOfDiceResults(){
        IntStream stream = (list.stream()
                .map(str->str.split(" "))
                .map(str-> Arrays.asList(str))
                .map(arr->arr.stream().map(each -> Integer.parseInt(each)).mapToInt(i->i).sum())
                .mapToInt(i->i)
        );
        return (stream.average()).getAsDouble();
    }

    public Map<Integer, Long> groupingByPoints(){
        return list.stream()
                .map(str->str.split(" "))
                .map(str-> Arrays.asList(str))
                .map(arr->arr.stream().map(each -> Integer.parseInt(each)).mapToInt(i->i).sum())
                .collect(Collectors.groupingBy(i->i, Collectors.counting()));
        //.forEach((k,v)-> System.out.println(k+"=>"+v));
    }
}
