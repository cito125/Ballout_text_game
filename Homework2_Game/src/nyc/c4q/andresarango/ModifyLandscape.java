package nyc.c4q.andresarango;


/**
 * Created by andresarango on 8/31/16.
 */
public class ModifyLandscape {

    private Row makeRow = new Row();

    //outputLandscape outputs current Landscape
    public void outputLandscape(String[][] testScape){
        for(int i = 0; i < testScape.length; i++){
            for(int j = 0; j < testScape.length ; j++){
                System.out.print(testScape[i][j]);
            }
            System.out.print("\n");
        }
    }

    //Moves all rows up and adds new row at end
    public String[][] newRowScape(String[][] testScape){
        String[] ballRow = new String[6];
        for(int i = 0; i < testScape.length; i++){
            if(i == testScape.length - 1){
                testScape[i] = makeRow.getNextRow(testScape[i-1]);
                break;
            }
            testScape[i] = testScape[i + 1];
            if(i == 1){
                testScape[i] = testScape[i + 1];
                testScape[i] = makeRow.placeBall(testScape[i]);
            }
        }
        return testScape;
    }
    public boolean checkMove(String[][] currentScape, String input){
        String[] ballRow = currentScape[1];
        String[] nextRow = currentScape[2];
        return makeRow.correctMove(ballRow,nextRow, input);
    }

}
