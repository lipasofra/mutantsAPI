package com.mutantsapi.mutants.services;


import com.mutantsapi.mutants.services.searches.SearchesImpl;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


public class SearchesTest {

    @Test
    void severalDiagonalPositiveMatches() {

        SearchesImpl searches = new SearchesImpl();
        char[][] dna = {{'A', 'T', 'G', 'T', 'G'},
                {'C', 'A', 'T', 'G', 'G'},
                {'T', 'T', 'G', 'T', 'G'},
                {'T', 'G', 'A', 'A', 'T'},
                {'C', 'C', 'C', 'C', 'T'}};

        assertEquals(2, searches.searchDiagonalPositive(dna, 5));

    }

    @Test
    void noneDiagonalPositiveMatches() {

        SearchesImpl searches = new SearchesImpl();
        char[][] dna = {{'A', 'C', 'G', 'C', 'G'},
                {'C', 'G', 'T', 'T', 'G'},
                {'T', 'T', 'G', 'T', 'G'},
                {'A', 'G', 'A', 'A', 'T'},
                {'C', 'C', 'C', 'C', 'T'}};

        assertEquals(0, searches.searchDiagonalPositive(dna, 5));

    }

    @Test
    void severalDiagonalNegativeMatches() {
        SearchesImpl searches = new SearchesImpl();
        char[][] dna = {{'A', 'T', 'G', 'C', 'G'},
                {'C', 'A', 'T', 'T', 'G'},
                {'T', 'T', 'A', 'T', 'G'},
                {'A', 'G', 'A', 'A', 'T'},
                {'C', 'C', 'C', 'C', 'T'}};

        assertEquals(2, searches.searchDiagonalNegative(dna, 5));

    }

    @Test
    void nodeDiagonalNegativeMatches() {

        SearchesImpl searches = new SearchesImpl();
        char[][] dna = {{'A', 'C', 'G', 'C', 'G'},
                {'C', 'G', 'T', 'T', 'G'},
                {'T', 'T', 'G', 'T', 'G'},
                {'A', 'G', 'A', 'A', 'T'},
                {'C', 'C', 'C', 'C', 'T'}};

        assertEquals(0, searches.searchDiagonalNegative(dna, 5));
    }

    @Test
    void horizontalMatches() {

        SearchesImpl searches = new SearchesImpl();
        char[][] dna = {{'A', 'C', 'G', 'C', 'G'},
                {'C', 'G', 'T', 'T', 'G'},
                {'T', 'T', 'G', 'T', 'G'},
                {'A', 'G', 'A', 'A', 'T'},
                {'C', 'C', 'C', 'C', 'T'}};

        assertEquals(1, searches.searchHorizontal(dna, 5));

    }

    @Test
    void noneVerticalMatches() {
        SearchesImpl searches = new SearchesImpl();
        char[][] dna = {{'A', 'C', 'G', 'C', 'G'},
                {'C', 'G', 'T', 'T', 'G'},
                {'T', 'T', 'G', 'T', 'G'},
                {'A', 'G', 'A', 'A', 'T'},
                {'C', 'C', 'C', 'C', 'T'}};

        assertEquals(0, searches.searchVertical(dna, 5));

    }



}
