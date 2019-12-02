package service;

import javax.ws.rs.BadRequestException;

import model.Robot;

public class RobotService implements IRobotService {

	public Robot move(String strComando) throws Exception {

		Robot objRobot = new Robot();
		int x = 0;
		int y = 0;
		String p = "N";
		char[] a = strComando.toCharArray();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + "");
			if (a[i] == 'M') {
				if (p.equals("N")) {
					y++;
					if (y > 4) {
						System.out.println("Error");
						throw new BadRequestException();
					}
				} else if (p.equals("S")) {
					y--;
					if (y < 0) {
						System.out.println("Error");
						throw new BadRequestException();
					}
				} else if (p.equals("W")) {
					x--;
					if (x < 0) {
						System.out.println("Error");
						throw new BadRequestException();
					}
				} else if (p.equals("E")) {
					x++;
					if (x > 4) {
						System.out.println("Error");
						throw new BadRequestException();
					}
				}
			}

			if (a[i] == 'L') {
				if (p.equals("N")) {
					p = "W";
				} else if (p.equals("S")) {
					p = "E";
				} else if (p.equals("W")) {
					p = "S";
				} else if (p.equals("E")) {
					p = "N";
				}
			} else if (a[i] == 'R') {
				if (p.equals("N")) {
					p = "E";
				} else if (p.equals("S")) {
					p = "W";
				} else if (p.equals("W")) {
					p = "N";
				} else if (p.equals("E")) {
					p = "S";
				}
			}

		}

		objRobot.setPositionX(x);
		objRobot.setPositionY(y);
		objRobot.setDirection(p);

		return objRobot;
	}
}
