package famTree.tf;


public class FamMain {
	
	public static void main(String abc[]) {
		
		Family fam = new Family();
		
		fam.setParentsOf("Frank", "Morgan");  
		fam.setParentsOf("Frank", "Dylan");        // true
		fam.male("Dylan");                        // true
		fam.setParentsOf("Joy", "Frank");          // true
		//System.out.println(fam.getMember("Dylan").spouse.get(0).name);
		fam.male("Frank");                        // true
		fam.male("Morgan");                       // false
		// (Morgan is a woman because she both is Frank's parent, but not his father) 
		fam.setParentsOf("July", "Morgan");        // true
		// (The preceding assertion was rejected, so there is no conflict)
		fam.isMale("Joy");
		fam.isFemale("Joy"); // false
		// (We know Joy is Frank's child, but we can't derive Joy's gender)
		fam.getChildrenOf("Morgan");              // ["Frank", "July"]
		fam.setParentsOf("Jennifer", "Morgan");    // true
		fam.getChildrenOf("Morgan");              // ["Frank", "Jennifer", "July"]
		fam.getChildrenOf("Dylan");               // ["Frank"]
		// (That is all we know for sure)
		fam.getParentsOf("Frank");                // ["Dylan", "Morgan"]
		fam.setParentsOf("Morgan", "Frank");       // false
	}

}
