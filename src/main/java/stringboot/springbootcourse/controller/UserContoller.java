package stringboot.springbootcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stringboot.springbootcourse.exception.WrongIdException;
import stringboot.springbootcourse.model.UserDTO;
import stringboot.springbootcourse.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserContoller {

    @Autowired
    UserService userService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public UserDTO registry(@RequestBody UserDTO userDTO){
        if (idExist(userDTO))
            throw new WrongIdException("Taki user już istnieje");
        System.out.println("/user/registry: " + userDTO.getFirstName() + " " + userDTO.getLastName());
        return userService.createUser(userDTO);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public UserDTO edit(@RequestBody UserDTO userDTO){
        if (!idExist(userDTO))
            throw new WrongIdException(("Taki user NIE istnieje"));
        else return userService.editUser(userDTO);
    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public UserDTO confirm(@PathVariable(value = "id") Long id){

        System.out.println("metoda: confirm(id)");
        return new UserDTO();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public UserDTO add(@RequestBody UserDTO userDTO){
        if (idExist(userDTO))
            throw new WrongIdException(("Taki user już istnieje"));
        else return userService.createUser(userDTO);
    }

    private boolean idExist(UserDTO userDTO){
        return userDTO.getId() != null;
    }

}
