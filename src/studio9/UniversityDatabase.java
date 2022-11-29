package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions

	private final Map<String, Student> fred;

	public UniversityDatabase() {
		this.fred = new HashMap<>();
	}
	
	public void addStudent(String accountName, Student student) {
		this.fred.put(accountName, student);
	}

	public int getStudentCount() {
		return this.fred.size();
	}

	public String lookupFullName(String accountName) {
		if(this.fred.get(accountName) == null)
			return null;
		
		return this.fred.get(accountName).getFullName();
	}

	public double getTotalBearBucks() {
		double bux = 0.0;
		for(String account : this.fred.keySet()) {
			bux += this.fred.get(account).getBearBucksBalance();
		}
		
		return bux;
	}
}
