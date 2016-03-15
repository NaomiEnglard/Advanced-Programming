package phoneBook;


public class Contact1 {
	private String firstName=null; //not be allowed to change
	private String lastName;
	private String nickName; //not allowed to change
	private String phoneNumber;
//constructor no args	
//public contact(){
	//this("Ex First Name","Ex Last Name","Ex Nick name","Ex 999 999 9999");
//}
//constructor
public Contact1(String fName,String lName, String nName, String number){
	if(lName== null || nName==null|| number==null){
		//throw new InvalidDataException();
	}
	this.firstName=fName;
	this.lastName=lName;
	this.nickName=nName;
	this.phoneNumber=number; 
}
public Contact1(String lName, String nName, String number){//if it was checkedExceptiom you would need a throw here
	this(null,lName,nName,number);
}
public void setLastName(String lastName) {
	if (lastName == null){
		//throw new InvalidDataException();
	}
	this.lastName = lastName;
}
public void setPhoneNumber(String phoneNumber) {
	if (phoneNumber==null){
		//throw new InvalidDataException(); //you should also make sure there are the correct amount of numbers in the phone number
	}
	this.phoneNumber = phoneNumber;
}
public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
}
public String getNickName() {
	return nickName;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public int compareTo(Contact1 other){
return  lastName.compareTo(other.lastName);
}
public boolean equals(Object obj){ 
	//1 is obj null
	if (obj==null){
		return false;
	}
	//2 determine if obj is refrencing a contact
	if(obj instanceof Contact1){
		return false;
	}
	//3 type cast obj to your class type
	Contact1 other = (Contact1)obj;
	//4check if what you want is equal
	if(other.lastName.compareTo(this.lastName)==0){
		return true;
		
	}
	return false;
}
public String toString(){
	StringBuffer buffer=new StringBuffer();
	buffer.append("\n Contact: ") ;
	if(firstName==null){
		buffer.append("N/A");
	}else{
		buffer.append(this.firstName);
	}
	buffer.append(" LastName: ");
	buffer.append(this.lastName);
	buffer.append("  phone Number: ");
	buffer.append(this.phoneNumber);
	buffer.append(" nickname: ");
	buffer.append(this.nickName);
	return buffer.toString(); //you cant return buffer since it is not a String, the toString of buffer makes it a string
}
}
