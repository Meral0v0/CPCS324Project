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

public class Edge implements Comparable<Edge> {
    // Data fields
    int weight;
    Vertex source;
    Vertex destination;
    Vertex parent;

    // Constructor 1
    public Edge() {
        source = new Vertex(); //create new source
        destination = new Vertex(); //create new target
        parent = new Vertex(); //create new parent
    }

    // Constructor 2
    public Edge (Vertex source , Vertex destination , Vertex parent , int weight ){
        // initilize data fields 
        this.source = source;
        this.destination = destination;
        this.parent = parent;
        this.weight = weight;
    }

    // Constructor 3 
    public Edge (Vertex source , Vertex destination , int weight ){
        // initilize data fields 
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.parent = new Vertex(); // create a new parent 
    }

    // displayInfo method will be overriden by other classes later
    public void displayInfo(){
        
    }
    // compareTo method will compare between edges weights
    public int compareTo(Edge e){
        if(this.weight > e.weight)
        return 1;
        else if (this.weight== e.weight)
        return 0;
        else return -1;

    }

    
}


