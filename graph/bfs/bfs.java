// breadth first search
//>> visit the next unvisited vertex(if there is one) that's adjacent to the current vertex, mark it, and insert it into the queue
//>> if you cannot carry out 1 because there are no more unvisited vertices, remove a vertex from the queue(if possible) and mark it the current vertex
//>> if you cannot carry out 2 because the queue is empty, you are finished
/////////////////////////////
class Queue {
	private final int SIZE = 20;
	private int[] theQu;
	private int head;
	private int tail;

	public Queue() {
		theQu = new int[SIZE];
		head = 0;
		tail = -1;
	}

	public void insert(int value) {
		if(tail == SIZE - 1) 
			tail = -1;
		theQu[++tail] = value;
	}

	public int remove() {
		int temp = theQu[head++];
		if(head == SIZE) 
			head = 0;
		return temp;
	}

	public boolean isEmpty() {
		return (head == tail + 1);
	}
}
//=============================
class Vertex {
	public char label;
	public boolean wasVisited;

	public Vertex(char lab) {
		label = lab;
		wasVisited = false;
	}
/*
	public void displayVer() {
		System.out.print(label + " ");
	}*/
}
//=============================
class Graph {
	private final int MAX_VERTEX = 20;
	private Vertex[] vertexList;
	private int nVert;
	private Queue theQueue;
	private int adjMat[][];

	public Graph() {
		vertexList = new Vertex[MAX_VERTEX];
		nVert = 0;
		theQueue = new Queue();
		adjMat = new int[MAX_VERTEX][MAX_VERTEX];
		for(int j = 0; j < MAX_VERTEX; j++)
			for(int k = 0; k < MAX_VERTEX; k ++)
				adjMat[j][k] = 0;
	}

	public void addVertex(char lab) {
		vertexList[nVert++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVer(int j) {
		System.out.print(vertexList[j].label + " ");;
	}

	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVer(0);
		theQueue.insert(0);

		//visit the next unvisited vertex(if there is one) that's adjacent to the current vertex, 
		//mark it, and insert it into the queue
		//if you cannot carry out 1 because there are no more unvisited vertices, remove a vertex
		//from the queue(if possible) and mark it the current vertex
		//if you cannot carry out 2 because the queue is empty, you are finished

		while(!theQueue.isEmpty()) {
			int v = theQueue.remove();
			// when there is adj, insert until there is no adjacent vertex
			while(getAdjUnvisitedVertex(v) != -1) {
				int vadj = getAdjUnvisitedVertex(v);
				vertexList[vadj].wasVisited = true;
				displayVer(vadj);
				theQueue.insert(vadj);
			}
		}
		// end while, queue is empty

		for(int j = 0; j < nVert; j++)
			vertexList[j].wasVisited = false;
	}

	//return: unvisited vertex subsribe, -1 no adj
	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < MAX_VERTEX; j++) {
			//connected && unvisited
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false) 
				return j;
		}
		return -1;
	}
}
//===============================
class BFSApp {
	public static void main (String args[]) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');

		theGraph.addEdge(0,1);
		theGraph.addEdge(1,2);
		theGraph.addEdge(0,3);
		theGraph.addEdge(3,4);

		System.out.print("Visits: ");
		theGraph.bfs();
		System.out.println();
	}
}