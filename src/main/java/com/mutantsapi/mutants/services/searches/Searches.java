package com.mutantsapi.mutants.services.searches;

public interface Searches {

    int searchDiagonalNegative(char[][] matrix, int len);
    int searchDiagonalPositive(char[][] matrix, int len);
    int searchHorizontal(char[][] matrix, int len);
    int searchVertical(char[][] matrix, int len);
}
