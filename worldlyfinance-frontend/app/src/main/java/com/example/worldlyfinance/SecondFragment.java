package com.example.worldlyfinance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Spinner mySpinner1 = (Spinner) getView().findViewById(R.id.spinner);
        final Spinner mySpinner2 = (Spinner)getView().findViewById(R.id.spinner2);
        final EditText numInput = (EditText)getView().findViewById(R.id.input);
        numInput.setText("0");
        final TextView tview = (TextView)getView().findViewById(R.id.output);
        view.findViewById(R.id.convert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curr1 = mySpinner1.getSelectedItem().toString();
                String curr2 = mySpinner2.getSelectedItem().toString();
               double num = Double.valueOf(numInput.getText().toString());
              tview.setText(Double.toString(convert(curr1, curr2, num)));
            }
        });
    }
    public static int findIndex(String s) {
        String[] list = {"Austria", "Belgium", "China", "Cyprus", "Estonia",
                "Finland", "France", "Germany", "Greece", "Ireland", "Italy", "Japan",
                "Latvia", "Lithuania", "Luxembourg", "Malta", "Mexico", "the Netherlands",
                "Portugal", "Slovakia", "Slovenia", "South Korea ", "Spain", "United Kingdom",
                "United States"};
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals(s)){
                return i;
            }
        }
        return -1;//not found//index of x
    }

    public static double convert(String w, String z, double input)
    {
        int x = findIndex(w);
        int y = findIndex(z);
        char[] currency = {'e', 'e', 'c', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e',
                'j', 'e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'e', 'w', 'e', 's', 'd'};
        if (currency[x] == currency[y]) return (int) input;
        else if (currency[x] == 'd') {
            if (currency[y] == 'e') return dollarToEuro(input);
            else if (currency[y] == 'p') return dollarToPeso(input);
            else if (currency[y] == 'j') return dollarToJapaneseYen(input);
            else if (currency[y] == 'w') return dollarToSouthKoreanWon(input);
            else if (currency[y] == 'c') return dollarToChineseYuan(input);
            else return dollarToPoundSterling(input);
        } else if (currency[x] == 'e') {
            if (currency[y] == 'd') return eurosToDollar(input);
            else if (currency[y] == 'p') return eurosToPeso(input);
            else if (currency[y] == 'j') return eurosToJapaneseYen(input);
            else if (currency[y] == 'w') return eurosToSouthKoreanWon(input);
            else if (currency[y] == 'c') return eurosToChineseYuan(input);
            else return eurosToPoundSterling(input);
        } else if (currency[x] == 'p') {
            if (currency[y] == 'd') return pesosToDollar(input);
            else if (currency[y] == 'e') return pesosToEuro(input);
            else if (currency[y] == 'j') return pesosToJapaneseYen(input);
            else if (currency[y] == 'w') return pesosToSouthKoreanWon(input);
            else if (currency[y] == 'c') return pesosToChineseYuan(input);
            else return pesosToPoundSterling(input);
        } else if (currency[x] == 'j') {
            if (currency[y] == 'd') return japaneseYenToDollar(input);
            else if (currency[y] == 'e') return japaneseYenToEuro(input);
            else if (currency[y] == 'p') return japaneseYenToPesos(input);
            else if (currency[y] == 'w') return japaneseYenToSouthKoreanWon(input);
            else if (currency[y] == 'c') return japaneseYenToChineseYuan(input);
            else return japaneseYenToPoundSterling(input);
        } else if (currency[x] == 'w') {
            if (currency[y] == 'd') return southKoreanWonToDollar(input);
            else if (currency[y] == 'e') return southKoreanWonToEuro(input);
            else if (currency[y] == 'p') return southKoreanWonToPesos(input);
            else if (currency[y] == 'j') return southKoreanWonToJapaneseYen(input);
            else if (currency[y] == 'c') return southKoreanWonToChineseYuan(input);
            else return southKoreanWonToPoundSterling(input);
        } else if (currency[x] == 'c') {
            if (currency[y] == 'd') return chineseYuanToDollar(input);
            else if (currency[y] == 'e') return chineseYuanToEuro(input);
            else if (currency[y] == 'p') return chineseYuanToPesos(input);
            else if (currency[y] == 'w') return chineseYuanToSouthKoreanWon(input);
            else if (currency[y] == 'j') return chineseYuanToJapaneseYen(input);
            else return chineseYuanToPoundSterling(input);
        } else if (currency[x] == 's') {
            if (currency[y] == 'd') return poundSterlingToDollar(input);
            else if (currency[y] == 'e') return poundSterlingToEuro(input);
            else if (currency[y] == 'p') return poundSterlingToPesos(input);
            else if (currency[y] == 'w') return poundSterlingToSouthKoreanWon(input);
            else if (currency[y] == 'c') return poundSterlingToChineseYuan(input);
            return poundSterlingToJapaneseYen(input);
        }
        return -1;
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
