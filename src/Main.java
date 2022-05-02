import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author XLCX_
 */
public class Main {
    static void menu() {
        System.out.print("\033[37m");
        System.out.println("抽卡模拟器");
        System.out.println("卡池:" + GetUp.getTitle());
        System.out.println("本期UP:");

        if (GetOperator.getUpSix().length != 0) {
            System.out.print("\033[31m六星:");
            if (GetOperator.isLimit()) {
                System.out.print(GetOperator.getLimitOperator()[GetOperator.getUpLimit()] + "[限定]");
            }
            for (int i = 0; i < GetOperator.getUpSix().length; i++) {
                System.out.print(Operator.getSixStar()[GetOperator.getUpSix()[i]]);
                if (i == GetOperator.getUpSix().length - 1) {
                    System.out.println("(占6★出率的" + GetOperator.getProbability() + "%)");
                } else {
                    System.out.print(",");
                }
            }
        }

        if (GetOperator.getUpFive().length != 0) {
            System.out.print("\033[33m五星:");
            for (int i = 0; i < GetOperator.getUpFive().length; i++) {
                System.out.print(Operator.getFiveStar()[GetOperator.getUpFive()[i]]);
                if (i == GetOperator.getUpFive().length - 1) {
                    System.out.println("(占5★出率的50%)");
                } else {
                    System.out.print(",");
                }
            }
        }

        if (GetOperator.getUpFour().length != 0) {
            System.out.print("\033[35m四星:");
            for (int i = 0; i < GetOperator.getUpFour().length; i++) {
                System.out.print(Operator.getFourStar()[GetOperator.getUpFour()[i]]);
                if (i == GetOperator.getUpFour().length - 1) {
                    System.out.println(("(占4★出率的50%)"));
                } else {
                    System.out.print(",");
                }
            }
        }

        System.out.println("\033[31m★★★★★★:2%");
        System.out.println("\033[33m★★★★★:8%");
        System.out.println("\033[35m★★★★:50%");
        System.out.println("\033[37m★★★:40%");
    }

    static String[] readFile(String fileName) {//从文件中加载干员
        ArrayList<String> temp = new ArrayList<>();
        File file = new File("res/Operator/" + fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String next = bufferedReader.readLine();
                if (next == null) {
                    break;
                }
                temp.add(next);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp.toArray(new String[0]);
    }

    /**
     * 这里写的很烂，但是我懒得改了
     */
    static void loadLimitOperator() {
        ArrayList<String> tempLimit = new ArrayList<>();
        ArrayList<String> tempLimitSpring = new ArrayList<>();
        ArrayList<String> tempLimitSummer = new ArrayList<>();
        File file = new File("res/Operator/LimitSixStar");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String next = bufferedReader.readLine();
                if (next == null) {
                    break;
                }
                if (next.contains("春节")) {
                    tempLimitSpring.add(next.replace(",春节", ""));
                }
                if (next.contains("庆典")) {
                    tempLimit.add(next.replace(",庆典", ""));
                }
                if (next.contains("夏日")) {
                    tempLimitSummer.add(next.replace(",夏日", ""));
                }
            }
            Operator.setLimitSpring(tempLimitSpring.toArray(new String[0]));
            Operator.setLimit(tempLimit.toArray(new String[0]));
            Operator.setLimitSummer(tempLimitSummer.toArray(new String[0]));
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadOperator() {
        loadLimitOperator();
        Operator.setSixStar(readFile("SixStar"));
        Operator.setFiveStar(readFile("FiveStar"));
        Operator.setFourStar(readFile("FourStar"));
        Operator.setThreeStar(readFile("ThreeStar"));
        Operator.setAllStar();
        //GetUp.GetFromFile();
    }

    static void probability(String type) {
        switch (type) {
            case "Standard":
                GetOperator.setActivity(false);
                GetOperator.setLimit(false);
                break;
            case "Activity":
                GetOperator.setActivity(true);
                GetOperator.setLimit(false);
                break;
            case "LimitSpring":
                GetOperator.setActivity(true);
                GetOperator.setLimit(true);
                break;
            default:
        }
    }

    static void listUp(String type) {
        Scanner in = new Scanner(System.in);
        File file = new File("res/Up/LastChoose");

        GetUp.getFromFile(type);
        for (int i = 0; i < GetUp.getGetUp().size(); i++) {
            GetUp.getGetUp().get(i).get();
        }
        int c = in.nextInt() - 1;
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(type);
            bufferedWriter.write("\n");
            bufferedWriter.write(String.valueOf(c));
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetUp.chooseUp(c);
        probability(type);
        switch (type) {
            case "LimitSpring":
                GetOperator.setLimitOperator(Operator.getLimitSpring());
                GetOperator.separate(1);
                break;
            case "Limit":
                GetOperator.setLimitOperator(Operator.getLimit());
                GetOperator.separate(2);
                break;
            case "LimitSummer":
                GetOperator.setLimitOperator(Operator.getLimitSummer());
                GetOperator.separate(1);
                break;
            default:
        }
        menu();
    }

    public static void main(String[] args) {
        loadOperator();
        File file = new File("res/Up/LastChoose");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = bufferedReader.readLine();
            int i = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();
            fileReader.close();
            GetUp.getFromFile(s);
            GetUp.chooseUp(i);
            probability(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetOperator.setProbability();
        Scanner in = new Scanner(System.in);
        menu();

        while (true) {
            if (!Headhunt.isFirstFiveYes()) {
                System.out.println(Headhunt.getFirstFive() + "次内寻访必得5★以上干员");
            }
            System.out.println("1.寻访一次");
            System.out.println("2.寻访十次");
            System.out.println("3.选择卡池");
            System.out.println("4.查看未出六星次数");
            System.out.println("5.查看已招募干员");
            System.out.println("6.清除寻访记录");
            System.out.println("0.退出");
            int i = in.nextInt();

            switch (i) {
                case 1:
                    new Headhunt();
                    break;
                case 2:
                    int ten = 10;
                    for (int j = 0; j < ten; j++) {
                        new Headhunt();
                    }
                    break;
                case 3:
                    System.out.println("1.常驻标准寻访卡池");
                    System.out.println("2.限时标准寻访卡池");
                    System.out.println("3.限时限定寻访卡池");
                    System.out.print("输入选项:");
                    int j = in.nextInt();
                    switch (j) {
                        case 1:
                            listUp("Standard");
                            break;
                        case 2:
                            listUp("Activity");
                            break;
                        case 3:
                            System.out.println("1.春节限定寻访卡池");
                            System.out.println("2.庆典限定寻访卡池");
                            System.out.println("3.夏日限定寻访卡池");
                            System.out.print("输入选项:");
                            int k = in.nextInt();
                            switch (k) {
                                case 1:
                                    listUp("LimitSpring");
                                    break;
                                case 2:
                                    listUp("Limit");
                                    break;
                                case 3:
                                    listUp("LimitSummer");
                                    break;
                                default:
                            }
                            break;
                        default:
                    }
                    GetOperator.setProbability();
                    break;
                case 4:
                    System.out.println("当前已有 " + Headhunt.getLastSix() + " 次未出六星");
                    break;
                case 5:
                    HeadhuntRecord.ShowRecord();
                    break;
                case 6:
                    Headhunt.setFirstFive(10);
                    Headhunt.setFirstFiveYes(false);
                    Headhunt.setLastSix(0);
                    Headhunt.setHeadhuntTime(0);
                    HeadhuntRecord.getRecord().clear();
                    break;
                case 0:
                    System.exit(0);
                default:
            }

            System.out.print("\033[37m");
            System.out.println("已招募 " + Headhunt.getHeadhuntTime() + " 次");
            if (Headhunt.getLastSix() < 50) {
                System.out.println("当前六星招募概率: 2%");
            } else {
                System.out.println("当前六星招募概率: " + ((Headhunt.getLastSix()-50)*2+4) + "%");
            }
        }
    }
}
