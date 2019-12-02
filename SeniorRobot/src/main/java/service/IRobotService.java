package service;

import model.Robot;

public interface IRobotService {

	Robot move(String strComando) throws Exception;
	
}
