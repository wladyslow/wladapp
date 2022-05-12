package application.Utils;

import application.entities.Cargo;
import application.enums.LoadingWindowStatus;
import application.enums.LoadingWindowType;
import application.dto.*;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateTester {


    public static void main(String[] args) {
        YearMonth yearMonth = YearMonth.of(2022,5);
        YearMonth nowYM = YearMonth.now();
        System.out.println(nowYM);
        System.out.println(yearMonth);
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
        Date loadDate = new Date();
        String myDate = sdf.format(loadDate);
        String[]array = myDate.split("-");
        System.out.println("_____________________");
        YearMonth myDateYM = YearMonth.of(Integer.parseInt(array[0]),Integer.parseInt(array[1]));
        System.out.println(myDateYM);
        System.out.println((myDateYM.equals(nowYM)));
        System.out.println((myDateYM.equals(yearMonth)));
        System.out.println("________________________");
        List<LoadingWindowStatus> loadingWindowStatusList = new ArrayList<LoadingWindowStatus>(Arrays.asList(LoadingWindowStatus.values()));
        loadingWindowStatusList.stream().forEach(c-> System.out.println(c));
    }
}
