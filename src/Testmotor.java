import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;


public class Testmotor {
	
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);

	public static void main(String[] args) {
		
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		
		  rightMotor.startSynchronization();
		  
		  rightMotor.rotate(360);
		
	}
}
