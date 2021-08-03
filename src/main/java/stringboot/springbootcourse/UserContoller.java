package stringboot.springbootcourse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserContoller {

    private List<User> users = new ArrayList<>();

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public User registry(@RequestBody User user){
        users.add(user);
        return user;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public User edit(@RequestBody User user){

        return user;
    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public User confirm(@PathVariable(value = "id") Long id){

        System.out.println("metoda: confirm(id)");
        return getUser(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public User add(@RequestBody User user){

        return user;
    }

    private User getUser(Long id) {
        User user = null;
        for (User c : users){
            if (c.getId()!=null && c.getId().equals(id)) {
                user = c;
                break;
            }
        }
        if (user==null) {
            //TODO
        }

        return user;
    }
}
