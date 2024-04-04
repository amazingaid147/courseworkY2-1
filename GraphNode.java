 public class GraphNode {

    // A node holds a String label, and an array of its neighbours
    public String label;
    public String[] neighbours = new String[6];
    private int pointer = 0;// 6 neighbours to start with

    // You may add further fields and methods.
    static String[] ResizeArray(String[] array){
      int newSize = array.length * 2;
      String[] newArray = new String[newSize];
      for (int i = 0; i < array.length ; i++){
        newArray[i] = array[i];
      }



      return newArray;
      
      
    }
     
    public GraphNode(String label) {
      this.label = label;
    }

    public void addNeighbour(String s) {
       neighbours[pointer] = s;
       pointer = pointer + 1;
      
       if (pointer == (neighbours.length-1)){
         neighbours = ResizeArray(neighbours);
         
         
       }
      
   }

}
