package com.unicauca.my_food.domain.menu.value_objects;
import java.time.LocalDate;
import lombok.Getter;
import java.util.UUID;
import java.time.format.DateTimeFormatter;


@Getter

public class DateMenu {
    private String id;
    private LocalDate date;

    public DateMenu() {
        this.id = UUID.randomUUID().toString(); 
        this.date = LocalDate.now(); 
    }

    public String getDateMenu(){
        if(this.date == null || this.getDate() == null)
            return "error";

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return this.getDate().format(dateFormatter);
    }   
    
}



