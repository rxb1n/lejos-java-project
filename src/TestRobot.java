import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay; 
import lejos.hardware.port.SensorPort; 
import lejos.hardware.sensor.EV3ColorSensor;  


public class TestRobot {
	
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);
	
	public static void main(String[] args) {
		
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		//Hier synchronisiere ich die beiden Motoren
		
		
	}
	

}
