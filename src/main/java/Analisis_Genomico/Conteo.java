package Analisis_Genomico;

public class Conteo {

    public int contarGenes(String dna) {
        return contarGenesRecursivo(dna, 0);
    }

    private int contarGenesRecursivo(String dna, int indice) {
        int inicio = dna.indexOf("ATG", indice);
        if (inicio == -1) {
            return 0;
        }

        int fin = encontrarFinGen(dna, inicio + 3);
        if (fin != -1) {
            return 1 + contarGenesRecursivo(dna, fin + 3);
        }
        return contarGenesRecursivo(dna, inicio + 3);
    }

    private int encontrarFinGen(String dna, int start) {
        int tag = dna.indexOf("TAG", start);
        int taa = dna.indexOf("TAA", start);
        int tga = dna.indexOf("TGA", start);
        int minEnd = -1;

        if (tag != -1 && (tag - start) % 3 == 0) {
            minEnd = tag;
        }
        if (taa != -1 && (taa - start) % 3 == 0 && (minEnd == -1 || taa < minEnd)) {
            minEnd = taa;
        }
        if (tga != -1 && (tga - start) % 3 == 0 && (minEnd == -1 || tga < minEnd)) {
            minEnd = tga;
        }
        return minEnd;
    }
}
