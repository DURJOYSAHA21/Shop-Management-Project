package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;

public class OwnerR implements IOwnerRepo
{
	public Owner searchOwnerByUserId(String id){
		Owner[] ownerList=this.getAllOwner();//getting objects from the text field
		
		for(int i=0;i<ownerList.length;i++){
			if(ownerList[i]!=null){
				if(ownerList[i].getUserId().equals(id)){
					return ownerList[i];
				}
			}
		}
		return null;
	}
	public Owner[] getAllOwner(){
		FileIO fi=new FileIO();//access to the file io class
		String[] data=fi.readFile("repositories/data/Owner.txt");//to read all methods from txt file
		Owner o=new Owner();//to get access of formUser/formOwner method
		Owner[] ownerList=new Owner[100];//first time creating a list
		
		int i=0;
		for(String str:data){
			if(str!=null){
				ownerList[i]=o.formOwner(str);
			}
			i++;//updating the index
		}
		return ownerList;
	}
	public void addOwner(Owner o){
		Owner[] ownerList=this.getAllOwner();
		for(int i=0;i<ownerList.length;i++){
			if(ownerList[i]==null){
				ownerList[i]=o;
				break;
			}
		}
		this.write(ownerList);//give the updated value to the write method to update on txt file
	}
	public void removeOwner(String uid){
		Owner[] ownerList=this.getAllOwner();
		for(int i=0;i<ownerList.length;i++){
			if(ownerList[i].getUserId().equals(uid)){
				ownerList[i]=null;
				break;
			}
		}
		this.write(ownerList);//give the updated value to the write method to update on txt file
	}
	public void updateOwner(Owner o){
		Owner[] ownerList=this.getAllOwner();

		for(int i=0;i<ownerList.length;i++){
			if(ownerList[i].getUserId().equals(o.getUserId())){
				ownerList[i]=o;
				break;
			}
		}
		this.write(ownerList);//give the updated value to the write method to update on txt file
	}
	public void write(Owner[] ownerList){
		FileIO fi=new FileIO();
		
		String[] data=new String[100];
		for(int i=0;i<ownerList.length;i++){
			if(ownerList[i]!=null){
				data[i]=ownerList[i].toStringOwner();
			}
		}
		fi.writeFile(data,"repositories/data/Owner.txt");
	}
}