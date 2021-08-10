package stringboot.springbootcourse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stringboot.springbootcourse.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserContoller {

    private List<UserDTO> userDTOS = new ArrayList<>();

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public UserDTO registry(@RequestBody UserDTO userDTO){
        userDTOS.add(userDTO);
        return userDTO;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public UserDTO edit(@RequestBody UserDTO userDTO){

        return userDTO;
    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public UserDTO confirm(@PathVariable(value = "id") Long id){

        System.out.println("metoda: confirm(id)");
        return getUser(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public UserDTO add(@RequestBody UserDTO userDTO){

        return userDTO;
    }

    private UserDTO getUser(Long id) {
        UserDTO userDTO = null;
        for (UserDTO c : userDTOS){
            if (c.getId()!=null && c.getId().equals(id)) {
                userDTO = c;
                break;
            }
        }
        if (userDTO ==null) {
            //TODO
        }

        return userDTO;
    }
}
