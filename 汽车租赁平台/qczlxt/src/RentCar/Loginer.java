package RentCar;

import java.io.IOException;
import java.util.List;
//encoding: UTF-8
//encoding: UTF-8
public abstract class Loginer {
    private String id;
    private String password;


    public Loginer(String id, String password) {
        super();
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Loginer user=(Loginer)obj;
        return this.getId().equals(user.getId())  &&  this.getPassword().equals(user.getPassword());
    }
    public static boolean equalsID(String ID) {
        List<User> users=Data.getUsers();
        List<Administrator> administrators=Data.getAdministrators();
        for(int i=0;i<users.size();i++) {
            if (users.get(i).getId().equals(ID))
                return false;
        }
        for(int i=0;i<administrators.size();i++) {
            if (administrators.get(i).getId().equals(ID))
                return false;
        }
        return true;
    }
    public abstract void go() throws IOException;

    public static Loginer login(Loginer loginer){
        List<User> users=Data.getUsers();
        List<Administrator> administrators=Data.getAdministrators();
        for(int i=0;i<users.size();i++) {
            //多态，users.get(i)为User对象，而User是Loginer的子类
            if(loginer.equals(users.get(i))) return users.get(i);
        }
        for(int i=0;i<administrators.size();i++) {
            //多态，administrators.get(i)为Administrators对象，而Administrators是Loginer的子类
            if(loginer.equals(administrators.get(i))) return administrators.get(i);
        }
        return null;
    }

}
