package com.database.MongodbService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/trains")

public class TrainController {
	@Autowired
	private TrainRepository trainrepository;
	
	 @Autowired
	    private BookingService bookingService;

	@PostMapping("/addTrain")
	public String saveTrain(@RequestBody Train trainid) {
	trainrepository.save(trainid);
	return "Added train with Name :  " + trainid.getTrainName()+ " and TrainId is: " + trainid.getTrainid() ;
    }
	
	@GetMapping("/search/{trainid}")
	public Optional<Train> getTrain(@PathVariable String trainid){
		return trainrepository.findById(trainid);
	}
	@GetMapping("/booking/{trainid}")
	public List<Train> getTrainByBookingId(@PathVariable("trainid") String trainid){
		return this.bookingService.getTrain(trainid);
	}
	@GetMapping("/all")
    public List<Train> getAllTrains(){
        return trainrepository.findAll();
    }	
	@DeleteMapping("/delete/{trainid}")
	public String deleteTrain (@PathVariable String trainid) {
		trainrepository.deleteById(trainid);
		return "Train deleted with id : "+trainid;
    }
	@PutMapping("/update/{trainid}")
	public Train updateTrain(@PathVariable("trainid") String trainid,@RequestBody Train t ) {
		t.setTrainid(trainid);
		trainrepository.save(t);
		return t;
		
}

}
