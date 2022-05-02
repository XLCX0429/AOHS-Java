import java.util.Random;

/**
 * @author XLCX_
 */
public class Headhunt {
    static int FirstFive = 10;
    static boolean FirstFiveYes = false;
    GetOperator getOperator;
    static int LastSix = 0;
    static int HeadhuntTime = 0;

    public static int getFirstFive() {
        return FirstFive;
    }

    public static void setFirstFive(int firstFive) {
        FirstFive = firstFive;
    }

    public static boolean isFirstFiveYes() {
        return FirstFiveYes;
    }

    public static void setFirstFiveYes(boolean firstFiveYes) {
        FirstFiveYes = firstFiveYes;
    }

    public static int getLastSix() {
        return LastSix;
    }

    public static void setLastSix(int lastSix) {
        LastSix = lastSix;
    }

    public static int getHeadhuntTime() {
        return HeadhuntTime;
    }

    public static void setHeadhuntTime(int headhuntTime) {
        HeadhuntTime = headhuntTime;
    }

    Headhunt() {
        Random i = new Random();
        int S1 = 2400, S2 = 2204, S3 = 979;
        int n = i.nextInt(2450);
        LastSix ++;
        if (LastSix > 50) {
            S1 = 2400 - (LastSix - 50) * 49;
            S2 = 2204 - (LastSix - 50) * 49 + (LastSix - 50) * 4;
            S3 = 979 - (LastSix - 50) * 49 + (LastSix - 50) * 4 + (LastSix - 50) * 25;
        }
        if (FirstFive == 1 && n <= S2) {
            int j = i.nextInt(5);
            if (j < 1) {getOperator = new GetOperator(6); LastSix = 0;}
            else {
                getOperator = new GetOperator(5);
            }
            FirstFiveYes = true;
        }
        else {
            if (n > S1) {getOperator = new GetOperator(6); FirstFiveYes = true;}
            else if (n > S2) {getOperator = new GetOperator(5); FirstFiveYes = true;}
            else if (n > S3) {
                getOperator = new GetOperator(4);
            } else {
                getOperator = new GetOperator(3);
            }
        }
        if (!FirstFiveYes) {
            FirstFive--;
        } else {
            FirstFive = 0;
        }
        if (n > S1) {
            LastSix = 0;
        }
        HeadhuntTime++;
    }
}
