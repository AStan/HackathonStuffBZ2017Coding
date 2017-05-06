import java.io.File;


public class Main {

	public static void main(String[] args)
	{
		File file = new File("/Users/lucapellegrini1/Desktop/CARTELLA");
		
		listFilesForFolder(file);
		
	}
	
	
	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
	}

}
