import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GetUp {
    static String Title;
    static ArrayList<Up> getUp = new ArrayList<>();

    public static ArrayList<Up> getGetUp() {
        return getUp;
    }

    public static String getTitle() {
        return Title;
    }

    static void GetFromFile(String string) {//从文件中获取信息
        File file = new File("res/Up/" + string);
        String Line;
        String no = null;
        String title = null;
        String UpSix = null;
        String UpFive = null;
        String UpFour = null;
        String LastSix = null;
        String LastFive = null;
        String LastFour = null;
        String LastThree = null;
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
        getUp.clear();
        for (String s : LineList) { //读取文件中每一行的信息
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
                        case 4:
                            UpFour = Temp;
                            break;
                        case 5:
                            LastSix = Temp;
                            break;
                        case 6:
                            LastFive = Temp;
                            break;
                        case 7:
                            LastFour = Temp;
                            break;
                        case 8:
                            LastThree = Temp;
                            break;
                    }
                    object++;
                }
            }
            getUp.add(new Up(no, title, UpSix, UpFive, UpFour, LastSix, LastFive, LastFour, LastThree));
        }
    }

    static void ChooseUp(int n) {
        Title = getUp.get(n).getTitle();
        String UpSix = getUp.get(n).getUpSix();
        String UpFive = getUp.get(n).getUpFive();
        String UpFour = getUp.get(n).getUpFour();
        ArrayList<String> textList = new ArrayList<>();
        String Temp;
        ArrayList<Integer> Up = new ArrayList<>();
        int[] up;
        int LastSix;
        int LastFive;
        int LastFour;
        int LastThree;

        for (int i = 0; i < UpSix.length(); i++) {
            if (UpSix.charAt(i) != ',') textList.add(String.valueOf(UpSix.charAt(i)));
            if (UpSix.charAt(i) == ',' || i == UpSix.length() - 1) {
                Temp = String.join("", textList);
                textList.clear();
                for (int k = 0; k < Operator.getSixStar().length; k++) {
                    if (Temp.equals(Operator.getSixStar()[k])) Up.add(k);
                }
            }
        }
        up = new int[Up.size()];
        for (int i = 0; i < Up.size(); i++) up[i] = Up.get(i);
        GetOperator.setUpSix(up);
        Up.clear();

        for (int i = 0; i < UpFive.length(); i++) {
            if (UpFive.charAt(i) != ',') textList.add(String.valueOf(UpFive.charAt(i)));
            if (UpFive.charAt(i) == ',' || i == UpFive.length() - 1) {
                Temp = String.join("", textList);
                textList.clear();
                for (int k = 0; k < Operator.getFiveStar().length; k++) {
                    if (Temp.equals(Operator.getFiveStar()[k])) Up.add(k);
                }
            }
        }
        up = new int[Up.size()];
        for (int i = 0; i < Up.size(); i++) up[i] = Up.get(i);
        GetOperator.setUpFive(up);
        Up.clear();

        for (int i = 0; i < UpFour.length(); i++) {
            if (UpFour.charAt(i) != ',') textList.add(String.valueOf(UpFour.charAt(i)));
            if (UpFour.charAt(i) == ',' || i == UpFour.length() - 1) {
                Temp = String.join("", textList);
                textList.clear();
                for (int k = 0; k < Operator.getFourStar().length; k++) {
                    if (Temp.equals(Operator.getFourStar()[k])) Up.add(k);
                }
            }
        }
        up = new int[Up.size()];
        for (int i = 0; i < Up.size(); i++) up[i] = Up.get(i);
        GetOperator.setUpFour(up);
        Up.clear();

        //若干员界限值为空，则默认为全部
        if (Objects.equals(getUp.get(n).getLastSix(), "")) LastSix = Operator.getSixStar().length;
        else LastSix = Integer.parseInt(getUp.get(n).getLastSix());

        if (Objects.equals(getUp.get(n).getLastFive(), "")) LastFive = Operator.getFiveStar().length;
        else LastFive = Integer.parseInt(getUp.get(n).getLastFive());

        if (Objects.equals(getUp.get(n).getLastFour(), "")) LastFour = Operator.getFourStar().length;
        else LastFour = Integer.parseInt(getUp.get(n).getLastFour());

        if (Objects.equals(getUp.get(n).getLastThree(), "")) LastThree = Operator.getThreeStar().length;
        else LastThree = Integer.parseInt(getUp.get(n).getLastThree());
        //将读取的数据导入
        GetOperator.setLastSix(LastSix);
        GetOperator.setLastFive(LastFive);
        GetOperator.setLastFour(LastFour);
        GetOperator.setLastThree(LastThree);
    }
}
