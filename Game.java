import javax.swing.*;

public class Game {
    static int x = -1, y = -1;
    static double ans;

    public static void currency1() {
        String[] list = {"Austria", "Belgium", "China", "Cyprus", "Estonia",
                "Finland", "France", "Germany", "Greece", "Ireland", "Italy", "Japan",
                "Latvia", "Lithuania", "Luxembourg", "Malta", "Mexico", "the Netherlands",
                "Portugal", "Slovakia", "Slovenia", "South Korea ", "Spain", "United Kingdom",
                "United States"};
        final JComboBox<String> dropdown1 = new JComboBox<>(list);
        x = dropdown1.getSelectedIndex();
    }

    public static void currency2() {
        String[] list = {"Austria", "Belgium", "China", "Cyprus", "Estonia",
                "Finland", "France", "Germany", "Greece", "Ireland", "Italy", "Japan",
                "Latvia", "Lithuania", "Luxembourg", "Malta", "Mexico", "the Netherlands",
                "Portugal", "Slovakia", "Slovenia", "South Korea ", "Spain", "United Kingdom",
                "United States"};
        final JComboBox<String> dropdown2 = new JComboBox<>(list);
        y = dropdown2.getSelectedIndex();
    }

    public static double generateRandom() {
        int min = 0;
        int max = 1000000;

        double random_double = Math.random() * (max - min + 1) + min;
        return Math.round(random_double);
    }

    public static void main(String[] args) {
        currency1();
        currency2();
        value();
        guess();
    }

    public static void guess() {
        JLabel submit = new JLabel("Please input a number with no commas (there is a margin of error of 5)");
        while (true) {
            //input box w/ number (userInput)
            int userInput = 1; //1 stands for the next input
            if (userInput <= ans + 5 || userInput >= ans - 5) {
                JLabel correct = new JLabel("Correct!");
                break;
            } else if (userInput < ans - 5) {
                JLabel tooLow = new JLabel("Your number was too low, try again!");
            } else {
                JLabel tooHigh = new JLabel("Your number was too high, try again!");
            }
        }
    }

    public static void value() {
        char[] currency = {'e', 'e', 'c', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e',
                'j', 'e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'e', 'w', 'e', 's', 'd'};
        double input = generateRandom();
        //output "input"
        JLabel number = new JLabel(Double.toString(input));
        if (currency[x] == currency[y]) ans = (int) input;
        else if (currency[x] == 'd') {
            if (currency[y] == 'e') ans = dollarToEuro(input);
            else if (currency[y] == 'p') ans = dollarToPeso(input);
            else if (currency[y] == 'j') ans = dollarToJapaneseYen(input);
            else if (currency[y] == 'w') ans = dollarToSouthKoreanWon(input);
            else if (currency[y] == 'c') ans = dollarToChineseYuan(input);
            else ans = dollarToPoundSterling(input);
        } else if (currency[x] == 'e') {
            if (currency[y] == 'd') ans = eurosToDollar(input);
            else if (currency[y] == 'p') ans = eurosToPeso(input);
            else if (currency[y] == 'j') ans = eurosToJapaneseYen(input);
            else if (currency[y] == 'w') ans = eurosToSouthKoreanWon(input);
            else if (currency[y] == 'c') ans = eurosToChineseYuan(input);
            else ans = eurosToPoundSterling(input);
        } else if (currency[x] == 'p') {
            if (currency[y] == 'd') ans = pesosToDollar(input);
            else if (currency[y] == 'e') ans = pesosToEuro(input);
            else if (currency[y] == 'j') ans = pesosToJapaneseYen(input);
            else if (currency[y] == 'w') ans = pesosToSouthKoreanWon(input);
            else if (currency[y] == 'c') ans = pesosToChineseYuan(input);
            else ans = pesosToPoundSterling(input);
        } else if (currency[x] == 'j') {
            if (currency[y] == 'd') ans = japaneseYenToDollar(input);
            else if (currency[y] == 'e') ans = japaneseYenToEuro(input);
            else if (currency[y] == 'p') ans = japaneseYenToPesos(input);
            else if (currency[y] == 'w') ans = japaneseYenToSouthKoreanWon(input);
            else if (currency[y] == 'c') ans = japaneseYenToChineseYuan(input);
            else ans = japaneseYenToPoundSterling(input);
        } else if (currency[x] == 'w') {
            if (currency[y] == 'd') ans = southKoreanWonToDollar(input);
            else if (currency[y] == 'e') ans = southKoreanWonToEuro(input);
            else if (currency[y] == 'p') ans = southKoreanWonToPesos(input);
            else if (currency[y] == 'j') ans = southKoreanWonToJapaneseYen(input);
            else if (currency[y] == 'c') ans = southKoreanWonToChineseYuan(input);
            else ans = southKoreanWonToPoundSterling(input);
        } else if (currency[x] == 'c') {
            if (currency[y] == 'd') ans = chineseYuanToDollar(input);
            else if (currency[y] == 'e') ans = chineseYuanToEuro(input);
            else if (currency[y] == 'p') ans = chineseYuanToPesos(input);
            else if (currency[y] == 'w') ans = chineseYuanToSouthKoreanWon(input);
            else if (currency[y] == 'j') ans = chineseYuanToJapaneseYen(input);
            else ans = chineseYuanToPoundSterling(input);
        } else if (currency[x] == 's') {
            if (currency[y] == 'd') ans = poundSterlingToDollar(input);
            else if (currency[y] == 'e') ans = poundSterlingToEuro(input);
            else if (currency[y] == 'p') ans = poundSterlingToPesos(input);
            else if (currency[y] == 'w') ans = poundSterlingToSouthKoreanWon(input);
            else if (currency[y] == 'c') ans = poundSterlingToChineseYuan(input);
            else ans = poundSterlingToJapaneseYen(input);
        }
    }

    public static double dollarToEuro(double dollars) {
        return Math.round(dollars * 0.84);
    }

    public static double dollarToPeso(double dollars) {
        return Math.round(dollars * 21.97);
    }

    public static double dollarToJapaneseYen(double dollars) {
        return Math.round(dollars * 106.59);
    }

    public static double dollarToSouthKoreanWon(double dollars) {
        return Math.round(dollars * 1187.04);
    }

    public static double dollarToChineseYuan(double dollars) {
        return Math.round(dollars * 6.95);
    }

    public static double dollarToPoundSterling(double dollars) {
        return Math.round(dollars * 0.76);
    }

    public static double eurosToDollar(double euros) {
        return Math.round(euros * 1.18);
    }

    public static double eurosToPeso(double euros) {
        return Math.round(euros * 26.01);
    }

    public static double eurosToJapaneseYen(double euros) {
        return Math.round(euros * 126.23);
    }

    public static double eurosToSouthKoreanWon(double euros) {
        return Math.round(euros * 1405.60);
    }

    public static double eurosToChineseYuan(double euros) {
        return Math.round(euros * 6.95);
    }

    public static double eurosToPoundSterling(double euros) {
        return Math.round(euros * 0.90);
    }

    public static double pesosToDollar(double pesos) {
        return Math.round(pesos * 0.045);
    }

    public static double pesosToEuro(double pesos) {
        return Math.round(pesos * 0.038);
    }

    public static double pesosToJapaneseYen(double pesos) {
        return Math.round(pesos * 4.85);
    }

    public static double pesosToSouthKoreanWon(double pesos) {
        return Math.round(pesos * 53.97);
    }

    public static double pesosToChineseYuan(double pesos) {
        return Math.round(pesos * 0.32);
    }

    public static double pesosToPoundSterling(double pesos) {
        return Math.round(pesos * 0.035);
    }

    public static double japaneseYenToDollar(double japaneseYen) {
        return Math.round(japaneseYen * 0.0094);
    }

    public static double japaneseYenToEuro(double japaneseYen) {
        return Math.round(japaneseYen * 0.0079);
    }

    public static double japaneseYenToPesos(double japaneseYen) {
        return Math.round(japaneseYen * 0.21);
    }

    public static double japaneseYenToSouthKoreanWon(double japaneseYen) {
        return Math.round(japaneseYen * 11.14);
    }

    public static double japaneseYenToChineseYuan(double japaneseYen) {
        return Math.round(japaneseYen * 0.065);
    }

    public static double japaneseYenToPoundSterling(double japaneseYen) {
        return Math.round(japaneseYen * 0.0072);
    }

    public static double southKoreanWonToDollar(double southKoreanWon) {
        return Math.round(southKoreanWon * 0.00084);
    }

    public static double southKoreanWonToEuro(double southKoreanWon) {
        return Math.round(southKoreanWon * 0.00071);
    }

    public static double southKoreanWonToPesos(double southKoreanWon) {
        return Math.round(southKoreanWon * 0.019);
    }

    public static double southKoreanWonToJapaneseYen(double southKoreanWon) {
        return Math.round(southKoreanWon * 0.090);
    }

    public static double southKoreanWonToChineseYuan(double southKoreanWon) {
        return Math.round(southKoreanWon * 0.0059);
    }

    public static double southKoreanWonToPoundSterling(double southKoreanWon) {
        return Math.round(southKoreanWon * 0.00064);
    }

    public static double chineseYuanToDollar(double chineseYuan) {
        return Math.round(chineseYuan * 0.14);
    }

    public static double chineseYuanToEuro(double chineseYuan) {
        return Math.round(chineseYuan * 0.12);
    }

    public static double chineseYuanToPesos(double chineseYuan) {
        return Math.round(chineseYuan * 3.16);
    }

    public static double chineseYuanToSouthKoreanWon(double chineseYuan) {
        return Math.round(chineseYuan * 170.79);
    }

    public static double chineseYuanToJapaneseYen(double chineseYuan) {
        return Math.round(chineseYuan * 15.34);
    }

    public static double chineseYuanToPoundSterling(double chineseYuan) {
        return Math.round(chineseYuan * 0.11);
    }

    public static double poundSterlingToDollar(double poundSterling) {
        return Math.round(poundSterling * 1.31);
    }

    public static double poundSterlingToEuro(double poundSterling) {
        return Math.round(poundSterling * 1.11);
    }

    public static double poundSterlingToPesos(double poundSterling) {
        return Math.round(poundSterling * 28.78);
    }

    public static double poundSterlingToSouthKoreanWon(double poundSterling) {
        return Math.round(poundSterling * 1553.42);
    }

    public static double poundSterlingToChineseYuan(double poundSterling) {
        return Math.round(poundSterling * 9.09);
    }

    public static double poundSterlingToJapaneseYen(double poundSterling) {
        return Math.round(poundSterling * 139.49);
    }
}
