package main;

import java.util.ArrayList;

import digraph.DiGraph;
import digraph.Linearization;
import digraph.Node;
import hypergraph.Hypergraph;
import hypergraph.Hypernode;
import hypergraph.utilities.HypergraphGenerator;
import mydijkstra.Dijkstra;
import pathgeneration.HyperedgeMultiMap;
import pathgeneration.Path;
import pathgeneration.PathGenerator;
import pathgeneration.PathHashMap;
import pebbler.Pebbler;
import pebbler.PebblerHypergraph;

public class HypergraphMain
{

	public static void main(String[] args)
	{

        Hypergraph hGraph = new Hypergraph();
        
        ArrayList aryList = new ArrayList();
        
//        aryList.add(0);
//        aryList.add(5);
        
        //
        //Create the hypergraph
        //
        for(int count = 0; count < 6; count++)
        {
        	//add six nodes 
        	//addNode(T data, int id)
            hGraph.addNode(count, count);
            //populate array list
            aryList.add(count);
        }
        
        ArrayList<Integer> fromList = new ArrayList<Integer>();
        fromList.add(0);
        //(0 -> 1)
        hGraph.addEdge(fromList, 1);
        
        //(0 -> 2)
        hGraph.addEdge(fromList, 2);
        
        ArrayList<Integer> fromList2 = new ArrayList<Integer>();
        fromList2.add(1);
        fromList2.add(2);
        fromList2.add(5);
        //(1,2,5 -> 3)
        hGraph.addEdge(fromList2, 3);
        //(1,2,5 - 4)
        hGraph.addEdge(fromList2, 4);
        
        //print the hypergraph 
		//System.out.println(hGraph);
        
		//
		//make hypergraph --> digraph
		//
        DiGraph DG = new DiGraph(hGraph);
        System.out.println("Digraph from Hypergraph: " + DG);
        
        System.out.println("Dijkstra");
        
        //Dijkstra(DiGraph dg, Node s) s = start node
		Dijkstra dijkstra = new Dijkstra(DG, DG.getNode(1));
		dijkstra.execute();
		System.out.println(dijkstra.toString());
        
//        //
//        //create path!
//        //
//        ArrayList nodesToBePebbled = new ArrayList();
//        nodesToBePebbled.add(0);
//        nodesToBePebbled.add(5);
//        
//		PebblerHypergraph pGraph = new PebblerHypergraph();
//		try
//		{
//			pGraph = hGraph.getPebbledHypergraph();
//		}
//
//		catch(Exception e)
//		{
//			System.out.println("error");
//		}
//		
//		System.out.println(pGraph);
//		
//		//
//		//Create all paths w/just one step
//		//
//		Pebbler pebbler = new Pebbler(pGraph);
//
//		pebbler.pebble(nodesToBePebbled);
//
//		HyperedgeMultiMap map = pebbler.getForwardEdges();
//		
//		System.out.println("Map: \n" + map);
//
//		//
//		//Create one path using multiple steps
//		//
//		PathGenerator pathGen = new PathGenerator(hGraph);
//		PathHashMap pathMap = new PathHashMap(map, hGraph.size());
//
//		int GOAL_NODE = 4;
//		pathGen.GeneratePathBackwardToLeaves(pathMap, map, GOAL_NODE);
//
//		// Write code to print all the paths (from the pathHashMap) with goal node 4.
//		ArrayList pathList = pathMap.get(GOAL_NODE);
//
//		for (int i = 0; i < pathList.size(); i++)
//		{
//			System.out.println("Path list: " + pathList.get(i));
//		}
	
		
	}

	

}


