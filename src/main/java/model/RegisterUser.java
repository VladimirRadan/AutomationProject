package model;

import com.github.javafaker.Faker;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RegisterUser {


    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;

    Faker faker = new Faker(new Locale("us"));

    public RegisterUser() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.phone = faker.phoneNumber().phoneNumber();
        this.password = "123456789";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }



    public static List<RegisterUser> getDataFromJson(){
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/src/test/resources/user.json"));
        }catch (IOException e){
            e.printStackTrace();
        }
        ArrayList<RegisterUser> list = new Gson().fromJson(reader, new TypeToken<List<RegisterUser>>(){
        }.getType());
        return list;
    }
}
