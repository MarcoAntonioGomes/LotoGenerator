package br.mag.lotogenerator.loto;

import br.mag.lotogenerator.combination.Combination;

import java.util.*;
import java.util.stream.Collectors;

public class LotoGenerator implements IGenerator {

    Map<Long, Sequencia> lotoSeqs = new HashMap<>();


    @Override
    public void execute(List<Integer> numbers) {

        int quantCombinations = Combination.calculate(numbers);
        int count = 1;


        while (count <= quantCombinations){

            List<Integer> newSeq = generateSeq(numbers.size(), numbers);
            Sequencia seq = new Sequencia(newSeq);

            while (lotoSeqs.containsKey(seq.getHash())){
                 newSeq = generateSeq(numbers.size(), numbers);
                 seq = new Sequencia(newSeq);
            }
            lotoSeqs.put(seq.getHash(), seq);
            count++;
        }

        sortSeqs();

    }

    private void sortSeqs() {
        for(Map.Entry e : lotoSeqs.entrySet()){
           List<Integer> numbersSorted = ((Sequencia)e.getValue()).getNumbers().stream().sorted().collect(Collectors.toList());
            ((Sequencia)e.getValue()).setNumbers(numbersSorted);
        }
    }

    private List<Integer> generateSeq(int size, List<Integer> numbers ){

        List<Integer> listIndex = generatePositions(size);
        List<Integer> newSeq = new ArrayList<>();
        for(Integer n : listIndex){
           newSeq.add(numbers.get(n));
        }

        return newSeq;
    }

    private List<Integer> generatePositions(int size){
        Set<Integer> numbers =  new TreeSet();

        Random rand = new Random();

        while (numbers.size() < 6) {
            numbers.add(rand.nextInt(size));
        }

        return numbers.stream().collect(Collectors.toList());

    }

    public Map<Long, Sequencia> getLotoSeqs() {
        return lotoSeqs;
    }

}
