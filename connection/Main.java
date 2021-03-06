package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {
	
	private BufferedWriter bw; 

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
	  //File file = new File("/Users/prova/Documents/workspace/Main/smells.csv");
      File file = new File("/Users/prova/Documents/workspace/Main/merge.csv");
	  readLines(file);
	  
	  
		
	}

private static void readLines(File file) throws FileNotFoundException, IOException, SQLException{


	
	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    String line;
	    int count = 0;
	    while ((line = br.readLine()) != null) {
	       String[] array = line.split(",");
	      
	 if (line.length() >5 && !line.contains("P a c k a g e   N a m e"))
	    insert(array);
	     
	       
	    }
	}
}

private static void insert(String[] array) throws SQLException{
	ResultSet resultSet;
	PreparedStatement preparedStatement;
	
	String sql =
"INSERT INTO exception2 (PackageName,CrashReport,CrashReportM,Device,AndroidOSVersion,AppVersionName,AppVersionCode,"
+ "ExceptionClass,ExceptionMessage,ThrowingFileName,ThrowingClass,ThrowingMethod,ThrowingLine,"
+ "NativeCrashLibrary,NativeCrashLocation,CrashLink) " +
"VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'); ";
	String s = array[1];
    s = s.replace("T", " ");
    s = s.replace("Z", "");
   
    for (int i = 0; i < array.length; i++){
    	
    		array[i] = array[i].replace("T", " ").replace("Z", "");
    	array[i] =array[i].replace("'", " ");}
    
	
    
    sql = String.format(sql,array[0], s,array[2],array[3],array[4],array[5],array[6],array[7], 
    		array[8],array[9],array[10],array[11],array[12],array[13],array[14],array[15]
    		);
    
System.out.println(sql);

}

private static void insertSmell(String[] array) throws SQLException{
	ResultSet resultSet;
	PreparedStatement preparedStatement;
	
	String sql =
"INSERT INTO smells (date,smells,path,fileName) " +
"VALUES ('%s', '%s', '%s', '%s'); ";
	String date = array[0];
    date = date.replace("T", " ");
    date = date.replace("Z", "");
    date = date.substring(0, date.length()-5);
    
   
    
    
    sql = String.format(sql,date, array[1].replace("code_smells:",""),array[2],array[2].substring(array[2].lastIndexOf("/")+1));
    System.out.println(sql);
    


}

	
	
	

}




