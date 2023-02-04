package br.mag.lotogenerator.combination;

import br.mag.lotogenerator.utils.MathUtils;

import java.util.List;

public class Combination {

    public static final int GROUPBY = 6;

    public static Integer calculate(List<Integer> numbers){

        int n = numbers.size();
        int r = GROUPBY;
        int result;

      result = MathUtils.fact(n) / (MathUtils.fact(r) * MathUtils.fact(n-r));
      return result;
    }



}
