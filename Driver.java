package main;

import java.util.ArrayList;
import java.util.Random;

import digraph.DiGraph;
import digraph.Edge;
import digraph.Node;
import hypergraph.Hypergraph;
import mydijkstra.IntMinHeap;
import mydijkstra.NodeMinHeap;

public class Driver
{
	public static void main(String[] args)
	{

		//
		//testing INT min heap
		//
		IntMinHeap test1 = new IntMinHeap(10);
		Random random = new Random();

		for(int i = 0; i < 10; i++){
			test1.insert(random.nextInt(100));
		}
		System.out.println("Min Heap: " + test1.toString());

		System.out.println("Get root: " + test1.getRoot());
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Extract min: " + test1.getRoot());
			test1.extractMin();
		}

		//
		//Test NODE MIN HEAP
		//
		NodeMinHeap<Node> test2 = new NodeMinHeap<Node>(9);

		//add 10 nodes
		for(int i = 1; i < 2; i++)
		{
			//Node(T theData, int theId) 
			//data is the fact it is associated with.
			//how to get the weight of an edge??
			Node A = new Node("A", 1);
			Node B = new Node("B", 2);
			Node C = new Node("C", 3);
			Node D = new Node("D", 4);
			Node E = new Node("E", 5);
			Node F = new Node("F", 6);
			Node G = new Node("G", 7);
			Node H = new Node("H", 8);
			Node I = new Node("I", 9);

			//Edge(int from, int to, int theWeight)
			A.addEdge(new Edge(A.getId(), B.getId(), 7));
			A.addEdge(new Edge(A.getId(), E.getId(), 6));
			A.addEdge(new Edge(A.getId(), G.getId(), 8));
			
			B.addEdge(new Edge(B.getId(), C.getId(), 19));
			D.addEdge(new Edge(D.getId(), C.getId(), 5));
			D.addEdge(new Edge(D.getId(), I.getId(), 3));
			E.addEdge(new Edge(E.getId(), C.getId(), 21));
			E.addEdge(new Edge(E.getId(), F.getId(), 13));
			E.addEdge(new Edge(E.getId(), H.getId(), 16));
			F.addEdge(new Edge(F.getId(), D.getId(), 2));
			G.addEdge(new Edge(G.getId(), H.getId(), 8));
			H.addEdge(new Edge(H.getId(), F.getId(), 2));
			I.addEdge(new Edge(I.getId(), F.getId(), 4));
			I.addEdge(new Edge(I.getId(), H.getId(), 3));
			
			test2.insert(A);
			test2.insert(B);
			test2.insert(C);
			test2.insert(D);
			test2.insert(E);
			test2.insert(F);
			test2.insert(G);
			test2.insert(H);
			test2.insert(I);
		}	

		System.out.println(test2.toString());

		for(int i = 0; i < 8; i++)
		{
			//test2.extractMin();
			System.out.println(test2.extractMin().getData());
		}

	}
}
