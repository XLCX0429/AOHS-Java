import java.util.Random;

/**
 * @author XLCX_
 */
public class GetOperator {
    static int[] UpSix;
    static int[] UpFive;
    static int[] UpFour;
    static int LastSix;
    static int LastFive;
    static int LastFour;
    static int LastThree;
    static boolean Activity = false;
    static boolean Limit = false;
    static int Probability;
    static String[] LimitOperator;
    static int UpLimit;
    static int OldLimit;

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

    public boolean isActivity() {
        return Activity;
    }

    public static void setActivity(boolean activity) {
        Activity = activity;
    }

    public static boolean isLimit() {
        return Limit;
    }

    public static void setLimit(boolean limit) {
        Limit = limit;
    }

    public static int getProbability() {
        return Probability;
    }

    public static void setProbability() {
        if (Activity) {
            Probability = 70;
        } else {
            Probability = 50;
        }
    }

    public static String[] getLimitOperator() {
        return LimitOperator;
    }

    public static void setLimitOperator(String[] limitOperator) {
        LimitOperator = limitOperator;
    }

    public static int getUpLimit() {
        return UpLimit;
    }

    public static void setUpLimit(int upLimit) {
        UpLimit = upLimit;
    }

    public static void separate(int number) {
        OldLimit = getUpLimit() - number + 1;
    }

    GetOperator(int star) {
        Random i = new Random();
        String getOperator = null;
        int n, m;

        //联合行动UP数量
        int sSix = 4;
        int sFive = 6;

        switch (star) {
            case 3:
                System.out.print("\033[37m");
                n = i.nextInt(LastThree);
                getOperator = Operator.getThreeStar()[n];
                System.out.println(getOperator);
                break;
            case 4:
                System.out.print("\033[35m");
                n = i.nextInt(LastFour);
                getOperator = Operator.getFourStar()[n];
                System.out.println(getOperator);
                break;
            case 5:
                System.out.print("\033[33m");
                //联合行动
                if (UpFive.length == sFive) {
                    n = i.nextInt(UpFive.length);
                    getOperator = Operator.getFiveStar()[UpFive[n]];
                } else {//非联合行动
                    m = i.nextInt(2);
                    if(m < 1) {
                        n = i.nextInt(LastFive);
                        for (int j : UpFive) {
                            while (n == j) {
                                n = i.nextInt(LastFive);
                            }
                        }
                        getOperator = Operator.getFiveStar()[n];
                    } else {
                        n = i.nextInt(UpFive.length);
                        getOperator = Operator.getFiveStar()[UpFive[n]];
                    }
                }
                System.out.println(getOperator);
                break;
            case 6:
                System.out.print("\033[31m");
                //联合行动
                if (UpSix.length == sSix) {
                    n = i.nextInt(UpSix.length);
                    getOperator = Operator.getSixStar()[UpSix[n]];
                } else {//非联合行动
                    m = i.nextInt(100);
                    //非UP
                    //概率为100 - Probability
                    int p = 100 - Probability;
                    if(m < p) {
                        //判断是否为限定
                        if (Limit) {
                            n = i.nextInt(LastSix + 5 * OldLimit);
                            if (n < LastSix) {
                                while (n == LastSix - 1) {
                                    //如果是UP的，就重新随机
                                    n = i.nextInt(LastSix);
                                }
                                getOperator = Operator.getSixStar()[n];
                            }
                            else {
                                getOperator = LimitOperator[(n - LastSix) / 5];
                            }
                        } else {
                            n = i.nextInt(LastSix);
                            for (int j : UpSix) {
                                while (n == j) {
                                    //如果是UP的，就重新随机
                                    n = i.nextInt(LastSix);
                                }
                            }
                            getOperator = Operator.getSixStar()[n];
                        }
                    } else {//UP
                        if (Limit) {
                            n = i.nextInt(2);
                            if (n == 1) {
                                getOperator = LimitOperator[UpLimit];
                            } else {
                                getOperator = Operator.getSixStar()[UpSix[n]];
                            }
                        } else {
                            n = i.nextInt(UpSix.length);
                            getOperator = Operator.getSixStar()[UpSix[n]];
                        }
                    }
                }

                System.out.println(getOperator);
                break;
            default:
        }
        HeadhuntRecord.getRecord().add(getOperator);
    }
}
