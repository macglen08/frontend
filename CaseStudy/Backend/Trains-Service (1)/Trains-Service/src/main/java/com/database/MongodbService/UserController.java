package com.database.MongodbService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/search")
public class UserController {
	
	@Autowired
	private TrainRepository trainrepository;

    @GetMapping("/findAllTrains")
    public List<Train> getTrains(){
	return trainrepository.findAll();
	
}
    @GetMapping("/find/{trainid}")
    public Optional<Train> getTrains(@PathVariable String trainid){
	return trainrepository.findById(trainid);
}
	
}