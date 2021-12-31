public class Up {
    String no;
    String title;
    String UpSix;
    String UpFive;

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

    Up(String no, String title, String UpSix, String UpFive) {
        this.no = no;
        this.title = title;
        this.UpSix = UpSix;
        this.UpFive = UpFive;
    }
    void get() {
        System.out.println(no + "    " + title + "    " + UpSix + "    " + UpFive);
    }
}
