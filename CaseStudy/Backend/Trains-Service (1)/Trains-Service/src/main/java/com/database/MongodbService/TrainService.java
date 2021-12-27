package com.database.MongodbService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService implements BookingService {

	@Autowired
	private TrainRepository trainrepository;
	

	public Train addTrain (Train train) {
		return trainrepository.save(train);
	}

	public List<Train> getContact() {
		List<Train> train = trainrepository.findAll();
		System.out.println("Getting data from DB : " + train);
		return train;
	}

	public Optional<Train> getTrainbyId(String id) {
		return trainrepository.findById(id);
	}

	public void deleteTrain(Train train) {
		trainrepository.delete(train);
	}
	 @Override
	    public List<Train> getTrain(String id) {
	        List<Train> train=trainrepository.findAll();
	        return train.stream().filter(tt->tt.getTrainid().equals(id)).collect(Collectors.toList());
	    }


}
