public class Operator {
    static String[] LimitSixStar;
    static String[] SixStar;
    static String[] FiveStar;
    static String[] FourStar;
    static String[] ThreeStar;
    static String[] AllStar;

    public static String[] getLimitSixStar() {
        return LimitSixStar;
    }

    public static void setLimitSixStar(String[] limitSixStar) {
        LimitSixStar = limitSixStar;
    }

    public static String[] getSixStar() {
        return SixStar;
    }

    public static void setSixStar(String[] sixStar) {
        SixStar = sixStar;
    }

    public static String[] getFiveStar() {
        return FiveStar;
    }

    public static void setFiveStar(String[] fiveStar) {
        FiveStar = fiveStar;
    }

    public static String[] getFourStar() {
        return FourStar;
    }

    public static void setFourStar(String[] fourStar) {
        FourStar = fourStar;
    }

    public static String[] getThreeStar() {
        return ThreeStar;
    }

    public static void setThreeStar(String[] threeStar) {
        ThreeStar = threeStar;
    }

    public static String[] getAllStar() {
        return AllStar;
    }

    public static void setAllStar() {
        int StringLength = 0;
        AllStar = new String[LimitSixStar.length + SixStar.length + FiveStar.length + FourStar.length + ThreeStar.length];
        System.arraycopy(LimitSixStar, 0, AllStar, StringLength, LimitSixStar.length);
        StringLength += LimitSixStar.length;
        System.arraycopy(SixStar, 0, AllStar, StringLength, SixStar.length);
        StringLength += SixStar.length;
        System.arraycopy(FiveStar, 0, AllStar, StringLength, FiveStar.length);
        StringLength += FiveStar.length;
        System.arraycopy(FourStar, 0, AllStar, StringLength, FourStar.length);
        StringLength += FourStar.length;
        System.arraycopy(ThreeStar, 0, AllStar, StringLength, ThreeStar.length);
    }
}
