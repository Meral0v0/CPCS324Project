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


public class MHPrimAlg extends MSTAlgorithm {
	
	// Data fields
	private int cost = 0;
	
	// Constructor 
	public MHPrimAlg(Graph graph) {
		MSTResultList = new Edge[graph.verticesNO]; // Array holds the edges of MST
	}
	
	
	// Override the findMST method
	@Override
	public void findMST(Graph graph) {
			
		// Current vertex will hold vertex 0.
		Vertex vc = graph.vertices[0]; 
		
		// PriorityQueue to store edges weights
		// Note that PriorityQueue class in java is implemented as a min-heap!
		// check out the resourses above for more information!	
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); 
		

		/* //////////Prim algorithm//////////
		 * The main idea behind the Prim algorithm is to find a minimum spanning tree
		 * for a weighted undirected graph. This means it finds a subset of the edges that forms
		 * a tree that includes every vertex, where the total weight of all the edges in the tree is minimized
		 */
		

		// Loop through vertices array (|V|-1)
		 for(int i=0; i < MSTResultList.length-1; i++) {
			 
			 // Loop through adjacent vertices of this vertex
			 for(int j=0; j < vc.adjList.size(); j++) {
				 Edge edge = vc.adjList.get(j);
				 edge.source.isVisited = true;
				 // Check if its visited or not before adding it to the queue
				 if(!edge.destination.isVisited) {
					// Remaining edges
					 pq.add(edge); 
					
	
				 } 
			 } 

			 while(!pq.isEmpty()) {
				// Remove edge with minimum-weight edge e*=(v*, u*)
				Edge edge = pq.remove(); 
	
				if(!edge.destination.isVisited) {			
	                // Mark u* (target) as visited now 
					edge.destination.isVisited = true; 
					// Add the target edge to the MST list	 
					MSTResultList[i] = edge; 
					 // Get cost of minimum-weight edges (MST)
					cost += MSTResultList[i].weight;
					// Next Vertex to check adjacent of it			
					vc = edge.destination; 
					// exit after adding 1 result to the MST
					break; 
			   } 
			 }  
		 } 
	} 
	   // displayResultingMST method for displaying results for the user
	   public void displayResultingMST() {
		   // Office No. A – Office No. B :
		   // Output as required: Office No 1, Office No 2, line length
		   for(int i=0; i<MSTResultList.length-1; i++) {
			  Vertex vf = MSTResultList[i].source;
			  vf.displayInfo(); System.out.print(" - ");
			  Vertex vs = MSTResultList[i].destination;
			  vs.displayInfo(); System.out.print(" : Office No" + (MSTResultList[i].source.label+1) + " ");
			  Edge e = MSTResultList[i];
			  e.displayInfo(); System.out.println();  
		   }
	   }

	 //displayMSTcost shows only the cost calculated during the displayResultingMST Method
	   @Override
		public void displayMSTcost() {
			System.out.println("The cost of designed phone network: " + this.cost);
			} 
	   

} 

