package pl.jakub.orderorganizer.model.user;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ADMIN"), USER_SERVICE("USER_SERVICE"), USER_COOK("USER_COOK");

    UserRole(String name){
        this.name=name;
    }

    private String name;
}
