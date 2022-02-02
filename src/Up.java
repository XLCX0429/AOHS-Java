import java.util.Objects;

public class Up {
    String no;
    String title;
    String UpSix;
    String UpFive;
    String UpFour;
    String LastSix;
    String LastFive;
    String LastFour;
    String LastThree;

    public String getTitle() {
        return title;
    }

    public String getUpSix() {
        return UpSix;
    }

    public String getUpFive() {
        return UpFive;
    }

    public String getUpFour() {
        return UpFour;
    }

    public String getLastSix() {
        return LastSix;
    }

    public String getLastFive() {
        return LastFive;
    }

    public String getLastFour() {
        return LastFour;
    }

    public String getLastThree() {
        return LastThree;
    }

    Up(String no, String title, String UpSix, String UpFive, String UpFour, String LastSix, String LastFive, String LastFour, String LastThree) {
        this.no = no;
        this.title = title;
        this.UpSix = UpSix;
        this.UpFive = UpFive;
        this.UpFour = UpFour;
        this.LastSix = LastSix;
        this.LastFive = LastFive;
        this.LastFour = LastFour;
        this.LastThree = LastThree;
    }

    void get() {
        if (!Objects.equals(no, "")) System.out.print("\033[37m卡池" + no);
        if (!Objects.equals(title, "")) System.out.print("    卡池名称:" + title);
        if (!Objects.equals(UpSix, "")) System.out.print("    \033[31m六星UP:" + UpSix);
        if (!Objects.equals(UpFive, "")) System.out.print("    \033[33m五星UP:" + UpFive);
        if (!Objects.equals(UpFour, "")) System.out.print("    \033[35m四星UP:" + UpFour);
        System.out.println();
    }
}
