package com.henryxi.thrift.maven;



import com.henryxi.thrift.userserver.User;
import com.henryxi.thrift.userserver.UserService;
import org.apache.thrift.TException;

public class UserServiceImpl implements UserService.Iface {
    @Override
    public User find() throws TException {
        User user = new User();
        user.setName("HenryXi");
        user.setAge(27);
        return user;
    }
}