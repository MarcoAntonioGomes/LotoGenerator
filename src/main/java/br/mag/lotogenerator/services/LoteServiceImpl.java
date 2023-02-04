package br.mag.lotogenerator.services;

import br.mag.lotogenerator.loto.LotoGenerator;
import br.mag.lotogenerator.loto.Sequencia;
import br.mag.lotogenerator.printer.IPrintNumbers;
import br.mag.lotogenerator.printer.XlsPrintNumbers;
import org.springframework.stereotype.Service;
import  br.mag.lotogenerator.loto.IGenerator;
import java.util.List;
import java.util.Map;

@Service
public class LoteServiceImpl implements LotoService {




    @Override
    public byte[] generateLoteMegaSheet(List<Integer> numbers) {
        IGenerator generator = new LotoGenerator();
        generator.execute(numbers);
        Map<Long, Sequencia> lotoSeqs = generator.getLotoSeqs();
        IPrintNumbers printNumbers = new XlsPrintNumbers();
        return printNumbers.print(lotoSeqs);
    }

}
