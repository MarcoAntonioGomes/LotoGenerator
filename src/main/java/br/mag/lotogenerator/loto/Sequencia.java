package br.mag.lotogenerator.loto;

import java.util.List;

public class Sequencia {

    private List<Integer> numbers;
    private Long hash;


    public Sequencia(List<Integer> numbers) {
        this.numbers = numbers;
        this.hash = calcularHash();
    }

    private Long calcularHash(){
        String numbersConcat = "";

        for(Integer n : numbers){
            numbersConcat = numbersConcat + n.toString();
        }
        return Long.valueOf(numbersConcat);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Long getHash() {
        return hash;
    }

    public String printFormattedNumber(){
        String formattedNumbers = "[";

        for (Integer number : numbers) {
            formattedNumbers = formattedNumbers + number.toString() + ", ";
        }
        formattedNumbers = formattedNumbers.substring(0, (formattedNumbers.length()-2));
        formattedNumbers = formattedNumbers + "]";
       return formattedNumbers;
    }

    @Override
    public String toString() {
        return  "Numbers= {" + numbers +'}';
    }
}
