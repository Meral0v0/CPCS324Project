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

// importing the required classes from GraphFramework
import GraphFramework.Edge;
import GraphFramework.Vertex;

// beginning of Line class which inherets the Edge class
public class Line extends Edge  {

    // Attributes
    private Integer lLength;

    // define the constructor
    public Line(Vertex source, Vertex destination, int weight){
        // use super since it's important for inheretence relationship 
        super(source, destination, weight); 
        // line length is 5 times the weight "given in the question"
        this.lLength = weight * 5;
    }

    @Override
    // display the line length information 
    public void displayInfo(){
        System.out.println("The line length is : " + lLength);
    }
    
}
