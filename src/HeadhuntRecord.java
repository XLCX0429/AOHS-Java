import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class HeadhuntRecord {
    static ArrayList<String> Record = new ArrayList<>();
    static ArrayList<String> SixStar = new ArrayList<>();
    static ArrayList<String> FiveStar = new ArrayList<>();
    static ArrayList<String> FourStar = new ArrayList<>();
    static ArrayList<String> ThreeStar = new ArrayList<>();

    public static ArrayList<String> getRecord() {
        return Record;
    }

    public void setRecord(ArrayList<String> record) {
        Record = record;
    }

    static void Classification() {
        for (String s : Record) {
            int i = 0;
            while (!Objects.equals(s, Operator.AllStar[i])) {
                i++;
            }
            if (i < Operator.getSixStar().length) SixStar.add(s);
            else if (i < Operator.getSixStar().length + Operator.getFiveStar().length) FiveStar.add(s);
            else if (i < Operator.getSixStar().length + Operator.getFiveStar().length
                    + Operator.getFourStar().length) FourStar.add(s);
            else ThreeStar.add(s);
        }
    }
    static void ShowRecord() {
        SixStar.clear();
        FiveStar.clear();
        FourStar.clear();
        ThreeStar.clear();
        Classification();
        ArrayList<String> Temp = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0: {
                    Temp = (ArrayList<String>) SixStar.clone();
                    if (Temp.size() != 0){
                        System.out.print("\033[31m");
                        System.out.println("★★★★★★:");
                    }
                    break;
                }
                case 1: {
                    Temp = (ArrayList<String>) FiveStar.clone();
                    if (Temp.size() != 0){
                        System.out.print("\033[33m");
                        System.out.println("★★★★★:");
                    }
                    break;
                }
                case 2: {
                    Temp = (ArrayList<String>) FourStar.clone();
                    if (Temp.size() != 0){
                        System.out.print("\033[35m");
                        System.out.println("★★★★:");
                    }
                    break;
                }
                case 3: {
                    Temp = (ArrayList<String>) ThreeStar.clone();
                    if (Temp.size() != 0){
                        System.out.print("\033[37m");
                        System.out.println("★★★:");
                    }
                    break;
                }
            }
            Collections.sort(Temp);

            for (int j = 0; j < Temp.size(); j++) {
                System.out.print(Temp.get(j));
                if (j % 5 == 4 || j == Temp.size() - 1) System.out.println();
                else System.out.print(" ");
            }
        }
    }
}
