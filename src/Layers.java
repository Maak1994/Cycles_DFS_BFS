import java.util.*;

public class Layers {

    public static void Number_of_Layers(ArrayList<LinkedList> ListBFS, int number_Line_BFS) {
        // Initializing  a queue to use BFS
        Queue<Integer> Que = new LinkedList<>();
        // Require a Visited Array to keep track of all visited nodes
        boolean[] Visited = new boolean[number_Line_BFS];
        // Need Arraylist to add the each layer of grandparents
        ArrayList<Integer> NumberofLayers = new ArrayList<>();
        // Initializing the first node as visited
        Visited[0] = true;
        // Need to Parent array to keept track of all parent nodes
        int[] Parents = new int [number_Line_BFS];
        // Need to Grandparent array so i can determine if there is new layer or same layer
        int [] GrandParents = new int[number_Line_BFS];
        // Initial first Parent node of 0 as this is the starting point and  we don't have any parents for this node
        Parents[0]= 1000000;
        // Same things for graparent node of Node 0
        GrandParents[0]= 1000000;
        // Adding the fist node to  que
        Que.add((int) (ListBFS.get(0).get(0)));
       // Visited[(int) (ListBFS.get(0)).get(0)] = true;

        // Using iterative BFS to determine the parents and grandparents of each node
        while (!Que.isEmpty()) {
            // Start with the outer layer which selects the first Array point
            for (int i = 0; i < ListBFS.size(); i++) {
                for (int j = 0; j < (ListBFS.get(i)).size(); j++) {

                    // check if the node is visited or not
                    if (!Visited[(int) (ListBFS.get(i)).get(j)]) {
                        // Assign Array[i] as the parent of Linked List node
                        Parents[(int) (ListBFS.get(i)).get(j)] = i;
                        // Check if the parent is of current node is the same

                        // Assign the grandparent of the node as the parent
                        GrandParents[(int) (ListBFS.get(i).get(j))] = Parents[i];

                        // add the node the queue as BFS
                        Que.add((int) (ListBFS.get(i).get(j)));
                        // Make the node as visited
                        Visited[(int) (ListBFS.get(i)).get(j)] = true;
                    }


                }
                // if the que to not empty then take the first node
                if(!Que.isEmpty()) {
                    i = Que.poll()-1;

                }


            }

        }

        // For the all grandparents  check which one has different grandparent and them to array. Each different granparent is our number of layers.
        for(int k=0; k<GrandParents.length; k++){

                if(!NumberofLayers.contains(GrandParents[k])) {

                    NumberofLayers.add(GrandParents[k]);
                }

        }
        // Print out all the number of layers which is the number of grandparents
        System.out.println("Number of layers in the graph: "+ (NumberofLayers.size()));
    }
}
