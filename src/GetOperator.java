import java.util.Random;

public class GetOperator {
    static int[] UpSix = {10, 16};
    static int[] UpFive = {29, 34, 41};

    public static int[] getUpSix() {
        return UpSix;
    }

    public void setUpSix(int[] upSix) {
        UpSix = upSix;
    }

    public static int[] getUpFive() {
        return UpFive;
    }

    public void setUpFive(int[] upFive) {
        UpFive = upFive;
    }

    GetOperator(int Star) {
        Random i = new Random();
        String GetOperator = null;
        int n, m;

        switch (Star) {
            case 3:
                System.out.print("\033[37m");
                n = i.nextInt(Operator.getThreeStar().length);
                GetOperator = Operator.getThreeStar()[n];
                System.out.println(GetOperator);
                break;
            case 4:
                System.out.print("\033[35m");
                n = i.nextInt(Operator.getFourStar().length);
                GetOperator = Operator.getFourStar()[n];
                System.out.println(GetOperator);
                break;
            case 5:
                System.out.print("\033[33m");
                m = i.nextInt(2);
                if(m < 1) {
                    n = i.nextInt(Operator.getFiveStar().length);
                    for (int j : UpFive) while (n == j) n = i.nextInt(Operator.getFiveStar().length);
                    GetOperator = Operator.getFiveStar()[n];
                }
                else {
                    n = i.nextInt(UpFive.length);
                    GetOperator = Operator.getFiveStar()[UpFive[n]];
                }
                System.out.println(GetOperator);
                break;
            case 6:
                System.out.print("\033[31m");
                m = i.nextInt(2);
                if(m < 1) {//非UP
                    n = i.nextInt(Operator.getSixStar().length);
                    for (int j : UpSix) while (n == j) n = i.nextInt(Operator.getSixStar().length);//如果是UP的，就重新随机
                    GetOperator = Operator.getSixStar()[n];
                }
                else {//UP
                    n = i.nextInt(UpSix.length);
                    GetOperator = Operator.getSixStar()[UpSix[n]];
                }
                System.out.println(GetOperator);
                /*SixStarRecord.add(GetOperator);*/
                break;
        }
        HeadhuntRecord.getRecord().add(GetOperator);
    }
}
