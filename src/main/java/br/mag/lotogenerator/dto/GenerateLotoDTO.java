package br.mag.lotogenerator.dto;

import java.io.Serializable;
import java.util.List;


public class GenerateLotoDTO implements Serializable {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
