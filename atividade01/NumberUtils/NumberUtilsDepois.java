import javax.print.attribute.standard.RequestingUserName;

public class NumberUtilsDepois {
    int num;

    public boolean isPair() {
        return num % 2 == 0;
    }

    public boolean isOdd() {
        return num % 2 != 0;
    }

    public boolean isPrime() {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void printCount() {
        for (int i = 0; i <= num; i++) {
            System.out.print(i+" ");
        }
    }

    public void printReverseCount() {
        for (int i = num; i >=0; i--) {
            System.out.print(i+" ");
        }
    }

}
