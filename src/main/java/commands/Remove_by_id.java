package commands;

import dataBase.DataBase;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;


public class Remove_by_id extends BaseCommand {

    public void execute(DataBase obj) throws IOException {
        try{
            System.out.println(super.getParameter());
            Integer a = Integer.parseInt(super.getParameter());
            var temp = obj.getCollection();
            Iterator i = temp.iterator();
            Field field = i.next().getClass().getDeclaredField("id");
            System.out.println(field);
        }catch (Exception e){
            System.out.println("Incorrect argument, command cannot be executed");
        }

    }


    public void describe() {

    }
}
