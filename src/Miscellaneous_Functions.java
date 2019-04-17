import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Miscellaneous_Functions {

    // Basically this small fucnction checks current node has been not visited and if it has mark as possible starting point
    public static void Assignment(Stack<Integer> checked_node, Stack<Integer> removed_node, ArrayList<LinkedList> list,
                                  int i, int q, int j, boolean[] visited_Nodes, int[] parent_nodes   ) {
        // Looks to see if current node has been mark as possible cycle starting point  and if it has been visited
        if (removed_node.search((int) (list.get(i)).get(q)) == -1 && !visited_Nodes[(int) (list.get(i)).get(q)]) {
            ColorNodes.Cycle_Numbers(list,q);

            // adds node to checked stack for DFS
            checked_node.push((int) (list.get(i)).get(q));
            // assign the parents node
            parent_nodes[(int) (list.get(i)).get(q)] = i;
            // start the cycle from this node
            i = ((int) (list.get(i)).get(q));
            //mark the node as visited
            visited_Nodes[i] = true;
            // start over the inner loop
            j = -1;


        }
    }
    // Flip over the cycle to make sure that this node duplicates in the list
    public static int [] Flip(int[] Nodes){
        // create a new array to flip the nodes
        int []New_path = new int [Nodes.length];
        // Starting the flipping process
        for( int l=0; l<Nodes.length; l++){
            New_path[l]= Nodes[Nodes.length-l-1];
        }
        // rearrange the order with smallest node
        return reForm(New_path);
    }
    // Get the smallest/minimum node in the cycle
    public static int Reduce( int [] Nodes){
        //Current smallest possible is the first one
        int mini= Nodes[0];
        // loop through the process to see if there is anything smaller
        for(int i:Nodes){
            if(i<mini){
                mini=i;
            }
        }
        return mini;
    }


    // Looks at two different array to see if they both have the same length and value;
    public static Boolean Similarity(int [] firstNode, int[] SecondNode){
        Boolean HasSame= (firstNode[0]==SecondNode[0]) && (firstNode.length == SecondNode.length);
        //Loop through each value to confirm if they are the same
        for( int p=1; HasSame && (p<firstNode.length);p++ ){
            if(firstNode[p] != SecondNode[p] ){
                return false;
            }
        }
        return HasSame;
    }

    // Process to remove node from stack and assign to another stack
   public static void Removed_Node(Stack<Integer> checked_node, Stack<Integer> removed_node) {
        // Checks if the node is empty to avoid errors
        if (!checked_node.empty() ) {
            // addes node to marked and visited stack
            removed_node.push(checked_node.peek());
            // removes node from checking stack
            checked_node.pop();
        }

    }
    // process of changing the cycle into all possible vays
    public static int[] reForm(int[] Nodes){
        int[] newPath= new int[Nodes.length];
        int Smallestpath= Reduce(Nodes);
        int NewLayerNode;

        System.arraycopy(Nodes, 0,newPath,0, Nodes.length);

        while(newPath[0]!=Smallestpath ){

            NewLayerNode= newPath[0];
            System.arraycopy(newPath, 1,newPath,0, newPath.length-1);
            newPath[newPath.length-1]= NewLayerNode;
        }
        return newPath;
    }

    // process of checking if the new cycle is in the current list or not
    public static Boolean New( int[] Node, ArrayList<int[]> Cycles){

        for(int [] newPath: Cycles){
            if(Similarity(newPath,Node)){
                return false;
            }
        }
        return true;
    }

        // Check if the node has been visited
    public static Boolean Visited_Nodes (int Current_Node, int [] Nodes){
        for(int b: Nodes){
            if(b==Current_Node){
                return true;
            }
        }
        return false;
    }
    // Assing new information and put things on the stack ( see each code comment for more information)
    public static void Assignment2(Stack<Integer> Checked_Node, Stack<Integer> Removed_Node, ArrayList<LinkedList> input_ArrayList,
                                  int i, int q, int j, boolean[] Visited_Nodes, int[] Parent_Nodes   ) {
        // push node to check stack
        Checked_Node.push((int) (input_ArrayList.get(i)).get(q));
        // assign the parent node
        Parent_Nodes[(int) (input_ArrayList.get(i)).get(q)] = i;
        // assign this node as new pointer
        i = ((int) (input_ArrayList.get(i)).get(q));
        // Assign node as visited
        Visited_Nodes[i] = true;
        j = -1;
    }


}
