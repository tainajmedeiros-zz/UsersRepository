package br.com.report.resources;

import br.com.report.models.User;
import br.com.report.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserResources {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Return list os users")
    @GetMapping("/users")
    public List<User> userList(){
        return userRepository.findAll();
    }

    @ApiOperation(value = "Return one user")
    @GetMapping("/user/id")
    public User user(@PathVariable(value = "id") long id){
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    /*
    @ApiOperation(value="Return List os problems")
    @GetMapping(produces = "application/json")
    public @ResponseBody
    Iterable<User> listProblems() {
        Iterable<User> problems = problemRepository.findAll();
        return problems;
    }

    @GetMapping(path = "/{problemId}")
    public ResponseEntity<?> getProblem(@PathVariable(value = "problemId") long problemId) {
        Optional<User> problem = problemRepository.findById(problemId);
        if (problem.isPresent())
            return new ResponseEntity<>(problem.get(), HttpStatus.OK);

        return new ResponseEntity<>(new ApiError(404, "Problem not found", new Date()), HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public User addProblem(@RequestBody @Valid User user) {
        return problemRepository.save(user);
    }

    @DeleteMapping()
    public User delProblem(@RequestBody User user) {
        problemRepository.delete(user);
        return user;
    }

    @PutMapping(path = "/{problemId}", produces = "application/json")
    public ResponseEntity<?> updateTask(@PathVariable("problemId") long problemId, @Valid @RequestBody User newUser) {
        Optional<User> oldPessoa = problemRepository.findById(problemId);
        if (oldPessoa.isPresent()) {
            User pb = oldPessoa.get();
            pb.setName(newUser.getName());
            pb.setOrigin(newUser.getOrigin());
            pb.setDate(newUser.getDate());
            pb.setHour(newUser.getHour());
            return new ResponseEntity<>(problemRepository.save(pb), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ApiError(404, "Problem not found", new Date()), HttpStatus.NOT_FOUND);

    }*/
}
