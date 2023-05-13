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

package PhoneNetworkApp;
import GraphFramework.Vertex;

// beginning of Office class which inherets the Vertex class
public class Office extends Vertex {
 
 // Data field
private String vertexName;

// Constructor
 public Office(int label){
    super(label);
    // converting string to character
    this.vertexName= String.valueOf((char)(label+65));
 }

// Method
// displayInfo method is to print the office number
@Override
public void displayInfo(){
    System.out.print("Office No. "+ vertexName);

}

}
