// topological sorting with direted graph
// directed graph -- the edge need to have a direction
// >> Find a vertex that has no successors
// >> Delete this vertex from the graph and insert its label at eht beginning of a list
// cycles cannot handle
////////////////////////////////////
class Vertex {
	public char label;

	public Vertex (char lab) {
		label = lab;
	}
}
//=================================
class Graph {
	private final int MAX_SIZE = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVert;
	private char sortedArray[];

	public Graph() {
		vertexList = new Vertex[MAX_SIZE];
		adjMat = new int[MAX_SIZE][MAX_SIZE];
		nVert = 0;
		for(int j = 0; j < MAX_SIZE; j++)
			for(int k = 0; k < MAX_SIZE; k++)
				adjMat[j][k] = 0;
		sortedArray = new char[MAX_SIZE];
	}

	public void addVertex (char lab) {
		vertexList[nVert++] = new Vertex(lab);
	}

	public void addEdge (int start, int end) {
		adjMat[start][end] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public void topo() {
		int orig_nVerts = nVert;

		while(nVert > 0) {
			//get a vertex with no successors, or -1
			int currentVertex = noSuccessors();
			if(currentVertex == -1) {
				System.out.println("ERROR: Graph has cycles");
				return;
			}
			//insert vertex label in sorted array, start at end
			sortedArray[nVert - 1] = vertexList[currentVertex].label;

			deleteVertex(currentVertex);
		}

		//vertices all gone display sortedArray
		System.out.print("Topologically sorted order: ");
		for(int j = 0; j < orig_nVerts; j++)
			System.out.print( sortedArray[j] );
		System.out.println(" ");
	}

	public int noSuccessors() {
		boolean isEdge;
		for(int row = 0; row < nVert; row++) {
			isEdge = false;
			for(int col = 0; col < nVert; col++) {
				if(adjMat[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			if( !isEdge )
				return row;
		}
		return -1;
	}

	public void deleteVertex(int delVert) {
		if(delVert != nVert - 1) {
			//not last vertex
			//delete from vertexList
			for(int j = delVert; j < nVert - 1; j++) 
				vertexList[j] = vertexList[j + 1];
			//delete from adjMat
			for(int row = delVert; row < nVert - 1; row++) 
				moveRowUp(row, nVert);
			//delete col from adjMat
			for(int col = delVert; col < nVert - 1; col++)
				moveColLeft(col, nVert - 1);
		}
		nVert--;
	}

	private void moveRowUp (int row, int length) {
		for(int col = 0; col < length; col++)
			adjMat[row][col] = adjMat[row++][col];
	}

	private void moveColLeft (int col, int length) {
		for(int row = 0; row < length; row++) 
			adjMat[row][col] = adjMat[row][col+1];
	}
}

class TopoApp {
	public static void main (String args[]) {
		Graph theGraph = new Graph();
		
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		theGraph.addVertex('G');
		theGraph.addVertex('H');
		theGraph.addEdge(0,3);
		theGraph.addEdge(0,4);
		theGraph.addEdge(1,4);
		theGraph.addEdge(2,5);
		theGraph.addEdge(3,6);
		theGraph.addEdge(4,6);
		theGraph.addEdge(5,7);
		theGraph.addEdge(6,7);

		theGraph.topo();
	}
}