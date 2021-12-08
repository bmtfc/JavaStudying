import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.*;

class Prim{

    void findPrimSolution(int thrQ) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Do u wonna read data from file: 1-yes / 0-no  ");
        int choice = sc.nextInt();
        int srcNode,matrixSize;
        int[][] wtMatrix;
        if (choice == 1){
            Scanner input = new Scanner (new File("src/matrix.txt"));
            matrixSize = input.nextInt();
            wtMatrix = new int[matrixSize][matrixSize];
            for(int i = 0; i < matrixSize; ++i)
            {
                for(int j = 0; j < matrixSize; ++j)
                {
                    if(input.hasNextInt())
                    {
                        wtMatrix[i][j] = input.nextInt();
                    }
                }
            }

        }
        else{
            System.out.print("Enter number of nodes: ");
            matrixSize = sc.nextInt();

            wtMatrix = new int[matrixSize][matrixSize];
            System.out.println("\nEnter weights:");

            for (int i=0; i<matrixSize; i++){
                for (int j=0; j<matrixSize; j++){
                    wtMatrix[i][j] = sc.nextInt();
                }
            }
        }


        System.out.print("\nEnter source node: ");
        srcNode = sc.nextInt();

        MST mst = new MST();
        mst.findMST(wtMatrix, matrixSize, srcNode,thrQ);
    }
}

