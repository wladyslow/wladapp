package application;

import application.dto.LoadingWindowDto;
import application.entities.LoadingWindow;
import application.mapper.LoadingWindowMapper;
import application.service.LoadingWindowService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class WlApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WlApp.class, args);
        LoadingWindowService loadingWindowService =
                context.getBean(LoadingWindowService.class);
        LoadingWindowMapper loadingWindowMapper =
                context.getBean(LoadingWindowMapper.class);
        /*LoadingWindow lw = new LoadingWindow();
        lw.setInitDate("2022-05-01");
        lw.setLoadDate("2022-05-02");
        lw.SetCustomYearMonth();
        System.out.println(lw);
        loadingWindowService.save(loadingWindowMapper.toDto(lw));*/
        String t = "02.05.2022";
        String[] loadDateStringArray = t.split("\\.");
        System.out.println(loadDateStringArray.length);
        //System.out.println(loadingWindowDtos);
        //System.out.println(loadingWindowMapper.toDtos(loadingWindowDtos));

    }
}

