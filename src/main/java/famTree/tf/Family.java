package famTree.tf;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

	
public class Family{
	
	
	
List<Member> person = new ArrayList<Member>();

public boolean male(String name) {
	
	if(ishere(name)) {
		Member newMember = getMember(name);
		if(newMember.gender.equals("")) {
			newMember.gender = "Male"; 
			return true;
		} else {
			return false;
		}
	}
	else{
		person.add(new Member(name));
		Member newMember = getMember(name);
		newMember.gender = "Male";
		return true;
	}	
}
			
		
public boolean female(String name) {
	if(ishere(name)) {
		Member newMember = getMember(name);
		
		if(newMember.gender.equals("")) {
			newMember.gender = "Female"; 
			return true;
		} else {
			return false;
		}
	}
	else {
		person.add(new Member(name));
		Member newMember = getMember(name);
		newMember.gender = "Female";
		return true;
	}	
		}
		
public boolean isMale(String name) {
	if (ishere(name)) {
		Member newMember = getMember(name);
		if(newMember.gender == "Female") {
			return true; 
	}
		else {
			return false; 
		}	
}
	else {
		person.add(new Member(name));
		return false; 
	}	
	
}

public boolean isFemale(String name) {
	
	if (ishere(name)) {
		Member newMember = getMember(name);
		if(newMember.gender == "Female") {
			return true; 
	}
	else {
		return false; 
		}	
}
	else {
		person.add(new Member(name));
		return false; 
	}
	
}

public boolean setParentsOf(String childName, String parentName) {
	
	if(ishere(parentName)) {
		Member newMember = getMember(parentName);
		if(ishere(childName)){
			Member child = getMember(childName);
			
			if (child.parentsList.size() == 0) {
				//Add person straight away
				child.parentsList.add(newMember);
				newMember.childrenList.add(child);
				return true;
			}
			if (child.parentsList.size() == 1) {
				 if(child.parentsList.get(0).gender.equals(newMember.gender)) {
					 child.parentsList.add(newMember);
					 newMember.childrenList.add(child);

					 return false;
				 }
				 else {
					 //add person
					 newMember.childrenList.add(0, child); 
					 return true;
				 }
			}
			else {
				
				person.add(new Member(childName));
				child = get(childName);
				child.parentsList.add(newMember);
				newMember.childrenList.add(child);
				return true;
			}
		}
		
	}
	return false;
}

private Member get(String childName) {
	// TODO Auto-generated method stub
	return null;
}


public String[] getParentsOf(String name) {
	
	String[] parents = new String[2]; 
	if(ishere(name)) {
	Member child = getMember(name);
	List<Member> pList = child.parentsList;
	
	List<String> names = pList.stream().map(x -> x.name).sorted().collect(Collectors.toList()); 
	parents = names.parallelStream().toArray(String[]::new);
	}
	else {
		person.add(new Member(name));
	}
	return parents;
}

public String[] getChildrenOf(String name) {
	
	Member parent = getMember(name);
	
	String[] children = new String[parent.childrenList.size()];

	List <String> names = parent.childrenList.stream().map(x -> x.name).sorted().collect(Collectors.toList());
	children = names.stream().toArray(String[]::new);
	return children;
	
}

public boolean ishere(String name) {
	
	 //Returns people with same name
	boolean ishe = person.stream().anyMatch(x -> x.name.equals(name));
	return ishe;
	
}


public Member getMember(String name) {
	
	List<Member> newperson = person.stream().filter(x -> x.name.equals(name)).collect(Collectors.toList());
	Member newMember = newperson.get(0);
	return newMember;
}

		
}

	
	

