public class Operator {
    static String[] SixStar;
    static String[] FiveStar;
    static String[] FourStar;
    static String[] ThreeStar;
    static String[] AllStar;

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
        AllStar = new String[SixStar.length + FiveStar.length + FourStar.length + ThreeStar.length];
        System.arraycopy(SixStar, 0, AllStar, 0, SixStar.length);
        System.arraycopy(FiveStar, 0, AllStar, SixStar.length, FiveStar.length);
        System.arraycopy(FourStar, 0, AllStar, SixStar.length + FiveStar.length, FourStar.length);
        System.arraycopy(ThreeStar, 0, AllStar, AllStar.length - ThreeStar.length, ThreeStar.length);
    }
}
