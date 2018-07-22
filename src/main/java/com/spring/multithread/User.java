package com.spring.multithread;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by adnenehamdouni on 19/07/2018.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
@Getter
@Setter
@NoArgsConstructor // <--- THIS use LOMBOK to generate No Args Construtor
public class User {

    private String name;
    private String blog;

    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }

}
