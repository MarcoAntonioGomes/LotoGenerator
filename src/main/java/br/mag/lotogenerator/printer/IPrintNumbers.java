package br.mag.lotogenerator.printer;

import br.mag.lotogenerator.loto.Sequencia;

import java.util.Map;

public interface IPrintNumbers {

    byte[] print(Map<Long, Sequencia> lotoSeqs);

}
