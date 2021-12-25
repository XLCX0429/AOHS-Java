import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {//从文件中加载干员
    static String[] ReadFile(String fileName) {
        ArrayList<String> Temp = new ArrayList<>();
        File file = new File("res/Operator/" + fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String next = bufferedReader.readLine();
                if (next == null) break;
                Temp.add(next);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Temp.toArray(new String[0]);
    }

    static void LoadOperator() {
        Operator.setSixStar(ReadFile("SixStar"));
        Operator.setFiveStar(ReadFile("FiveStar"));
        Operator.setFourStar(ReadFile("FourStar"));
        Operator.setThreeStar(ReadFile("ThreeStar"));
        Operator.setAllStar();
    }

    public static void main(String[] args) {
        LoadOperator();

        Scanner in = new Scanner(System.in);

        System.out.print("\033[37m");
        System.out.println("抽卡模拟器");
        System.out.println("卡池:");
        System.out.println("本期UP:");
        System.out.print("六星:");
        for (int i = 0; i < GetOperator.getUpSix().length; i++) {
            System.out.print(Operator.getSixStar()[GetOperator.getUpSix()[i]]);
            if (i == GetOperator.getUpSix().length - 1) System.out.println();
            else System.out.print(",");
        }
        System.out.print("五星:");
        for (int i = 0; i < GetOperator.getUpFive().length; i++) {
            System.out.print(Operator.getFiveStar()[GetOperator.getUpFive()[i]]);
            if (i == GetOperator.getUpFive().length - 1) System.out.println();
            else System.out.print(",");
        }
        System.out.println("★★★★★★:2%");
        System.out.println("★★★★★:8%");
        System.out.println("★★★★:50%");
        System.out.println("★★★:40%");

        while (true) {
            if (!Headhunt.isFirstFiveYes()) System.out.println(Headhunt.getFirstFive() + "次内寻访必得5★以上干员");
            System.out.println("1.寻访一次");
            System.out.println("2.寻访十次");
            System.out.println("3.查看未出六星次数");
            System.out.println("4.查看已招募干员");
            System.out.println("5.清除寻访记录");
            System.out.println("0.退出");
            int i = in.nextInt();

            switch (i) {
                case 1:
                    new Headhunt();
                    break;
                case 2:
                    for (int j = 0; j < 10; j++) new Headhunt();
                    break;
                case 3:
                    System.out.println("当前已有 " + Headhunt.getLastSix() + " 次未出六星");
                    break;
                case 4:
                    HeadhuntRecord.ShowRecord();
                    break;
                case 5:
                    Headhunt.setFirstFive(10);
                    Headhunt.setFirstFiveYes(false);
                    Headhunt.setLastSix(0);
                    Headhunt.setHeadhuntTime(0);
                    HeadhuntRecord.getRecord().clear();
                    break;
                case 0:
                    System.exit(0);
            }

            System.out.print("\033[37m");
            System.out.println("已招募 " + Headhunt.getHeadhuntTime() + " 次");
            if (Headhunt.getLastSix() < 50) System.out.println("当前六星招募概率: 2%");
            else System.out.println("当前六星招募概率: " + ((Headhunt.getLastSix()-50)*2+4) + "%");
        }
    }
}
