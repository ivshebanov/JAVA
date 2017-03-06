package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Администратор on 06.03.2017.
 */
public class UsersView implements View {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {

        if (!modelData.isDisplayDeletedUserList()){
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList()){
            System.out.println("All deleted users:");
        }


        for (User users : modelData.getUsers()) {
            System.out.println("\t" + users);
        }
        //System.out.println("==================================================");
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
}
