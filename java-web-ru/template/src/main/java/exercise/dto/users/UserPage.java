package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Getter
public class UserPage {
    private User userPage;
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
// END
