import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int number_Of_Lines= 0;

        int total_Number_Of_Connection=0;
        // Start reading buffer file & method has been used from project 1
        BufferedReader filereader;
        try {

            filereader= new BufferedReader(new FileReader("/Users/Mac/IdeaProjects/MohammedArsalanKhan2/src/input2.txt"));


            /* Scanning all the value and getting to n as the number of woman and male each*/
            Scanner line = new Scanner(filereader);


             /*Start reading the file for first n number*/
             while(line.hasNextLine()){
                 number_Of_Lines+=1;
                    line.nextLine();

             }
            filereader.close();
            //System.out.println(number_Of_Lines);

            int[][] matrix = new int[number_Of_Lines][number_Of_Lines];
            BufferedReader filereader2= new BufferedReader(new FileReader("/Users/Mac/IdeaProjects/MohammedArsalanKhan2/src/input2.txt"));
            Scanner line2 = new Scanner(filereader2);
            while(line2.hasNextInt()) {

                int number_of_row, number_of_col;


                for (number_of_row = 0; number_of_row <number_Of_Lines; number_of_row++) {

                        /* Looping to read all column number one by one*/
                    for (number_of_col = 0; number_of_col < number_Of_Lines; number_of_col++) {
                        matrix[number_of_row][number_of_col] = line2.nextInt();

                    }
                }

            }

             //Terminating file reader for good
            filereader.close();

            for(int i=0;i<number_Of_Lines;i++) {
                for (int j = 0; j < number_Of_Lines; j++) {
                    if(matrix[i][j]==1){
                        total_Number_Of_Connection+=1;
                    }

                }
            }

            //System.out.println("Total Number: "+total_Number_Of_Connection);

/////////////////////// Converting Matrix to List ////////////////////////////////

            //make an array for adjaceny list(AL)
            ArrayList<LinkedList> AL_Array = new ArrayList<>();
            LinkedList<Integer>[] AL_List = new LinkedList[number_Of_Lines];
 /* Convert the Matrix to List */
            //Loop through the row
            for(int i=0;i<number_Of_Lines;i++){
                //Assign new Linkedlist for each row
                AL_List[i]= new LinkedList<>();
                //Now Loop through columns to find connection to parent node
                for(int j=0; j< number_Of_Lines; j++){
                    if(matrix[i][j]==1){
                        AL_List[i].add(j);
                    }
                }
                // Adding Linked List to Arrays
                AL_Array.add(AL_List[i]);

            }
            System.out.println(" ");
////////////////////////////////////////////////////////////////////////

           // get the cycles using DFS
           FindAllCycles.Detect_Cycles(Node_Edges.Get_Edges_Node_From_AdjList(AL_Array,number_Of_Lines,total_Number_Of_Connection));
           // find the layers using BFS
           Layers.Number_of_Layers(AL_Array,number_Of_Lines);


        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
