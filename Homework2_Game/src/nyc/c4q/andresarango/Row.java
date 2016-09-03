package nyc.c4q.andresarango;

import java.util.Random;

/**
 * Created by andresarango on 8/31/16.
 */
public class Row {

    private final String block = "$";
    private final String emptySpace = " ";
    private final String obstacle = "X";
    private final String ball = "o";

    public static void main(String[] args) {
    }

    //Creates a random String row
    public String[] randomRow() {
        String[] randRow = emptyRow();
        int randRowLength = getRandNumber(0, 5);
        for (int i = 0; i < randRowLength; i++) {
            randRow[i] = block;
        }
        return randRow;
    }

    //Creates a row of spaces, length 5
    private String[] emptyRow() {
        String[] emptyRo = new String[6];
        for (int i = 0; i < emptyRo.length; i++) {
            emptyRo[i] = emptySpace;
        }
        return emptyRo;
    }

    public String[] placeBall(String[] row){
        String[] newRow = new String[6];
        System.arraycopy(row,0,newRow,0,row.length);
        for (int i = 0; i <newRow.length ; i++) {
            if(newRow[i].equals(emptySpace)){
                newRow[i] = ball;
                return newRow;
            }
        }
        return null;
    }

    public String[] deleteBall(String[] row){
        String[] newRow = new String[6];
        System.arraycopy(row,0,newRow,0,row.length);
        for (int i = 0; i <newRow.length ; i++) {
            if(newRow[i].equals(ball)){
                newRow[i] = emptySpace;
                return newRow;
            }
        }
        return null;
    }
    //Check valid row move
    public boolean correctMove(String[] ballRow, String[] nextRow, String input){
        int ballBlocks = countNumberOfBlocks(ballRow);
        int nextBlocks = countNumberOfBlocks(nextRow);
        if((ballBlocks - 1 == nextBlocks) || (ballBlocks == nextBlocks)) {
            if((ballBlocks == nextBlocks)){
                return input.equalsIgnoreCase("A");
            }
            return input.equalsIgnoreCase("AA");
        } else if(ballBlocks + 1 == nextBlocks){
            return input.equalsIgnoreCase("S");
        }else if(ballBlocks + 2 == nextBlocks){
            return input.equalsIgnoreCase("D");
        }
        return false;
    }

    //count number of blocks in row
    private int countNumberOfBlocks(String[] row) {
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i].equals(block)) {
                count += 1;
            }
        }
        return count;
    }

    //Create next row
    public String[] getNextRow(String[] previousRow) {
        int numberOfBlocks = countNumberOfBlocks(previousRow);
        switch(numberOfBlocks) {
            case 0:
                return filterRow(numberOfBlocks, 2, 0, previousRow);
            case 4:
                return filterRow(numberOfBlocks, 1, 1, previousRow);
            case 5:
                return filterRow(numberOfBlocks, 0, 1, previousRow);
            default:
                return filterRow(numberOfBlocks, 2, 1, previousRow);
        }
    }

    //0 block = 0-2, add 0,2 sub 0,0
    //1 block = 0-3, add 0,2 sub 0,1
    //2 block = 1-4,  add 0,2 sub 0,1
    //3 block = 2-5,  add 0,2 sub 0,1
    //4 block = 3-5,  add 0,1 sub 0,1
    //5 block = 4-5,  add 0,0 sub 0,1

    //Prepare next row
    private String[] filterRow( int rowLength, int addMax, int subMax, String[] previousRow){
        String[] nextRow = new String[6];
        System.arraycopy(previousRow,0,nextRow,0,previousRow.length);
        boolean randBoolean = isRandBoolean();
        addMax = getRandNumber(0,addMax);
        subMax = getRandNumber(0,subMax);
        if(rowLength == 0){
            randBoolean = true;
        }else if(rowLength == 5){
            randBoolean = false;
        }
        if (randBoolean) {
            for (int i = 0; i < addMax; i++) {
                nextRow = addBlock(nextRow);
            }
        } else {
            for (int i = subMax; i > 0; i--) {
                nextRow = subtractBlock(nextRow);
            }
        }
        return nextRow;
    }

    //Gets random number between max and min, inclusive bounds
    private int getRandNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    //returns random Boolean
    private boolean isRandBoolean() {
        int n = getRandNumber(0, 1);
        if (n == 1) {
            return true;
        }
        return false;
    }

    //Add block to row
    private String[] addBlock(String[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i].equals(emptySpace)) {
                row[i] = block;
                return row;
            }
        }
        return row;
    }

    //Subtract block from row
    private String[] subtractBlock(String[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i].equals(emptySpace)) {
                row[i - 1] = emptySpace;
                return row;
            }
        }
        return row;
    }

    private static void printRow(String[] row){
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i]);
        }
        System.out.println("\n");
    }
}
