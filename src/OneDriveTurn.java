import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;


public class OneDriveTurn {
	
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);

	public static void main(String[] args) {
		
		  rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});

		  rightMotor.startSynchronization();
		  
		  rightMotor.forward();
		  leftMotor.forward();
		  
		  rightMotor.endSynchronization();
		  
		  Delay.msDelay(4000);
		  
		  rightMotor.setAcceleration(1000);
		  leftMotor.setAcceleration(1000);
		  
		  rightMotor.startSynchronization();
		  
		  rightMotor.stop(true);
		  leftMotor.stop(true);
		  
		  rightMotor.endSynchronization();
		  
		  Delay.msDelay(500);
		  
		  rightMotor.rotate(400);
		  rightMotor.stop();
		  leftMotor.rotate(-400);
		  leftMotor.stop();
		  
		  rightMotor.startSynchronization();
		  
		  rightMotor.forward();
		  leftMotor.forward();
		  
		  rightMotor.endSynchronization();
		  
		  Delay.msDelay(4000);
		  
		  rightMotor.setAcceleration(1000);
		  leftMotor.setAcceleration(1000);
		  
		  rightMotor.startSynchronization();
		  
		  rightMotor.stop(true);
		  leftMotor.stop(true);
		  
		  rightMotor.endSynchronization();
		  
		  
		  rightMotor.waitComplete();
		  leftMotor.waitComplete();
	}
}