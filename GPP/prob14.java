// bit manipulation
// get - and
// set - or
// clear - or
// updata = or with require shift of variable
public class prob14 {
    static int getBit(int n,int pos){
        if ((n & (1 << pos)) != 0)
            return 1;
        return 0;
    }
    // set 1 to postion
    static int setBit(int n,int pos){
        return (n | (1 << pos));
    }
    // set 0 at i th pos
    static int clearBit(int n,int pos){
        int mask = ~(1 << pos);
        return (n & mask);
    } 
    // update ith bit with 0 or 1;
    static int updateBit(int n,int pos,int value){
        int mask = ~(1 << pos);
        n = n & mask;
        return (n | (value << pos));
    }


    public static void main(String arg[]){
        System.out.println(getBit(11, 3));
        System.out.println(setBit(5,1));
        System.out.println(clearBit(5, 2));
        System.out.println(updateBit(5, 3,1));

        
    }
}
