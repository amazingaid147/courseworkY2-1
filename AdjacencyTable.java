import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyTable {

    private GraphNode[] table;
    private int capacity;

    public AdjacencyTable(String[] nodes) {
      String[] Nodes = new String[nodes.length];
      Nodes = nodes;

      table = new GraphNode[Nodes.length * 2];

      for (int i = 0 ; i < Nodes.length; i++)
        {
          this.capacity = Nodes.length;
          String lable = Nodes[i];
          int hashCode = lable.hashCode();
          int hashValue = (hashCode & 0x7fffffff) % capacity;
          while(table[hashValue] != null)
          {
            hashValue = hashValue + 1;
          }
          table[hashValue] = new GraphNode(lable);
          

          
        }
      

    

      


    }
  public void ADDNeighbour(String Word, String Neighbour)
  {
    int hashCode = Word.hashCode();
    int hashValue = (hashCode & 0x7fffffff) % capacity;
    while(table[hashValue].label != Word)
    {
      hashValue = hashValue + 1;
    }
    table[hashValue].addNeighbour(Neighbour);
  }
  public char incrementChar(int x, char y)
  {
    int ascii = (int) y;
    ascii = ascii + x;
    if ( ascii > 122)
    {
      ascii = ascii - 26;
    }
    return (char) ascii;
      
    
    
  }



    public GraphNode[] getTable() 
  {
        return table;
  }

    public boolean find(String s) 
  {
      int hashCode = s.hashCode();
      int hashValue = (hashCode & 0x7fffffff) % capacity;
      while (table[hashValue] != null && hashValue < capacity) 
        {
          if (table[hashValue].label.equals(s)){
            return true;
          }
          hashValue = hashValue + 1;
        }
      return false; 
  }

    public GraphNode get(String s) 
  {
      int hashCode = s.hashCode();
      int hashValue = (hashCode & 0x7fffffff) % capacity;
      while (table[hashValue] != null && hashValue < capacity) 
        {
          if (table[hashValue].label.equals(s)){
            return table[hashValue];
          }
          hashValue = hashValue + 1; 
        }
      return null; 
  }
  
  public String ConvertPathToString(LinkedList<String> path)
  {
    String output = "";
    int y = path.size();
    for(int i = 0; i < y; i++)
      {
        if (i == y - 1)
        {
            output = output + path.removeFirst();
        }
        else
        {
            output = output + path.removeFirst() + "-";
        }
      }
    return output;
  }


  public LinkedList<String> add( LinkedList<String> CurrentPath )
  {
    LinkedList<String> path = new LinkedList<String>();
    for (int i = 0; i < CurrentPath.size(); i++)
      {
        path.add(CurrentPath.get(i));
      }
    return path;
  }

    public String getPath(String s, String t) 
  {
      LinkedList<LinkedList<String>> queue = new LinkedList<LinkedList<String>> ();
      LinkedList<String> path = new LinkedList<String>();
      LinkedList<String> Currentpath = new LinkedList<String>();
      ArrayList<String> visited = new ArrayList<String>();
      visited.add(s);
      path.addFirst(s);
      queue.addFirst(path);
      while (!queue.isEmpty()) 
      {
        System.out.println(Currentpath);   
          
        Currentpath.clear();
        for(int i = 0; i < queue.getFirst().size(); i ++)
          {
            Currentpath.add(queue.getFirst().get(i));
            
          }
        queue.removeFirst();
        String currentNode = Currentpath.getLast();

        if (currentNode.equals(t)) 
        {
          String pathString = ConvertPathToString(Currentpath);
          return pathString;
        }
        
        else 
        {
          int hashCode = currentNode.hashCode();
          int hashValue = (hashCode & 0x7fffffff) % capacity;
          
          
          while (table[hashValue] != null && hashValue < capacity) 
          {
              
              
            if (table[hashValue].label.equals(currentNode))
            {
              for (int i = 0; i < table[hashValue].neighbours.length; i++) 
                {
                if (table[hashValue].neighbours[i] != null && !visited.contains(table[hashValue].neighbours[i]))
                {

                  Currentpath.addLast(table[hashValue].neighbours[i]);

                  queue.add(add(Currentpath));

                  Currentpath.removeLast();
                  visited.add(table[hashValue].neighbours[i]);
                }
              }
            }
            hashValue = hashValue + 1;
          }
          

        }
      }
      return "There is no path from " + s + " to " + t;


  }

  public boolean existsPath(String s, String t) 
    {
        LinkedList<String> queue = new LinkedList<String>();
        ArrayList<String> visited = new ArrayList<String>();
        visited.add(s);
        queue.add(s);
        while (!queue.isEmpty()) 
        {
          String x = queue.removeFirst();
          if (x.equals(t)) 
          {
            return true;
          }
          else 
          {
            int hashCode = x.hashCode();
            int hashValue = (hashCode & 0x7fffffff) % capacity;
            while (table[hashValue] != null && hashValue < capacity) 
            {
              if (table[hashValue].label.equals(x))
              {
                for (int i = 0; i < table[hashValue].neighbours.length; i++) 
                {
                  if (table[hashValue].neighbours[i] != null && !visited.contains(table[hashValue].neighbours[i]))
                  {
                    queue.add(table[hashValue].neighbours[i]);
                    visited.add(table[hashValue].neighbours[i]);
                  }
                }
              }
              hashValue = hashValue + 1;
            }



          }
        }



        return false; 
      }

    public int pathLength(String s, String t) {
      LinkedList<LinkedList<String>> queue = new LinkedList<LinkedList<String>> ();
          LinkedList<String> path = new LinkedList<String>();
          LinkedList<String> Currentpath = new LinkedList<String>();
          ArrayList<String> visited = new ArrayList<String>();
          visited.add(s);
          path.addFirst(s);
          queue.addFirst(path);
          while (!queue.isEmpty()) 
          {

            Currentpath.clear();
            for(int i = 0; i < queue.getFirst().size(); i ++)
              {
                Currentpath.add(queue.getFirst().get(i));

              }
            queue.removeFirst();
            String currentNode = Currentpath.getLast();

            if (currentNode.equals(t)) 
            {
             
              return Currentpath.size();
            }

            else 
            {
              int hashCode = currentNode.hashCode();
              int hashValue = (hashCode & 0x7fffffff) % capacity;


              while (table[hashValue] != null && hashValue < capacity) 
              {


                if (table[hashValue].label.equals(currentNode))
                {
                  for (int i = 0; i < table[hashValue].neighbours.length; i++) 
                    {
                    if (table[hashValue].neighbours[i] != null && !visited.contains(table[hashValue].neighbours[i]))
                    {

                      Currentpath.addLast(table[hashValue].neighbours[i]);

                      queue.add(add(Currentpath));

                      Currentpath.removeLast();
                      visited.add(table[hashValue].neighbours[i]);
                    }
                  }
                }
                hashValue = hashValue + 1;
              }


            }
          }
          return 0;


      

    }

  public void AddNeibours(String[] Nodes)
  {
    for (int i = 0 ; i < Nodes.length; i++)
    {
      String word = Nodes[i];
      for(int j = 0 ; j < 4 ; j++)
        {
          for(int letter = 1; letter < 26 ; letter++ )
            {
              char newLetterCH = (incrementChar(letter, word.charAt(j)));
              String newLetter = String.valueOf(newLetterCH);
              char firstLetterCH = word.charAt(0);
              String firstLetter = String.valueOf(firstLetterCH);
              char secondLetterCH = word.charAt(1);
              String secondLetter = String.valueOf(secondLetterCH);
              char thirdLetterCH = word.charAt(2);
              String thirdLetter = String.valueOf(thirdLetterCH);
              char fourthLetterCH = word.charAt(3);
              String fourthLetter = String.valueOf(fourthLetterCH);
              String newWord = "";
              if ( j == 0)
              {
                newWord  = newLetter + secondLetter + thirdLetter + fourthLetter;
              }
              if ( j == 1)
              {
                newWord  = firstLetter + newLetter + thirdLetter + fourthLetter;

              }
              if ( j == 2)
              {
                newWord  = firstLetter + secondLetter + newLetter + fourthLetter;

              }
              if ( j == 3)
              {
                newWord  = firstLetter + secondLetter + thirdLetter + newLetter;

              }

              boolean x = find(newWord);

              if (x == true)
              {
                ADDNeighbour(word, newWord);
              }
            }
        }

    }
  }

    public static AdjacencyTable weaver() {
      AdjacencyTable adj = new AdjacencyTable(WeaverWords.words);
      adj.AddNeibours(WeaverWords.words);
      return adj; 
    }
}
