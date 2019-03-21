package acezhe;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    @NonNull
    String username;
    @NonNull
    String password;

    public String getSalt(){
        return username+password;
    }
}
