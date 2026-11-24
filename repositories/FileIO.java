package repositories;
import java.lang.*;
import java.io.*;

public class FileIO{
	// repos keep at most this many records in their arrays
	public static final int MAX_RECORDS=100;

	public void writeFile(String[] data,String fileName){
		try(FileWriter fw=new FileWriter(new File(fileName))){
			for(String str:data){
				if(str!=null){
					fw.write(str);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String[] readFile(String fileName)
	{
		String[] data=new String[MAX_RECORDS];
		File f=new File(fileName);
		if(!f.exists())
		{
			return data;//no records yet
		}
		try(BufferedReader bfr=new BufferedReader(new FileReader(f)))
		{
			String str;
			int i=0;
			while((str=bfr.readLine())!=null && i<MAX_RECORDS)
			{
				if(!str.trim().isEmpty())
				{
					data[i]=str;
					i++;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
}
