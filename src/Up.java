import java.util.Objects;

/**
 * @author XLCX_
 */
public class Up {
    String no;
    String title;
    String upSix;
    String upFive;
    String upFour;
    String lastSix;
    String lastFive;
    String lastFour;
    String lastThree;

    public String getTitle() {
        return title;
    }

    public String getUpSix() {
        return upSix;
    }

    public String getUpFive() {
        return upFive;
    }

    public String getUpFour() {
        return upFour;
    }

    public String getLastSix() {
        return lastSix;
    }

    public String getLastFive() {
        return lastFive;
    }

    public String getLastFour() {
        return lastFour;
    }

    public String getLastThree() {
        return lastThree;
    }

    Up(String no, String title, String upSix, String upFive, String upFour, String lastSix, String lastFive, String lastFour, String lastThree) {
        this.no = no;
        this.title = title;
        this.upSix = upSix;
        this.upFive = upFive;
        this.upFour = upFour;
        this.lastSix = lastSix;
        this.lastFive = lastFive;
        this.lastFour = lastFour;
        this.lastThree = lastThree;
    }

    void get() {
        if (!Objects.equals(no, "")) {
            System.out.print("\033[37m卡池" + no);
        }
        if (!Objects.equals(title, "")) {
            System.out.print("    卡池名称:" + title);
        }
        if (!Objects.equals(upSix, "")) {
            System.out.print("    \033[31m六星UP:" + upSix);
        }
        if (!Objects.equals(upFive, "")) {
            System.out.print("    \033[33m五星UP:" + upFive);
        }
        if (!Objects.equals(upFour, "")) {
            System.out.print("    \033[35m四星UP:" + upFour);
        }
        System.out.println();
    }
}
