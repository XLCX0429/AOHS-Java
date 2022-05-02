import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author XLCX_
 */
public class GetUp {
    static String Title;
    static ArrayList<Up> getUp = new ArrayList<>();

    public static ArrayList<Up> getGetUp() {
        return getUp;
    }

    public static String getTitle() {
        return Title;
    }

    static void getFromFile(String string) {//从文件中获取信息
        File file = new File("res/Up/" + string);
        String line;
        String no = null;
        String title = null;
        String upSix = null;
        String upFive = null;
        String upFour = null;
        String lastSix = null;
        String lastFive = null;
        String lastFour = null;
        String lastThree = null;
        ArrayList<String> lineList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            line = bufferedReader.readLine();
            while (line != null) {
                lineList.add(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getUp.clear();
        //读取文件中每一行的信息
        for (String s : lineList) {
            line = s;
            String[] temp = line.split(";");
            for (int i = 0; i < temp.length; i++) {
                switch (i) {
                    case 0:
                        no = temp[i];
                        break;
                    case 1:
                        title = temp[i];
                        break;
                    case 2:
                        upSix = temp[i];
                        break;
                    case 3:
                        upFive = temp[i];
                        break;
                    case 4:
                        upFour = temp[i];
                        break;
                    case 5:
                        lastSix = temp[i];
                        break;
                    case 6:
                        lastFive = temp[i];
                        break;
                    case 7:
                        lastFour = temp[i];
                        break;
                    case 8:
                        lastThree = temp[i];
                        break;
                    default:
                }
            }
            getUp.add(new Up(no, title, upSix, upFive, upFour, lastSix, lastFive, lastFour, lastThree));
        }
    }

    static void chooseUp(int n) {
        Title = getUp.get(n).getTitle();
        String upSix = getUp.get(n).getUpSix();
        String upFive = getUp.get(n).getUpFive();
        String upFour = getUp.get(n).getUpFour();
        ArrayList<Integer> upList = new ArrayList<>();
        String[] upSixList = null;
        String[] upFiveList = null;
        String[] upFourList = null;
        if (upSix != null) {
            upSixList = upSix.split(",");
        }
        if (upFive != null) {
            upFiveList = upFive.split(",");
        }

        if (upFour != null) {
            upFourList = upFour.split(",");
        }

        int[] up;
        int lastSix, lastFive, lastFour, lastThree;

        for (String s : upSixList) {
            for (int k = 0; k < Operator.getLimit().length; k++) {
                if (s.equals(Operator.getLimit()[k])) {
                    GetOperator.setUpLimit(k);
                }
            }
            for (int k = 0; k < Operator.getLimitSpring().length; k++) {
                if (s.equals(Operator.getLimit()[k])) {
                    GetOperator.setUpLimit(k);
                }
            }
            for (int k = 0; k < Operator.getLimitSummer().length; k++) {
                if (s.equals(Operator.getLimit()[k])) {
                    GetOperator.setUpLimit(k);
                }
            }
            for (int k = 0; k < Operator.getSixStar().length; k++) {
                if (s.equals(Operator.getSixStar()[k])) {
                    upList.add(k);
                }
            }
        }

        /*for (int i = 0; i < upSix.length(); i++) {
            if (upSix.charAt(i) != ',') {
                textList.add(String.valueOf(upSix.charAt(i)));
            }
            if (upSix.charAt(i) == ',' || i == upSix.length() - 1) {
                temp = String.join("", textList);
                textList.clear();
                for (int k = 0; k < Operator.getLimit().length; k++) {
                    if (temp.equals(Operator.getLimit()[k])) {
                        upList.add(k);
                    }
                }
                for (int k = 0; k < Operator.getSixStar().length; k++) {
                    if (temp.equals(Operator.getSixStar()[k])) {
                        upList.add(k);
                    }
                }
            }
        }*/
        up = new int[upList.size()];
        for (int i = 0; i < upList.size(); i++) {
            up[i] = upList.get(i);
        }
        GetOperator.setUpSix(up);
        upList.clear();

        for (String s : upFiveList) {
            for (int k = 0; k < Operator.getFiveStar().length; k++) {
                if (s.equals(Operator.getFiveStar()[k])) {
                    upList.add(k);
                }
            }
        }

        /*for (int i = 0; i < upFive.length(); i++) {
            if (upFive.charAt(i) != ',') {
                textList.add(String.valueOf(upFive.charAt(i)));
            }
            if (upFive.charAt(i) == ',' || i == upFive.length() - 1) {
                temp = String.join("", textList);
                textList.clear();
                for (int k = 0; k < Operator.getFiveStar().length; k++) {
                    if (temp.equals(Operator.getFiveStar()[k])) {
                        upList.add(k);
                    }
                }
            }
        }*/
        up = new int[upList.size()];
        for (int i = 0; i < upList.size(); i++) {
            up[i] = upList.get(i);
        }
        GetOperator.setUpFive(up);
        upList.clear();

        for (String s : upFourList) {
            for (int k = 0; k < Operator.getFourStar().length; k++) {
                if (s.equals(Operator.getFourStar()[k])) {
                    upList.add(k);
                }
            }
        }

        /*for (int i = 0; i < upFour.length(); i++) {
            if (upFour.charAt(i) != ',') {
                textList.add(String.valueOf(upFour.charAt(i)));
            }
            if (upFour.charAt(i) == ',' || i == upFour.length() - 1) {
                temp = String.join("", textList);
                textList.clear();
                for (int k = 0; k < Operator.getFourStar().length; k++) {
                    if (temp.equals(Operator.getFourStar()[k])) {
                        upList.add(k);
                    }
                }
            }
        }*/
        up = new int[upList.size()];
        for (int i = 0; i < upList.size(); i++) {
            up[i] = upList.get(i);
        }
        GetOperator.setUpFour(up);
        upList.clear();

        //若干员界限值为空，则默认为全部
        if (Objects.equals(getUp.get(n).getLastSix(), "")/* || Objects.equals(getUp.get(n).getLastSix(), null)*/) {
            lastSix = Operator.getSixStar().length;
        } else {
            lastSix = Integer.parseInt(getUp.get(n).getLastSix());
        }

        if (Objects.equals(getUp.get(n).getLastFive(), "")/* || Objects.equals(getUp.get(n).getLastFive(), null)*/) {
            lastFive = Operator.getFiveStar().length;
        } else {
            lastFive = Integer.parseInt(getUp.get(n).getLastFive());
        }

        if (Objects.equals(getUp.get(n).getLastFour(), "")/* || Objects.equals(getUp.get(n).getLastFour(), null)*/) {
            lastFour = Operator.getFourStar().length;
        } else {
            lastFour = Integer.parseInt(getUp.get(n).getLastFour());
        }

        if (Objects.equals(getUp.get(n).getLastThree(), "")/* || Objects.equals(getUp.get(n).getLastThree(), null)*/) {
            lastThree = Operator.getThreeStar().length;
        } else {
            lastThree = Integer.parseInt(getUp.get(n).getLastThree());
        }
        //将读取的数据导入
        GetOperator.setLastSix(lastSix);
        GetOperator.setLastFive(lastFive);
        GetOperator.setLastFour(lastFour);
        GetOperator.setLastThree(lastThree);
    }
}
