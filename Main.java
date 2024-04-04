 class Main {
  public static void main(String[] args) {
    AdjacencyTable table = AdjacencyTable.weaver();
    String x = "acid";
    String y = "unau";
    System.out.println(table.existsPath(x,y));   
    System.out.println(table.getPath(x,y));   
    System.out.println(table.pathLength(x,y));   
    
    

      
  }
}