package br.mag.lotogenerator.utils;

public class MathUtils {

    public static int fact(int number) {
        int f = 1;
        int j = 1;
        while(j <= number) {
            f = f * j;
            j++;
        }
        return f;
    }



}
