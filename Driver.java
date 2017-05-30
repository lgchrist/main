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
		Random random = new Random(1);

		for(int i = 0; i < 10; i++){
			test1.insert(random.nextInt(100));
		}
				System.out.println("Min Heap: " + test1.toString());
		
				System.out.println("Get root: " + test1.getRoot());
				
				System.out.println("\nBefore decrease key: " + test1.toString());
				
				test1.decreaseKey(8, 1); 
				
				System.out.println("After decrease key: " + test1.toString());
				
				for(int i = 0; i < 10; i++)
				{
					System.out.println("Extract min: " + test1.getRoot());
					test1.extractMin();
				}



		//
		//Test NODE MIN HEAP
		//
		NodeMinHeap<Node> test2 = new NodeMinHeap<Node>(9);

		System.out.println("test node min heap: \n");

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
			A.addEdge(new Edge(A.getId(), B.getId(), 1));
			A.addEdge(new Edge(A.getId(), E.getId(), 2));
			A.addEdge(new Edge(A.getId(), G.getId(), 3));

			B.addEdge(new Edge(B.getId(), C.getId(), 4));
			D.addEdge(new Edge(D.getId(), C.getId(), 5));
			D.addEdge(new Edge(D.getId(), I.getId(), 6));
			E.addEdge(new Edge(E.getId(), C.getId(), 7));
			E.addEdge(new Edge(E.getId(), F.getId(), 8));
			E.addEdge(new Edge(E.getId(), H.getId(), 9));
			F.addEdge(new Edge(F.getId(), D.getId(), 10));
			G.addEdge(new Edge(G.getId(), H.getId(), 11));
			H.addEdge(new Edge(H.getId(), F.getId(), 12));
			I.addEdge(new Edge(I.getId(), F.getId(), 13));
			I.addEdge(new Edge(I.getId(), H.getId(), 14));

			test2.insert(A);
			test2.insert(B);
			test2.insert(C);
			test2.insert(D);
			test2.insert(E);
			test2.insert(F);
			test2.insert(G);
			test2.insert(H);
			test2.insert(I);

			for(int j = 1; j < 10; j++)
			{
				test2.getNode(j).setLengthOfPath(j*2);
			}
		}	


		System.out.println("MinHeap: \n" + test2.toString());

		test2.getNode(8).setLengthOfPath(3);
		test2.decreaseKey(8);

		System.out.println("MinHeap: \n" + test2.toString());

		for(int i = 0; i < 10; i++)
		{
			System.out.println(test2.extractMin());
		}

		System.out.println("MinHeap: \n" + test2.toString());

	}
}
