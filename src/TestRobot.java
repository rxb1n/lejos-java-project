import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import lejos.hardware.Button; 
import lejos.hardware.lcd.LCD; 
import lejos.hardware.port.SensorPort; 
import lejos.hardware.sensor.EV3ColorSensor; 
import lejos.robotics.SampleProvider; 


public class TestRobot {
	
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);
	
	public static void main(String[] args) {
		
		int i=1;
		//Hier Deklariere ich eine Neue Variable mit dem Wert i für eine endlos schleife
			
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});	
		//Hier synchronisiere ich die beiden Motoren
		
		while(i<2) {
		rightMotor.startSynchronization();
		//Hier starte ich die synchronisierung der Motoren
		rightMotor.forward();
		leftMotor.forward();
		Delay.msDelay(3000);
		rightMotor.stop();
		leftMotor.stop();
		//Hier fährt der Roboter 3 sekunde nach vorne und bleibt stehen
		rightMotor.endSynchronization();
		//Hier ende ich die synchronisierung der Motoren
		leftMotor.rotate(-180); //Drehung
		rightMotor.rotate(360);
		}
	}
	

}
