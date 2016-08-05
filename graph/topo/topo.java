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
}