// 1 = Green color = Node is completely visited
// 2 = blue color=  one time visit visited
// 3 = red color = never visited completely



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ColorNodes {


        public static void Cycle_Numbers(ArrayList<LinkedList> input_ArrayList, int number_of_lines) {
            // Make a array for visisted nodes
            boolean[] Visited_Nodes = new boolean[number_of_lines];
            //Coloring each node a different color
            int[] Node_Colors = new int[number_of_lines];
            // Make a array for their parent node
            int[] Parent_Nodes = new int[number_of_lines];
            // initialize path number
            int path = 0;
            // Stack for checking node
            Stack<Integer> Checked_Node = new Stack<Integer>();
            // Stack for Visited and marks node but not colored yet
            Stack<Integer> Removed_Node = new Stack<Integer>();
            // Stack for Cycles
            Stack<Integer> Path_Length= new Stack<Integer>();
            //push the first node
            Checked_Node.push(0);
            int i=0;
            int j=0;
    // check all node
                    while (!Checked_Node.empty()) {
                        //mark first node as as visited
                        Visited_Nodes[0] = true;
                        //loop breaker
                        FinishLOOP:
                        // get the vertex
                        for ( i=0 ; i < input_ArrayList.size(); i++) {
                            // get the edge
                            for ( j=0 ; j < (input_ArrayList.get(i)).size(); j++) {
                                //another loop breaker
                                outerloop:
                                //Check if the node has more than 1 node or if it is the first node
                                if((input_ArrayList.get(i)).size() >1 || i==0){
                                // check if the node has been visited
                                if (!Visited_Nodes[(int) (input_ArrayList.get(i)).get(j)]) {
                                    if(!Visited_Nodes[i]){
                                        Visited_Nodes[i] = true;
                                    }
                                    //push node to path stack
                                    Path_Length.push((int) (input_ArrayList.get(i)).get(j));
                                    // assign different values to stack and other nodes
                                    Miscellaneous_Functions.Assignment2(Checked_Node,  Removed_Node,  input_ArrayList,
                                            i, i, j,  Visited_Nodes, Parent_Nodes);

                                    break outerloop;


                                    // if it has been visited and the new node is not it's parent and it is not remove mode stack and color is not 1
                                } else if (Visited_Nodes[(int) (input_ArrayList.get(i)).get(j)] && Parent_Nodes[i] != (int) (input_ArrayList.get(i)).get(j)
                                        && Removed_Node.search((int) (input_ArrayList.get(i)).get(j)) == -1 && (Node_Colors[(int) (input_ArrayList.get(i)).get(j)] !=1 )  ) {
                                    // now we know the path there is another path
                                    path = path + 1;
                                    // change the color of node
                                    Node_Colors[(int) (input_ArrayList.get(i)).get(j)] =1;
                                    // check if this node has any other nodes linked to it
                                    for (int q = 0; q < input_ArrayList.get(i).size(); q++) {
                                        if(Visited_Nodes[(int) (input_ArrayList.get(i)).get(q)] && Parent_Nodes[i] != (int) (input_ArrayList.get(i)).get(q)
                                                && Removed_Node.search((int) (input_ArrayList.get(i)).get(q)) == -1 &&
                                                Visited_Nodes[(int) (input_ArrayList.get(i)).get(q)] !=Visited_Nodes[(int) (input_ArrayList.get(i)).get(j)]
                                                && Node_Colors[(int) (input_ArrayList.get(i)).get(q)] !=1 ){
                                            // if the is another node that can possible create a cycle then added another path
                                            path = path + 1;
                                            // code the node of that path
                                            Node_Colors[(int) (input_ArrayList.get(i)).get(q)] =1;
                                            // assign any new node to next path
                                            if (Removed_Node.search((int) (input_ArrayList.get(i)).get(q)) == -1 && !Visited_Nodes[(int) (input_ArrayList.get(i)).get(q)]) {
                                                // assign different values to stack and other nodes
                                                Miscellaneous_Functions.Assignment2(Checked_Node,  Removed_Node,  input_ArrayList,
                                                i, q, j,  Visited_Nodes, Parent_Nodes);
                                                break outerloop;

                                            }
                                        }else {
                                            // assign any new node to next path with node path possiblitity
                                            if (Removed_Node.search((int) (input_ArrayList.get(i)).get(q)) == -1 && !Visited_Nodes[(int) (input_ArrayList.get(i)).get(q)]) {
                                                // assign different values to stack and other nodes
                                                Miscellaneous_Functions.Assignment2(Checked_Node,  Removed_Node,  input_ArrayList,
                                                        i, q, j,  Visited_Nodes, Parent_Nodes);
                                                break outerloop;

                                            }
                                        }
                                    }
                                    // Function to remove the node from the stack
                                    Miscellaneous_Functions.Removed_Node( Checked_Node, Removed_Node);
                                    i = Checked_Node.peek();
                                    j=-1;


                                    //  // if it has been visited and the new node is not it's parent and it is not remove mode stack and color is not 1
                                } else if (Visited_Nodes[(int) (input_ArrayList.get(i)).get(j)] && Parent_Nodes[i] != (int) (input_ArrayList.get(i)).get(j)
                                        && Removed_Node.search((int) (input_ArrayList.get(i)).get(j)) != -1) {
                                    for (int q = 0; q < input_ArrayList.get(i).size(); q++) {
                                        // Checking the color of nodes and if it has been visited or not
                                        if(Visited_Nodes[(int) (input_ArrayList.get(i)).get(q)] && Visited_Nodes[(int) (input_ArrayList.get(i)).get(q)] !=Visited_Nodes[(int) (input_ArrayList.get(i)).get(j)]
                                                && Node_Colors[(int) (input_ArrayList.get(i)).get(q)] !=1){
                                            path = path + 1;
                                            // Change the color of the node
                                            Node_Colors[(int) (input_ArrayList.get(i)).get(q)] =1;
                                            if (Removed_Node.search((int) (input_ArrayList.get(i)).get(q)) == -1 && !Visited_Nodes[(int) (input_ArrayList.get(i)).get(q)]) {
                                                // assign different values to stack and other nodes
                                                Miscellaneous_Functions.Assignment2(Checked_Node,  Removed_Node,  input_ArrayList,
                                                        i, q, j,  Visited_Nodes, Parent_Nodes);
                                                break outerloop;

                                            }
                                        }else {
                                            // assign any new node to next path with node path possiblitity
                                            if (Removed_Node.search((int) (input_ArrayList.get(i)).get(q)) == -1 && !Visited_Nodes[(int) (input_ArrayList.get(i)).get(q)]) {
                                                Path_Length.push((int) (input_ArrayList.get(i)).get(q));
                                                // assign different values to stack and other nodes
                                                Miscellaneous_Functions.Assignment2(Checked_Node,  Removed_Node,  input_ArrayList,
                                                        i, q, j,  Visited_Nodes, Parent_Nodes);
                                                break outerloop;

                                            }
                                        }
                                    }
                                    // Function to remove the node from the stack
                                    Miscellaneous_Functions.Removed_Node( Checked_Node, Removed_Node);
                                    if(!Checked_Node.empty()) {
                                        i = Checked_Node.peek();
                                        j = -1;
                                    }else {
                                        break FinishLOOP;
                                    }
                                }
                            }
                            else {// Function to remove the node from the stack
                                    Miscellaneous_Functions.Removed_Node( Checked_Node, Removed_Node);
                                    i = Checked_Node.peek();
                                    j=-1;

                                }
                        }
                    }
                }
        }

    }






