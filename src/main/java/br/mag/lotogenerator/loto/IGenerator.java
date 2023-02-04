package br.mag.lotogenerator.loto;

import java.util.List;
import java.util.Map;

public interface IGenerator {

    void execute(List<Integer> numbers);
    Map<Long, Sequencia> getLotoSeqs();
}
