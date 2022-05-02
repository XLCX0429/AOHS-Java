/**
 * @author XLCX_
 */
public class Operator {
    static String[] Limit;
    static String[] LimitSpring;
    static String[] LimitSummer;
    static String[] SixStar;
    static String[] FiveStar;
    static String[] FourStar;
    static String[] ThreeStar;
    static String[] AllStar;

    public static String[] getLimit() {
        return Limit;
    }

    public static void setLimit(String[] limit) {
        Limit = limit;
    }

    public static String[] getLimitSpring() {
        return LimitSpring;
    }

    public static void setLimitSpring(String[] limitSpring) {
        LimitSpring = limitSpring;
    }

    public static String[] getLimitSummer() {
        return LimitSummer;
    }

    public static void setLimitSummer(String[] limitSummer) {
        LimitSummer = limitSummer;
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
        int stringLength = 0;
        AllStar = new String[Limit.length + LimitSpring.length + LimitSummer.length + SixStar.length + FiveStar.length + FourStar.length + ThreeStar.length];
        System.arraycopy(Limit, 0, AllStar, stringLength, Limit.length);
        stringLength += Limit.length;
        System.arraycopy(LimitSpring, 0, AllStar, stringLength, LimitSpring.length);
        stringLength += LimitSpring.length;
        System.arraycopy(LimitSummer, 0, AllStar, stringLength, LimitSummer.length);
        stringLength += LimitSummer.length;
        System.arraycopy(SixStar, 0, AllStar, stringLength, SixStar.length);
        stringLength += SixStar.length;
        System.arraycopy(FiveStar, 0, AllStar, stringLength, FiveStar.length);
        stringLength += FiveStar.length;
        System.arraycopy(FourStar, 0, AllStar, stringLength, FourStar.length);
        stringLength += FourStar.length;
        System.arraycopy(ThreeStar, 0, AllStar, stringLength, ThreeStar.length);
    }
}
