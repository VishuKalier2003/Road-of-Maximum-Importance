/* You are given an integer n denoting the number of cities in a country... The cities are numbered from 0 to n - 1... You are also given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi... You need to assign each city with an integer value from 1 to n, where each value can only be used once... The importance of a road is then defined as the sum of the values of the two cities it connects... Return the maximum total importance of all roads possible after assigning the values optimally...
 * Eg 1:  n = 5    roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]              Output: 43
 * Explanation of above case -> {The road (0,1) has an importance of 2 + 4 = 6. - The road (1,2) has an importance of 4 + 5 = 9. - The road (2,3) has an importance of 5 + 3 = 8. - The road (0,2) has an importance of 2 + 5 = 7. - The road (1,3) has an importance of 4 + 3 = 7. - The road (2,4) has an importance of 5 + 1 = 6. The total importance of all roads is 6 + 9 + 8 + 7 + 7 + 6 = 43.}
 * Eg 2: n = 5     roads = [[0,3],[2,4],[1,3]]                                Output: 20
 */
import java.util.*;
public class Road
{
    public long MaximumImportanceOfRoads(int roads[][], int n)
    {
        long max = 0, x = 1;    // Least Importance of road which can be given...
        long degree[] = new long[n];
        for(int canals[]: roads)   // For every row in roads matrix...
        {
            degree[canals[0]] = degree[canals[0]] + 1;   // Incrementing the degree of vertex...
            degree[canals[1]] = degree[canals[1]] + 1;   // Incrementing the degree of vertex...
        }
        Arrays.sort(degree);
        for(long i : degree)    // For every vertex...
            max = max + (i * (x++));    // We give the minimum vertex, the minimum importance...
        return max;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of roads : ");
        x = sc.nextInt();
        int roads[][] = new int[x][2];
        for(int i = 0; i < roads.length; i++)
        {
            System.out.print("Enter the start city of "+(i+1)+" th road : ");
            roads[i][0] = sc.nextInt();
            System.out.print("Enter the end city of "+(i+1)+" th road : ");
            roads[i][1] = sc.nextInt();
        }
        System.out.print("Enter the number of cities : ");
        x = sc.nextInt();
        Road road = new Road();             // Object creation...
        System.out.println("The Maximum Road Importance is : "+road.MaximumImportanceOfRoads(roads, x));
        sc.close();
    }
}

// Time Complexity  - O(n log n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. The vertex with minimum number of edges must be given least importance and vice versa...
 * 2. We can then sort the vertices on the basis of their degree and iteratively increase the Importance counter by one...
*/