package com.mutantsapi.mutants.services.searches;

public class SearchesImpl implements Searches{

    @Override
    public int searchDiagonalNegative(char[][] matrix, int len) {
        int sequences = 0;
        int repeated = 0;

        rowloop1: for(int row = 2; row >= 0; row--){
            columnloop1: for(int column = 0, row2 = row; row2 < len-1; column++, row2++){
                if(row == 0){
                    for(int columnLast=0; columnLast <=len-4; columnLast++){
                        columnloop2: for(int rowLast=row, columnLast2=columnLast; columnLast2<len-1; columnLast2++, rowLast++){
                            if(matrix[rowLast][columnLast2] == matrix[rowLast+1][columnLast2+1]){
                                repeated = repeated +1;
                                if(repeated == 3){
                                    sequences = sequences + 1;
                                    repeated = 0;
                                }
                            } else {
                                if (columnLast2 + 1 >= len-3){
                                    repeated = 0;
                                    break columnloop2;
                                }
                                repeated = 0;
                            }
                        }
                    }
                    break rowloop1;
                }
                if(matrix[row2][column] == matrix[row2+1][column+1]){
                    repeated = repeated +1;
                    if(repeated == 3){
                        sequences = sequences + 1;
                        repeated = 0;
                    }
                } else {
                    if (row+1 >= 3){
                        repeated = 0;
                        break columnloop1;
                    }
                    repeated = 0;
                }
            }
        }
        return sequences;
    }


    @Override
    public int searchDiagonalPositive(char[][] matrix, int len) {
        int sequences = 0;
        int repeated = 0;

        rowloop1: for(int row = 3; row < len; row ++){
            columnloop1: for(int column = 0, row2 = row; column < row; column++, row2--){
                if(row == len - 1){
                    for(int columnLast=0; columnLast <=len-4; columnLast++){
                        columnloop2: for(int rowLast=row, columnLast2=columnLast; columnLast2<len-1; columnLast2++, rowLast--){
                            if(matrix[rowLast][columnLast2] == matrix[rowLast-1][columnLast2+1]){
                                repeated = repeated +1;
                                if(repeated == 3){
                                    sequences = sequences + 1;
                                    repeated = 0;
                                }
                            } else {
                                if (columnLast2 + 1 >= 3){
                                    repeated = 0;
                                    break columnloop2;
                                }
                                repeated = 0;
                            }
                        }
                    }
                    break rowloop1;
                }
                if(matrix[row2][column] == matrix[row2-1][column+1]){
                    repeated = repeated +1;
                    if(repeated == 3){
                        sequences = sequences + 1;
                        repeated = 0;
                    }
                } else {
                    if (row-1 <= 2){
                        repeated = 0;
                        break columnloop1;
                    }
                    repeated = 0;
                }
            }
        }
        return sequences;
    }

    @Override
    public int searchHorizontal(char[][] matrix, int len) {
        int sequences = 0;
        int repeated = 0;

        rowloop: for (int row = 0; row < len; row++) {
            columnloop: for (int column = 0; column < len-1; column++) {
                if(matrix[row][column] == matrix[row][column+1]){
                    repeated = repeated + 1;
                    if(repeated == 3){
                        sequences = sequences + 1;
                        repeated = 0;
                    }
                } else {
                    if (column >= len-4){
                        repeated = 0;
                        break columnloop;
                    }
                    repeated = 0;
                }
            }
            repeated = 0;
        }
        return sequences;
    }

    @Override
    public int searchVertical(char[][] matrix, int len) {
        int sequences = 0;
        int repeated = 0;

        columnloop: for (int column = 0; column < len; column++) {
            rowloop: for (int row = 0; row < len-1; row++) {
                if(matrix[row][column] == matrix[row + 1][column]){
                    repeated = repeated + 1;
                    if(repeated == 3){
                        sequences = sequences + 1;
                        repeated = 0;
                    }
                } else {
                    if (row >= len-4){
                        repeated = 0;
                        break rowloop;
                    }
                    repeated = 0;
                }
            }
            repeated = 0;
        }
        return sequences;
    }
}
