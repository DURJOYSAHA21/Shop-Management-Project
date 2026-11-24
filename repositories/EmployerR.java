package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;

public class EmployerR implements IEmployeeRepo
{
	
	public Employer searchEmployerByUserId(String uid){
		Employer[] employerList=this.getAllEmployer();//getting objects from the text field
		
		for(int i=0;i<employerList.length;i++){
			if(employerList[i]!=null){
				if(employerList[i].getUserId().equals(uid)){
				    return employerList[i];
			    }
			}
		}
		return null;
	}
	
	public Employer[] getAllEmployer(){
		FileIO fi=new FileIO();//access to the file io class
		String[] data=fi.readFile("repositories/data/Employer.txt");//to read all methods from txt file
		Employer e=new Employer();//to get access of formUser/formOwner method
		Employer[] employerList=new Employer[100];//first time creating a list
		
		int i=0;
		for(String str:data){
			if(str!=null){
				employerList[i]=e.formEmployer(str);
			}
			i++;//updating the index
		}
		return employerList;
	}
	public void addEmployer(Employer e){
		Employer[] employerList=this.getAllEmployer();
		for(int i=0;i<employerList.length;i++){
			if(employerList[i]==null){
				employerList[i]=e;
				break;
			}
		}
		this.write(employerList);//give the updated value to the write method to update on txt file
	}
	public void removeEmployer(String uid){
		Employer[] employerList=this.getAllEmployer();
		for(int i=0;i<employerList.length;i++){
			if(employerList[i].getUserId().equals(uid)){
				employerList[i]=null;
				break;
			}
		}
		this.write(employerList);//give the updated value to the write method to update on txt file
	}
	public void updateEmployer(Employer e){
		Employer[] employerList=this.getAllEmployer();

		for(int i=0;i<employerList.length;i++){
			if(employerList[i].getUserId().equals(e.getUserId())){
				employerList[i]=e;
				break;
			}
		}
		this.write(employerList);//give the updated value to the write method to update on txt file
	}
	public void write(Employer[] employerList){
		FileIO fi=new FileIO();
		
		String[] data=new String[100];
		for(int i=0;i<employerList.length;i++){
			if(employerList[i]!=null){
				data[i]=employerList[i].toStringEmployer();
			}
		}
		fi.writeFile(data,"repositories/data/Employer.txt");
	}
}


