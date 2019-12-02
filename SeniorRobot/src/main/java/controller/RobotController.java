//package controller;
//
//import java.util.regex.Pattern;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import service.IRobotService;
//
//import model.Robot;
//import service.RobotService;
//
//@Path("/mars")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class RobotController {
//	private IRobotService objRobotService = new RobotService();
//
//	@GET
//	@Path("/{comando}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response hello(@PathParam("comando") String strComando) {
//		
//		boolean validateCommand = Pattern.matches("^[M]{1}+[L]{1}", strComando);
//
//		if(validateCommand) {
//			Robot objRobot = objRobotService.move(strComando);
//
//			return Response.ok(objRobot, MediaType.APPLICATION_JSON).build();
//
////			return Response.ok(String.format("ok Pedro %s", objRobot)).build();
//		}else {
//			return Response.ok(String.format("Nao funciona")).build();
//		}
//	}
//}
package controller;

import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.Robot;
import model.RobotError;
import service.IRobotService;
import service.RobotService;

@Path("/mars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RobotController {

	private IRobotService objRobotService = new RobotService();

	@POST
	@Path("/{comando}")
	public Response move(@PathParam("comando") String strComando) {
		try {
			boolean validateCommand = Pattern.matches("[MLRmlr]*$", strComando);
			
			if (validateCommand) {
				Robot objRobot;

				objRobot = objRobotService.move(strComando.toUpperCase());
				
				return Response.ok(objRobot, MediaType.APPLICATION_JSON).build();
			} else {
				RobotError objRobotError = new RobotError(Status.BAD_REQUEST.getStatusCode(), "Error");
				return Response.status(Status.BAD_REQUEST).entity(objRobotError).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e).build();
		}
	}
}
