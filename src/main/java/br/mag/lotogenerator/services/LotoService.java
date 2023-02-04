package br.mag.lotogenerator.services;

import java.util.List;

public interface LotoService {

   byte[] generateLoteMegaSheet(List<Integer> numbers);

}
