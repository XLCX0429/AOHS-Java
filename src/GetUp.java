import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetUp {
    static String Title;
    static ArrayList<Up> getUp = new ArrayList<>();

    public static ArrayList<Up> getGetUp() {
        return getUp;
    }

    public static String getTitle() {
        return Title;
    }

    static void GetFromFile() {
        File file = new File("res/Up/Standard");
        String Line;
        String no = null;
        String title = null;
        String UpSix = null;
        String UpFive = null;
        String Temp;
        ArrayList<String> LineList = new ArrayList<>();

        ArrayList<String> textList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            Line = bufferedReader.readLine();
            while (Line != null) {
                LineList.add(Line);
                Line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(LineList);
        for (String s : LineList) {
            int object = 0;
            Line = s;
            for (int i = 0; i < Line.length(); i++) {
                if (Line.charAt(i) != ';') textList.add(String.valueOf(Line.charAt(i)));
                if (Line.charAt(i) == ';' || i == Line.length() - 1) {
                    Temp = String.join("", textList);
                    textList.clear();
                    switch (object) {
                        case 0:
                            no = Temp;
                            break;
                        case 1:
                            title = Temp;
                            break;
                        case 2:
                            UpSix = Temp;
                            break;
                        case 3:
                            UpFive = Temp;
                            break;
                    }
                    object++;
                }
            }
            getUp.add(new Up(no, title, UpSix, UpFive));
        }
    }

    static void ChooseUp(int i) {
        Title = getUp.get(i).getTitle();
        String UpSix = getUp.get(i).getUpSix();
        String UpFive = getUp.get(i).getUpFive();
        ArrayList<String> textList = new ArrayList<>();
        String Temp;
        ArrayList<Integer> Up = new ArrayList<>();
        int[] up;

        for (int j = 0; j < UpSix.length(); j++) {
            if (UpSix.charAt(j) != ',') textList.add(String.valueOf(UpSix.charAt(j)));
            if (UpSix.charAt(j) == ',' || j == UpSix.length() - 1) {
                Temp = String.join("", textList);
                textList.clear();
                for (int k = 0; k < Operator.getSixStar().length; k++) {
                    if (Temp.equals(Operator.getSixStar()[k])) Up.add(k);
                }
            }
        }
        up = new int[Up.size()];
        for (int j = 0; j < Up.size(); j++) up[j] = Up.get(j);
        GetOperator.setUpSix(up);
        Up.clear();

        for (int j = 0; j < UpFive.length(); j++) {
            if (UpFive.charAt(j) != ',') textList.add(String.valueOf(UpFive.charAt(j)));
            if (UpFive.charAt(j) == ',' || j == UpFive.length() - 1) {
                Temp = String.join("", textList);
                textList.clear();
                for (int k = 0; k < Operator.getFiveStar().length; k++) {
                    if (Temp.equals(Operator.getFiveStar()[k])) Up.add(k);
                }
            }
        }
        up = new int[Up.size()];
        for (int j = 0; j < Up.size(); j++) up[j] = Up.get(j);
        GetOperator.setUpFive(up);
        Up.clear();
    }
}
