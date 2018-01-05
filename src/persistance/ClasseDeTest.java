package persistance;

import persistance.OutilBase;

public class ClasseDeTest {
	 
	public static void main(String[] args) {
		String nomTable = "tableTest";
		String [][] arguments = new String [2][2];
		arguments[0][0] = "col1";
		arguments[0][1] = "varchar(20)";
		arguments[1][0] = "col2";
		arguments[1][1] = "varchar(20)";
        OutilBase.creerTable(nomTable,arguments);
    }
 
}