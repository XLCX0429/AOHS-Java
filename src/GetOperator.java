import java.util.Random;

public class GetOperator {
    static int[] UpSix;
    static int[] UpFive;
    static int[] UpFour;
    static int LastSix;
    static int LastFive;
    static int LastFour;
    static int LastThree;

    public static int[] getUpSix() {
        return UpSix;
    }

    public static void setUpSix(int[] upSix) {
        UpSix = upSix;
    }

    public static int[] getUpFive() {
        return UpFive;
    }

    public static void setUpFive(int[] upFive) {
        UpFive = upFive;
    }

    public static int[] getUpFour() {
        return UpFour;
    }

    public static void setUpFour(int[] upFour) {
        UpFour = upFour;
    }

    public static void setLastSix(int lastSix) {
        LastSix = lastSix;
    }

    public static void setLastFive(int lastFive) {
        LastFive = lastFive;
    }

    public static void setLastFour(int lastFour) {
        LastFour = lastFour;
    }

    public static void setLastThree(int lastThree) {
        LastThree = lastThree;
    }

    GetOperator(int Star) {
        Random i = new Random();
        String GetOperator = null;
        int n, m;

        switch (Star) {
            case 3:
                System.out.print("\033[37m");
                n = i.nextInt(LastThree);
                GetOperator = Operator.getThreeStar()[n];
                System.out.println(GetOperator);
                break;
            case 4:
                System.out.print("\033[35m");
                n = i.nextInt(LastFour);
                GetOperator = Operator.getFourStar()[n];
                System.out.println(GetOperator);
                break;
            case 5:
                System.out.print("\033[33m");
                if (UpFive.length == 6) {//联合行动
                    n = i.nextInt(UpFive.length);
                    GetOperator = Operator.getFiveStar()[UpFive[n]];
                }
                else {//非联合行动
                    m = i.nextInt(2);
                    if(m < 1) {
                        n = i.nextInt(LastFive);
                        for (int j : UpFive) while (n == j) n = i.nextInt(LastFive);
                        GetOperator = Operator.getFiveStar()[n];
                    }
                    else {
                        n = i.nextInt(UpFive.length);
                        GetOperator = Operator.getFiveStar()[UpFive[n]];
                    }
                }
                System.out.println(GetOperator);
                break;
            case 6:
                System.out.print("\033[31m");
                if (UpSix.length == 4) {//联合行动
                    n = i.nextInt(UpSix.length);
                    GetOperator = Operator.getSixStar()[UpSix[n]];
                }
                else {//非联合行动
                    m = i.nextInt(2);
                    if(m < 1) {//非UP
                        n = i.nextInt(LastSix);
                        for (int j : UpSix) while (n == j) n = i.nextInt(LastSix);//如果是UP的，就重新随机
                        GetOperator = Operator.getSixStar()[n];
                    }
                    else {//UP
                        n = i.nextInt(UpSix.length);
                        GetOperator = Operator.getSixStar()[UpSix[n]];
                    }
                }

                System.out.println(GetOperator);
                break;
        }
        HeadhuntRecord.getRecord().add(GetOperator);
    }
}
