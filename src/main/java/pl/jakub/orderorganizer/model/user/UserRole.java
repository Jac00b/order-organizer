package pl.jakub.orderorganizer.model.user;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ADMIN"), USER_DOCTOR("USER_SERVICE"), USER_PATIENT("USER_COOK");

    UserRole(String name){
        this.name=name;
    }

    private String name;
}
