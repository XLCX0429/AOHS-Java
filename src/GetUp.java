import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class GetUp {
    static String Title;

    public static String getTitle() {
        return Title;
    }

    static void GetFromFile() {
        File file = new File("res/Up/Standard");
        String title = null;
        String UpSix = null;
        String UpFive = null;
        boolean TextStart = false;
        String Temp;
        ArrayList<Integer> Up = new ArrayList<>();
        int[] up;

        ArrayList<String> textList = new ArrayList<>();

        /*try {
            if (!file.exists()) {
            file.createNewFile();
        }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i : GetOperator.getUpSix()) bufferedWriter.write(Integer.toString(i));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            title = bufferedReader.readLine();
            UpSix = bufferedReader.readLine();
            UpFive = bufferedReader.readLine();

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Objects.requireNonNull(title).length(); i++) {
            if (title.charAt(i) == ' ') TextStart = true;
            if (TextStart && title.charAt(i) != ' ') textList.add(String.valueOf(title.charAt(i)));
            if (i == title.length() - 1) {
                TextStart = false;
                Temp = String.join("", textList);
                textList.clear();
                Title = Temp;
            }
        }
        for (int i = 0; i < Objects.requireNonNull(UpSix).length(); i++) {
            if (UpSix.charAt(i) == ' ') TextStart = true;
            if (UpSix.charAt(i) == ',') {
                TextStart = false;
                Temp = String.join("", textList);
                textList.clear();
                for (int j = 0; j < Operator.getSixStar().length; j++) {
                    if (Temp.equals(Operator.getSixStar()[j])) Up.add(j);
                }
            }
            if (TextStart && UpSix.charAt(i) != ' ') textList.add(String.valueOf(UpSix.charAt(i)));
            if (i == UpSix.length() - 1) {
                TextStart = false;
                Temp = String.join("", textList);
                textList.clear();
                for (int j = 0; j < Operator.getSixStar().length; j++) {
                    if (Temp.equals(Operator.getSixStar()[j])) Up.add(j);
                }
            }
        }
        up = new int[Up.size()];
        for (int i = 0; i < Up.size(); i++) up[i] = Up.get(i);
        GetOperator.setUpSix(up);
        Up.clear();

        for (int i = 0; i < Objects.requireNonNull(UpFive).length(); i++) {
            if (UpFive.charAt(i) == ' ') TextStart = true;
            if (UpFive.charAt(i) == ',') {
                TextStart = false;
                Temp = String.join("", textList);
                textList.clear();
                for (int j = 0; j < Operator.getFiveStar().length; j++) {
                    if (Temp.equals(Operator.getFiveStar()[j])) Up.add(j);
                }
            }
            if (TextStart && UpFive.charAt(i) != ' ') textList.add(String.valueOf(UpFive.charAt(i)));
            if (i == UpFive.length() - 1) {
                TextStart = false;
                Temp = String.join("", textList);
                textList.clear();
                for (int j = 0; j < Operator.getFiveStar().length; j++) {
                    if (Temp.equals(Operator.getFiveStar()[j])) Up.add(j);
                }
            }
        }
        up = new int[Up.size()];
        for (int i = 0; i < Up.size(); i++) up[i] = Up.get(i);
        GetOperator.setUpFive(up);
        Up.clear();
    }
}
