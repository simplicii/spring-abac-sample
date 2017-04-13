package com.example;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Renato Soppelsa
 * 2017
 */
public class ShopUser extends User {

    int age;

    private Set<String> shops = new HashSet<>();

    public ShopUser(String username, String password, String... authorities) {
        super(username, password, Arrays.stream(authorities).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void addShop(String... shop) {
        shops.addAll(Arrays.asList(shop));
    }

    public Set<String> getShops() {
        return shops;
    }

    public boolean hasShop(String shop) {
        return shops.contains(shop);
    }
}
