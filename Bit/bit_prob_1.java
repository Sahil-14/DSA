public class bit_prob_1 {
  public int getBit(int n,int pos){
    return n & (1 << pos);
  }
  // set 1 to position
  public int setBit(int n,int pos){
    return n | (1 << pos);
  }

  public int  clearBit(int n,int pos){
    int mask = ~(1 << pos);
    return (n & mask);
  }

  public int updateBit(int n,int pos,int value){
    int mask = ~(1 << pos);
    n = n & mask;
    return n | (value << pos);
  }


  public static void main(String[] args) {
    int n = 15;
    
  }
}
