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

import java.util.*;

import PhoneNetworkApp.PhoneNWDesignApp;
import PhoneNetworkApp.Line;
import PhoneNetworkApp.Office;
import PhoneNetworkApp.Mapping;;


public class KruskalAlg extends MSTAlgorithm {
    // Data field
		private int cost = 0;
		
	// KruskalAlg Constructor
	public KruskalAlg(Graph graph) {
		// MST List
		MSTResultList = new Edge[graph.verticesNO]; 
	}
	

     

	//findMST method is to show Resulting MST
	@Override
	public void findMST(Graph graph) {
		// Vertex source
		Vertex vv; 
		// Vertex target
		Vertex vu;
		// Vertex edge 
		Edge edge; 
		
        
		// use an ArrayList to store all graph edges
		// Don't use priority queues!
        List<Edge> edges = new ArrayList<>();


		/* //////////kruskal algorithm//////////
		 * The main idea behind the Kruskal algorithm is to sort the edges based on their weight.
		 * After that, we start taking edges one by one based on the lower weight. 
		 * In case we take an edge, and it results in forming a cycle, then this edge isn't included in the MST.
		 * Otherwise, the edge is included in the MS
		 */

		
		// Loop through ALL vertices
		for(int i=0; i< graph.verticesNO; i++) {
			vv = graph.vertices[i];
			// Loop through adjacent list of this vertex
			for(int j=0; j<vv.adjList.size() ; j++) {
				edges.add(vv.adjList.get(j));	
			} 
		} 
        
		// eges list will be sorted in increasing order
		// Edge class implement Java Comparable interface (compare weight)
        Collections.sort(edges);
		

		// 1. (MakeSet) Make Set for Each Vertex
		Vertex[] quickFindDS = new Vertex[graph.verticesNO]; // Set the DS as the number of vertices 
		makeSet(quickFindDS); // Make set for each vertex
		int encounter = 0; 
		
		// Loop through ALL edges
		while(encounter < MSTResultList.length-1) {
			
			// Get Minimum-weight Edge & its source & target
			edge = edges.remove(0);
			vv = edge.source;
			vu = edge.destination;
			
			// 2. (findSet)Find Representative Subset from the QuickFind Disjoint Sets
			if(!findSet(quickFindDS[vv.label].label, quickFindDS[vu.label].label)) {

				// 3. (Union) Append VT to VU & and update their representative value; 
				union(quickFindDS, vv, vu);			
				
				MSTResultList[encounter] = edge; // Add the target edge to the MST list	 
				cost += MSTResultList[encounter].weight; // Get cost of minimum-weight edges (MST)

				// increment number of edges encountered
				encounter++; 
			} 
		} 
	} 
	
	
     // makeSet method used to create one-element set{x} for all the V in the graph 
     
    public void makeSet(Vertex[] quickFindDS) {
    	
    	
		// loop through all vertecies
    	for(int i=0; i < quickFindDS.length; i++) {
			// create vertex of each vertex in the array
    		Vertex vn = new Vertex(i);
    		quickFindDS[i] = vn;
    	}
    } 
    
  // findSet method checks if the sets are the same
    public boolean findSet(int v1, int v2){
    	return v1 == v2;
    } 
    
    // union method use to combines sets
    public void union(Vertex[] quickFindDS, Vertex vv, Vertex vu) {	
        // Get VV representative 
    	int vvRepresentative = quickFindDS[vv.label].label; 
        // Get VU representative
    	int vuRepresentative = quickFindDS[vu.label].label; 
    	// Find if VV have representative or not
    	boolean vvNoRepresentative = findSet(vv.label, vvRepresentative); 
		// Find if VU have representative or not
    	boolean vuNoRepresentative = findSet(vu.label, vuRepresentative); 


    	/* Loop Scenario:
    	 * We found for example vvNoRepresentative value (true) when it actually had its own as representative
    	 * Because VV actually was the representative of the set. therefore, it had it own number,
    	 * So, performing the loop below will let us know if this is actually happened or not.
    	 * (if VV is the representative of the set so that's why VV have its own number),
    	 * this is why we set the booleans variable as false again because -> VV has representative, and its VV itself.
    	 */
    	
    	// Check if current VV & VU are representative of set 
    	for(int i=0; i<quickFindDS.length; i++) {
    		
    		// Check the (quickFindDs array if VV is representative of other vertex) && (excluding their own)
    		if(vvRepresentative == quickFindDS[i].label && (i != vv.label)) {
				// false when VV have itself is other vertex representative
    			vvNoRepresentative = false; 
    		} 
    		
    		// Check the (quickFindDs array if VU is representative of other vertex) && (excluding their own)
    		if(vuRepresentative == quickFindDS[i].label && (i != vu.label)) {
				// false when VV have itself is other vertex representative
    			vuNoRepresentative = false; 
    			
    		} 
    		
    	} 
    	
    	
    	// if VV have a representative and VU have no representative OR VV & VU (both) have no representative
    	if( ((!vvNoRepresentative) && (vuNoRepresentative)) || (vvNoRepresentative && vuNoRepresentative)) {
    		
    		// Make VV is the new representative
    		quickFindDS[vv.label] = quickFindDS[vv.label];
    		quickFindDS[vu.label] = quickFindDS[vv.label];
    	} 
    	
    	
    	// if VV have no representative and VU have a representative
    	else if (vvNoRepresentative && (!vuNoRepresentative)) {
    		quickFindDS[vv.label] = quickFindDS[vu.label];
    	} 
    	
    	
    	// VV & VU (both) have a representative
    	else {
    		// Get max representative to overwrite its children
       	    int maxRepresentative = Math.max(vvRepresentative, vuRepresentative); 
            // Get minimum to set it as the new representative
    		int minRepresentative = Math.min(vvRepresentative, vuRepresentative); 
    		
    		// Loop through the QuickFind Disjoint Subset
	    	 for(int i=0; i<quickFindDS.length; i++) {
	    		 // Find all the children of the max representative
	    		 if(quickFindDS[i].label == maxRepresentative) {
					// Update all representatives to the minimum Representative
	    			 quickFindDS[i] = quickFindDS[minRepresentative]; 
	    			 
	    		 } 
	    	 } 
    	} 
    } 
       // displayResultingMST method for displaying the results for the user
	   public void displayResultingMST() {
		   // Office No. A – Office No. B :
		   // Output as required: Office No 1, Office No 2, line length
		   for(int i=0; i<MSTResultList.length-1; i++) {
			  Vertex vf =  MSTResultList[i].source;
			  vf.displayInfo(); System.out.print(" - ");
			  Vertex vs = MSTResultList[i].destination;
			  vs.displayInfo(); System.out.print(" : Office No" + (MSTResultList[i].source.label+1) + " ");
			  Edge e = MSTResultList[i];
			  e.displayInfo(); System.out.println();  
		   }
	   }
    
	// displayMSTcost method shows only the cost calculated during the displayResultingMST Method
    @Override
	public void displayMSTcost() {
		System.out.println("The cost of designed phone network: " + this.cost);
		}
} 

