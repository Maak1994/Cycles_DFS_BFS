import java.util.ArrayList;
import java.util.LinkedList;

public class Node_Edges {

    // function to take the linked from arraylist and find the all the possible vertex and edges
    public static int[][] Get_Edges_Node_From_AdjList(ArrayList<LinkedList> ArrayList, int number_of_lines, int total){
        // 2d Array for vertex and edge
        int[][] edges = new int [total] [2];

        int b=0;
                //Start from array and get the pointer location
                for (int i = 0; i < ArrayList.size(); i++) {
                    // get the linked list of the pointed array location and get each value from the linked list
                    for (int j = 0; j < (ArrayList.get(i)).size(); j++) {
                        //assign the vertex
                        edges[b][0] = i;
                        // assign the edge to vertex
                        edges[b][1] = (int) (ArrayList.get(i)).get(j);
                        // make a new array
                        b+=1;

                    }

                }

            return edges;

        }
        }



