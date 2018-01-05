package persistance;

import java.sql.ResultSet;

public class OutilBase {
	
	public static void executionRequetteSansResultSet(String requette,String nomTable){
		Connexion connexion = new Connexion("db/Database.db");
        connexion.connect();
        System.out.println("Execution de la requette : "+ requette);
        if(connexion.querySansResultSet(requette))
        	System.out.println("Execution de la requette sur la table "+nomTable+"avec succés!");
        else
        	System.out.println("Erreur lors de l'execution de la requette sur la table "+nomTable+"!");
        connexion.close();
	}
	
	public static ResultSet executionRequetteAvecResultSet(String requette,String nomTable){
		Connexion connexion = new Connexion("db/Database.db");
        connexion.connect();
        System.out.println("Execution de la requette : "+ requette);
        ResultSet resultSet = connexion.query(requette);
        if(resultSet != null)
        	System.out.println("Execution de la requette sur la table "+nomTable+"avec succés!");
        else
        	System.out.println("Erreur lors de l'execution de la requette sur la table "+nomTable+"!");
        connexion.close();
        return resultSet;
	}

	/**
	 * Creation d'une table
	 * @param nomTable,nom de la table a creer
	 * @param arguments, un tableau de la maniere suivante
	 * ARGUMENTS
	 * || NOM COLONNE || TYPE   ||
	 * ||	toto	  || String	||
	 * 
	 * Si la base n'existe pas, création d'une base vierge puis completer par la table
	 */
	public static void creerTable(String nomTable,String[][] arguments){
        String requette = "CREATE TABLE "+nomTable+" ( ";
        for(int i=0; i<arguments.length; i++){
        	requette += arguments[i][0] + " " + arguments[i][1];
        	if(i+1 != arguments.length){
        		requette += ",";
        	}
        }
        requette += " )";
        executionRequetteSansResultSet(requette,nomTable);
	}
	
	public void insertTable(String nomTable,String[] nomColonne,String[] arguments){
		if((nomColonne.length != arguments.length) && nomColonne.length != 0){
			System.out.println("Le nombre de colonne ne correspond pas au nombre d'arguments !");
			return;
		}
        String requette = "Insert into "+nomTable;
        if(nomColonne.length == 0){
        	requette += " (";
        	for(int i=0; i<nomColonne.length; i++){
	        	requette += nomColonne[i];
	        	if(i+1 != nomColonne.length){
	        		requette += ",";
	        	}
	        }
        	requette += ")";
        }
        requette += "VALUES (";
        for(int i=0; i<arguments.length; i++){
        	requette += arguments[i];
        	if(i+1 != arguments.length){
        		requette += ",";
        	}
        }
        requette += " )";
        executionRequetteSansResultSet(requette,nomTable);
	}
	
	public ResultSet selectAllTable(String nomTable){
		String requette = "Select * from "+nomTable;
		return executionRequetteAvecResultSet(requette,nomTable);
	}
	
	public ResultSet selectTable(String nomTable,String[] nomColonne){
		String requette = "Select (";
		for(int i=0; i<nomColonne.length; i++){
        	requette += nomColonne[i];
        	if(i+1 != nomColonne.length){
        		requette += ",";
        	}
        }
		requette += ") from"+nomTable;
		return executionRequetteAvecResultSet(requette,nomTable);
	}
}