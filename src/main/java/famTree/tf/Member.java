package famTree.tf;

import java.util.ArrayList;
import java.util.List;

public class Member {
	String name = "", gender = "";
	
	List<Member> childrenList = new ArrayList<Member>();
	List<Member> parentsList = new ArrayList<Member>();
	List<Member> spouseList = new ArrayList<Member>();
	
	
	public Member() {	
		
	}
	public Member(String name) {
		
		this.name = name;
	}
	
	public String name(){
		
		return name;
	}
	
	public String gender(){
		
		return gender;
	}
	
}
	
	
	

