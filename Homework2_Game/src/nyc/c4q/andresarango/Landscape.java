package nyc.c4q.andresarango;

/**
 * Created by andresarango on 8/31/16.
 */
public class Landscape {

    private Row makeRow = new Row();


    //Creating a landscape
    public String[][] createlandScape(){
        String[][] ballerScape = new String[6][6];
        ballerScape[0] = makeRow.randomRow();
        for(int i = 0; i < ballerScape.length - 1; i++){
            ballerScape[i+1] = makeRow.getNextRow(ballerScape[i]);
        }
        return ballerScape;
    }
}
