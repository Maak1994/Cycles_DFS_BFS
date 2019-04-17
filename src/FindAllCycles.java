import java.util.*;

public class FindAllCycles {



    public static void Detect_Cycles(int[][] Edges_Nodes){

        // Create a hashset to store all the cycles and remove the duplicate cycles
        HashSet<ArrayList<Integer>> Maps = new HashSet<>();
        // Initailize the longest cycle
        int LongestCycle=0;
        // Used to Arraylist to store each values of the as an array
        ArrayList<int[]> Cycles= new ArrayList<>();
        // Used another arraylist to take the each value from Cycles Arraylist and store them properly
        ArrayList<Integer> SortCycles = new ArrayList<>();
        // Loop through each adjacency list to get the next node and locate it's parent
        for ( int i=0 ; i < Edges_Nodes.length; i++) {
            // get the next edges from i
            for (int j = 0; j < Edges_Nodes[i].length; j++) {
                // Run a modified DFS which will allow me to get all the cycles
                LocateCylces(new int[]{Edges_Nodes[i][j]}, Edges_Nodes, Cycles);

            }

        }
        // Take each cycle found and place them into a new sortCycles
        for(int list[] : Cycles){
            // Add the first element of the cycle which majority of the time is the starting node
            SortCycles.add(list[0]);
            for (int i = 1; i < list.length; i++)
            {
                //add the remaining values to be sorted
                SortCycles.add(list[i]);

            }
            // Sort using the Collection
            Collections.sort(SortCycles);

            // Determine the long cycle and replace the cycle if  the cycle length if bigger than current value
            if(SortCycles.size()>LongestCycle){
                // Add this Cycle length to Longest Cycle
                LongestCycle=SortCycles.size();
            }
            // add the sort cycles to Hashset as it will automatically remove the duplicate values
            Maps.add(SortCycles);
            // Clear the cycles as it will automatically remove current node from the array list to avoid combining two different cycles
            SortCycles.clear();

        }



        System.out.println("Number of Cycles: " + Maps.size());
        System.out.println("Longest Cycle: "+ LongestCycle + " nodes");

    }


    private static void LocateCylces(int[] Nodes, int[][] Edges_Nodes, ArrayList<int[]> Cycles){
        // Starting point of the graph
        int Cycle_Start = Nodes[0];
        // This is the Next edge of the Start node
        int[] PathNode = new int[Nodes.length +1];

        // loop through all the vertex to create a path and see if path return to starting node
        for(int i =0; i< Edges_Nodes.length;i++){
            // get the edge to vertex
            for (int j = 0; j <= 1; j++){
                // Checking the current point is the start node
                if(Edges_Nodes[i][j]== Cycle_Start){
                    // check if the nodes has been visited or not
                    if(!Miscellaneous_Functions.Visited_Nodes((Edges_Nodes[i][(j+1)%2]),Nodes)){
                        // get the next node to the previous path and add the node
                        PathNode[0]= (Edges_Nodes[i][(j+1)%2]);
                        // change the size of the array as another node/edge has been added
                        System.arraycopy(Nodes,0,PathNode,1,Nodes.length);
                        // Start the DFS cycle again
                         LocateCylces(PathNode,Edges_Nodes,Cycles);
                         // if path is greater than 2 and current node is also the end node
                    }else if((Nodes.length>2) && ((Edges_Nodes[i][(j+1)%2])== Nodes[Nodes.length-1])){
                        //  change or reform the cycles such the it start with smallest node
                        int[] New_path = Miscellaneous_Functions.reForm(Nodes);
                        // Flip the cycle to make sure we are not adding duplicate cycles such 12345 which is same as 54321
                        int[] Path_Flip= Miscellaneous_Functions.Flip(New_path);
                        // Once we have the reform cycle and flipped cycle, we check if the cycles is in our list
                        if(Miscellaneous_Functions.New(New_path, Cycles) && Miscellaneous_Functions.New(Path_Flip, Cycles)) {
                            // if it is not then we add the cycle to our list
                            Cycles.add(New_path);
                        }


                    }

                }

            }
        }

    }

}
