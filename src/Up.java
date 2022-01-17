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

    public String getNo() {
        return no;
    }

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
        System.out.println(no + "    " + title + "    " + UpSix + "    " + UpFive);
    }
}
