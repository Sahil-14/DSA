import java.util.HashMap;
import java.util.Map;

public class intr {
  // 5
  // / \
  // 1 5
  // / \ \
  // 5 5 5
  c=3
  5   {5:2}
  1   {1:1, 5:2}  
  5   {5,1}

  
  

  class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  static int count = 0;

  public static  uniqueSubTrees(Node root) {
    if (root == null) {
      return null;
    }
    
    HashMap<Integer, Integer> hm = new HashMap<>();
    hm.put(root.data, hm.getOrDefault(root.data, 0) + 1);
    uniqueSubTrees(root.left);
    uniqueSubTrees(root.right);
boolean flag = false;
    for(Map.entry(k, v)  m : hm.entrySet()){
      int k = m.getKey();
      int v = m.getValue();
     if(v > 1){
       flag = true;
       break;
     }
    }
if(!flag){
c++;
}
   

  }

}
