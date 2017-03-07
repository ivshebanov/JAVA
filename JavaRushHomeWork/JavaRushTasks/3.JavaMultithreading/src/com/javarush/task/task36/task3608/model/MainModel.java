package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Администратор on 06.03.2017.
 */
public class MainModel implements Model {

    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(getAllUsers());
        modelData.setUsers(userService.getAllDeletedUsers());
    }

    public void loadUserById(long userId) {
        modelData.setUsers(getAllUsers());
        modelData.setActiveUser(userService.getUsersById(userId));
//        modelData.setUsers(getAllUsers());

    }

    public void deleteUserById(long id) {
//        modelData.setUsers(getAllUsers());
//        modelData.setActiveUser(userService.deleteUser(id));
//        modelData.setUsers(getAllUsers());
//        userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
        userService.deleteUser(id);
        modelData.setActiveUser(null);
//        modelData.setUsers(getAllUsers());


//        modelData.setUsers(getAllUsers());
//        modelData.setActiveUser(userService.deleteUser(id));

    }

    private List<User> getAllUsers() {
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
    }
}
