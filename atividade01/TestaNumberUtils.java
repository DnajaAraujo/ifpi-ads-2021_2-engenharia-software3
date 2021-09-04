public class TestaNumberUtils {
    public static void main(String[] args) {
        NumberUtils n = new NumberUtils();
        
        n.num = 9;

        System.out.println(n.isPair());
        System.out.println(n.isOdd());
        System.out.println(n.isPrime());
        n.printCount();
        System.out.println("");
        n.printReverseCount();
        
    }
}