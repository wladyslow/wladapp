package application.Utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverterImp implements StringToDateConverter {

    public Date convertStringToDate(String dateString) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
