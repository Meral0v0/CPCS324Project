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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import PhoneNetworkApp.PhoneNWDesignApp;
import PhoneNetworkApp.Line;
import PhoneNetworkApp.Office;
import PhoneNetworkApp.Mapping;


public class Graph {

	// Data Fields
    // verticesNO for counting number of vertices
    int verticesNO; 
    // edgeNO for counting number of edges
    int edgeNO; 
    // isDigraph to decide is Graph directed or not
    Boolean isDigraph; 
    // Vertex array is array of Vertices
    Vertex [] vertices; 
    // map object to help in drawing the graph
    Graph map;
  
    // Constructor 1 
    // This constructor is useful for  makeGraph() function to construct graph
    public Graph(int verticesNO, int edgeNO, boolean isDigraph) {
        this.verticesNO = verticesNO;
        this.edgeNO = edgeNO;
        this.isDigraph= isDigraph;
        this.vertices = new Vertex[verticesNO]; 
    }
    
    // Constructor 2 
   // This constructor is useful for readGraphFromFile(File fileName) function to read Graph from File
    public Graph() {
    }
    
    // createVertex method will create Vertex
    public Vertex createVertex(int label) {
    	return new Vertex(label);
    }
    
    //  createEdge method will Create Edge
    public Edge createEdge(Vertex source, Vertex target, int weight) {
    	return new Edge(source, target, weight);
    }
   
   	 /* 
        addEdge method creates an edge object and assigns the target vertex to the adjacent list of the
		source vertex and if the graph is undirected then it will add the source vertex to the adjacent list
		of the target vertex. It increments the EdgeNo by one in case it is a directed graph and by two if
		it is an undirected graph.
     */
    public Edge addEdge(int v, int u, int weight){
    	
		Graph map = new Mapping();

    	// This condition will eliminate Duplication
    	if(vertices[v] == null){ 
            // Firstly increment number of vertices to avoid Size problem
    		verticesNO++; 
            // Create new Source Vertex in the Array of Vertices
    		vertices[v] = map.createVertex(v); 
    		 }
        
    	// This condition will eliminate Duplication
        if(vertices[u] == null){
            // Firstly increment number of vertices to avoid Size problem
            verticesNO++;  
            // Create new Target Vertex in the Array of Vertices        		
            vertices[u] = map.createVertex(u); }
        
    	// newEdge method is to create new Edge
    	Edge newEdge = map.createEdge(vertices[v], vertices[u], weight);
        // Increment number of Edges
    	edgeNO++; 
        
    		// Access the Vertex Adj_List and add the Edge with its weight.    		 
    		vertices[v].adjList.add(newEdge);
    		
    	 // If the Graph is undirected 
    	 if(!isDigraph){	
    		 
         	 // Add the OPPOSITE Edge (Undirected).   
    		 newEdge = map.createEdge(vertices[u], vertices[v], weight);
            // Increment number of Edges   		 
             edgeNO++; 
             
             // Access the Vertex Adj_List and add the Edge with its weight.
             vertices[u].adjList.add(newEdge);
         }
    	 
        return newEdge;
        
    } 
    
    	/*
         * readGraphFromFile method is used to read the graph from the file sent by the main method 
         * Don't forget to throw the Exception!
         */
    	public void readGraphFromFile(File fileName) throws FileNotFoundException {
    		// Scanner to read from file
            Scanner input = new Scanner(fileName); 
            // Read the word "digraph" and ignore it "
            String dig = input.next(); 
            // Is direct graph or not?
            String typeofGraph = input.next(); 
            if(typeofGraph.equalsIgnoreCase("0")) {
                // 0 == undirected graph
                isDigraph= false; 
            }
            else if (typeofGraph.equalsIgnoreCase("1")) {
                // 1 == directed graph
            	isDigraph = true; 
            }
            // Read number of vertices  
    		int totalNumberOfVertices= input.nextInt(); 
            // Read number of edges  
    		int totalNumberOfEdge= input.nextInt(); 
    		
            // Because it goes on both directions
    		if(!isDigraph) {
    			totalNumberOfEdge *= 2;
    		}
            
            // Initialize Array of Vertices
            vertices = new Vertex[totalNumberOfVertices]; 
            

            // As long as the current edge number is smaller than the total number of edges keep looping
            while(edgeNO < totalNumberOfEdge) {
                // Read the source vertex label
                char source = input.next().charAt(0);
                // Read the destination vertex label
                char destination = input.next().charAt(0);
                // Read the weight
                int weight = input.nextInt();
                
                // to be able to find the correct vertex position immediately 
                addEdge(source-65, destination-65, weight); 
                                
            } 
            // close and relese resourses
            input.close();
    	} 
    	
    	/*
    	 * makeGraph() is method for creating a graph object with the specified parameters and randomly initializes the vertices’
		 * labels, creating edges that connects the created vertices randomly and assigning them random weights.
    	 */
    	public void makeGraph(int verticesNO, int edgeNO) {
    		    		
    		// Store all vertices accordingly 
    		for(int i=0; i < verticesNO; i++) {
    			vertices[i] = new Vertex(i);
    		}
    		
    		// Store edges respectively to make sure all vertices are connected ( (|V|-1)= # E )
    		for(int i=0; i < verticesNO-1; i++) {
    			
    			
    			// Vertex u, Vertex v, RANDOM Edge Weight
    			addEdge(vertices[i].label, vertices[i+1].label, (int) (1 + Math.random() * 10)); 
    		}

    		int i = 0;
    		// Add Remaining Edges RANDOMLY | edgeNO-(|V|-1)
    		while(i < (edgeNO-(verticesNO-1))) {
    			 int vertexU = (int) (Math.random() * verticesNO);
    			 int vertexV = (int) (Math.random() * verticesNO);
    			
    			// Avoid vertex if its self-looped
    			 if(vertexU == vertexV) {
                    // Skip the loop ( increment is skipped also) & get new random vertices.
    				 continue; 
    			 }
    			 
    			// Avoid duplicate edge with the same source and destination
    			for(int j=0; j < vertices[vertexU].adjList.size(); j++) {
    				if(vertices[vertexU].adjList.get(j).destination.label != vertexV) {
    					// break out of loop if vertexU and vertexV does not form an edge.
    					break; 
    					
    				} 
    			} 	
    			
    			// if there was no self-loop vertex & none existing edge, add new edge & increment
    			addEdge(vertices[vertexU].label, vertices[vertexV].label, (int) (1 + Math.random() * 10));
				i++;
				
    		} 		
    	} 
    } 