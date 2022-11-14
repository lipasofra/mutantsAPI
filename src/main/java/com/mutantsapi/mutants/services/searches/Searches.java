package com.mutantsapi.mutants.services.searches;

public interface Searches {

    /**
     * Search into a square matrix negative diagonals for 4 equal characters
     * @param matrix the filled matrix with the chars of DNA
     * @param len the length of the DNA code
     * @return quantity of coincidences of 4 equal codes in all negative diagonals
     */
    int searchDiagonalNegative(char[][] matrix, int len);

    /**
     * Search into a square matrix positive diagonals for 4 equal characters
     * @param matrix the filled matrix with the chars of DNA
     * @param len the length of the DNA code
     * @return quantity of coincidences of 4 equal codes in all positive diagonals
     */
    int searchDiagonalPositive(char[][] matrix, int len);

    /**
     * Search into a square matrix horizontals for 4 equal characters
     * @param matrix the filled matrix with the chars of DNA
     * @param len the length of the DNA code
     * @return quantity of coincidences of 4 equal codes in all horizontals
     */
    int searchHorizontal(char[][] matrix, int len);

    /**
     * Search into a square matrix verticals for 4 equal characters
     * @param matrix the filled matrix with the chars of DNA
     * @param len the length of the DNA code
     * @return quantity of coincidences of 4 equal codes in all verticals
     */
    int searchVertical(char[][] matrix, int len);
}
