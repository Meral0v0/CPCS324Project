/*
 * Leader: Meral Abdulkareem(2105036) B8
 * Wajd Al-Qahtani(2105344) B8 
 * Lama Al-Shehri(2105655) B0B
 * Reema Bahamdain(2009525) CP1
 * 
 * Subject: CPCS-324
 * Project: Phase 1
 * Constructor:
 * Dr. أسماء الشنقيطي 
 * Dr. سيدرا قريشي
 * Resourses: 
 * https://poe.com/s/OBiwglKejoZKQu77SSGv
 * https://poe.com/s/KWh5IC5oxN3OONGQ8jYg
 * https://stackoverflow.com/questions/6065710/how-does-javas-priorityqueue-differ-from-a-min-heap
 * https://www.geeksforgeeks.org/applications-of-minimum-spanning-tree/
 * https://www.gatevidyalay.com/tag/kruskals-algorithm-example-with-solution/
 * 
 */

package GraphFramework;

public abstract class MSTAlgorithm {

    // data fields
    Edge[] MSTResultList;


    // constructor 
    public MSTAlgorithm(){
        Edge[] MSTResultList = this.MSTResultList;

    }



    // methods will be overriden later 
    public void findMST(Graph Graph) {
		
	}

	public void displayResultingMST() {
		
	} 
	
	public void displayMSTcost() {
	}

}