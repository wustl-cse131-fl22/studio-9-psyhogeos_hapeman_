package assignment7;

/**
 * This object type is quite interesting. It churns out new objects (apparently called 'Students') which are of great 
 * 			intrigue and mystery.
 * @author ffunkyghost617
 */
public class Student {
	
	private String firstName;
	private String lastName;
	private int studentId;
	private int attemptedCreds;
	private int passingCreds;
	private double gradeQualPnts;
	private double bbbalance;
	
	/**
	 * Default constructor method for the Student object
	 * 
	 * @param firstName	student's first name
	 * @param lastName	student's last name
	 * @param studentId	student's ID#
	 */
	public Student(String firstName, String lastName, int studentId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
	}
	
	/**
	 * Getter for student's full name
	 * 
	 * @return	full name of Student
	 */
	public String getFullName() {
		if (this.firstName==null && this.lastName==null)
			return null;
		
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * Getter for student's id#
	 * 
	 * @return	ID# of student
	 */
	public int getId() {
		return this.studentId;
	}
	
	/**
	 * Setter for student's first name
	 * 
	 * @param firstName	new value for student's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Setter for student's last name
	 * 
	 * @param lastName	new value for student's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Submits grade for newly completed course
	 * 
	 * @param grade	final grade in course (double 0-4)
	 * @param credits	number of credits offered by course
	 */
	public void submitGrade(double grade, int credits) {
		this.attemptedCreds += credits;
		if(grade >= 1.7)
			this.passingCreds += credits;
		this.gradeQualPnts += grade * credits;
	}
	
	/**
	 * Getter for student's number of credits attempted
	 * 
	 * @return	# of attempted credits for student
	 */
	public int getTotalAttemptedCredits() {
		return this.attemptedCreds;
	}
	
	/**
	 * Getter for student's number of passed credits
	 * 
	 * @return	# of passing credits for student
	 */
	public int getTotalPassingCredits() {
		return this.passingCreds;
	}
	
	/**
	 * Calculates a student's GPA based on all submitted courses
	 * 
	 * @return	student's GPA
	 */
	public double calculateGradePointAverage() {
		return this.gradeQualPnts / this.attemptedCreds;
	}
	
	/**
	 * Evaluates a student's class standing based on passing credits and GPA
	 * 
	 * @return	String for current class standing of student
	 */
	public String getClassStanding() {
		if(this.passingCreds < 30)
			return "First Year";
		else if(this.passingCreds < 60)
			return "Sophomore";
		else if(this.passingCreds < 90)
			return "Junior";
		else
			return "Senior";
	}
	
	/**
	 * Evaluates a student's eligibility for Phi Beta Kappa based on attempted credits and GPA
	 * 
	 * @return	boolean for student's PBK eligibility
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if(this.attemptedCreds >= 98 && this.calculateGradePointAverage() >= 3.60)
			return true;
		else if(this.attemptedCreds >= 75 && this.calculateGradePointAverage() >= 3.80)
			return true;
		else
			return false;
	}
	
	/**
	 * Deposits bear bucks into student's account
	 * 
	 * @param amount	amount added to student's bear bucks account
	 */
	public void depositBearBucks(double amount) {
		this.bbbalance += amount;
	}
	
	/**
	 * Withdraws bear bucks from student's account
	 * 
	 * @param amount	amount withdrawn from student's bear bucks account
	 */
	public void deductBearBucks(double amount) {
		this.bbbalance -= amount;
	}
	
	/**
	 * Getter for student's current bear bucks account balance
	 * 
	 * @return	current bear bucks account balance for student
	 */
	public double getBearBucksBalance() {
		return this.bbbalance;
	}
	
	/**
	 * Zeroes out student's bear bucks account by either:
	 * 		a) confiscating everything if bbbalance less than or equal to 10.0
	 * 		b) confiscating 10.0 and returning remaining balance if bbbalance greater than 10.0
	 * 
	 * @return	balance returned to student
	 */
	public double cashOutBearBucks() {
		if(this.bbbalance <= 10.0) {
			this.bbbalance = 0.0;
			return 0.0;
		} else {
			double cashed = this.bbbalance - 10.0;
			this.bbbalance = 0;
			return cashed;
		}
	}
	
	/**
	 * Creates a new legacy student based on data from two parent students (this and other)
	 * 
	 * @param firstName	legacy student's first name
	 * @param other		other parent student
	 * @param isHyphenated	boolean for whether legacy student's last name is hyphenated or not
	 * @param id		legacy student's ID#
	 * @return			newly created student
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		Student legacy = new Student(firstName, "", id);
		if(isHyphenated)
			legacy.lastName = this.lastName + "-" + other.lastName;
		else
			legacy.lastName = this.lastName;
		if(this.bbbalance > 10.0) {
			legacy.bbbalance += this.bbbalance - 10.0;
		}
		this.bbbalance = 0.0;
		if(other.bbbalance > 10.0) {
			legacy.bbbalance += other.bbbalance - 10.0;
		}
		other.bbbalance = 0.0;
		return legacy;
	}
	
	public String toString() {
		return this.getFullName() + " " + this.getId();
	}
}
