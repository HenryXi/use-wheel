namespace java com.henryxi.thrift.userserver

    typedef i32 int
    typedef User user

    service UserService {
            user find();
    }


    struct User{
        string name;
        int age;
    }