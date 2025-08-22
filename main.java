
package wchanges;

import java.util.*;

public class Wchanges {
   public static void main (String[]args){
     Node start = new Node (0,0);
     Node goal = new Node(4,4);

         List<Node> path = AStarsearch.findPath(start, goal);

             if (path != null){
         System.out.println("path found");
         for (Node n : path){
             System.out.println ("(" + n.x + "," + n.y + ")");
         }
      } else {
         System.out.println("no path found");
         }
     }
     
static class Node implements Comparable <Node> {
      public int x, y;
      public double gCost, hCost;
      Node parent;
      
      Node (intx, int y){
          this.x = x;
          this.y = y;
          this.gCost = Double.POSITIVE_INFINITY;
    }
    double fCost (){
        return gCost + hCost;
    }
    @Override
    public int compareTo(other Node){
        return Double.compare(this.fCost(), other.fCost());        
    }
    @Override
    public boolean equals(Object obj){
        if (!(obj istanceof Node))return false;
        Node other = (Node) obj;
        return this.x == other.x && this.y == other.y;
    }
    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
}
 static class AStarSearch {
     static int [][] grid = {
         {0, 0, 0, 0, 0},
         {0, 0, 1, 0, 0},
         {0, 0, 1, 0, 0},
         {0, 1, 0, 0, 0},
         {0, 0, 0, 0, 0}
     };
     
     static int ROWS = 5, COLS = 5;
     
     static List<Node>findPath(Node start, Node goal){
         PriorityQueue<Node> openSet = new PriorityQueue<>();
         Map<String, Node> allNodes = new HashMap<>();
         Set<Node> closedSet = new HashSet<>();

            start.gCost = 0;
            start.hCost = Math.abs(start.x - goal.x) + Math.abs(start.y - goal.y);
            openSet.add(start);
            allNodes.put(start.x + "," + start.y, start);
         
         while (!openSet.isEmpty()){
             Node current = openSet.poll();
             
             if (current.equals(goal)){
                 List<Node> path = new ArrayList<>(){
                 while (current != null){
                     path.add (current);
                     current = current.parent;
                 }
                 Collections.reverse(path);
                 return path;
             }
                         
             closedSet.add(current);
             for (int [] dir : new int [][]{1,0},{-1,0},{0,1},{0,-1}}){
                 int nx = current.x + dir[0], ny = current.y + dir[1];
                 if (nx >= 0 && ny >= 0 && nx < ROWS && ny < COLS && grid [nx][ny] == 0){
                   Node neighborr = allNodes.getOrDefault(key, new Node(nx, ny));
                   allNodes.put(key, neighbor);
                  
                   if (closedSet.contains(neighbor))continue;
                   
                   double tentativeG = current Gcost + 1;
                   
                   if (!openSet.contains(neighbor)){
                       neighbor.hCost = Math.abs(nx - goal.x) + Math.abs(ny - goal.y);
                       better = true;
                   } else if { (tentativeG < neighbor.Gcost){
                       better = true ;
                   }
                   if (tentativeG < neighbor.gCost){
                       neighbor.gCost = tentativeG;
                       neighbor.hCost = Math.abs(nx - goal.x) + Math.abs(ny - goal.y);
                       neighbor.parent = current;
                       openSet.add(neighbor);
                   }
              }
        }
}
return null;
      

     
 

