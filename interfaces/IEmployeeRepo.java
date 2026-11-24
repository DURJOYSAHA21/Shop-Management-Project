package interfaces;
import repositories.*;
import java.lang.*;
import entities.*;


public interface IEmployeeRepo
{
	void addEmployer(Employer e);
	void removeEmployer(String uid);
	void updateEmployer(Employer e);
    void write(Employer[] employerList);
	Employer searchEmployerByUserId(String uid);
    Employer[] getAllEmployer();
	
}
