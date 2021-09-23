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
		
		int i=0;
		//Hier Deklariere ich eine Neue Variable mit dem Wert i für eine endlos schleife
			
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		//Hier synchronisiere ich die beiden Motoren
		
		while(i<4) {
		rightMotor.startSynchronization();
		//Hier starte ich die synchronisierung der Motoren
		rightMotor.setSpeed(360);
		leftMotor.setSpeed(360);
		//Hier sage ich wie viel grad die Motoren pro sekunde in grad sich drehen sollen 360 Grad eine umdrehung
		leftMotor.forward();
		rightMotor.forward();
		Delay.msDelay(2000);
		rightMotor.stop();
		leftMotor.stop();
		//Hier fährt der Roboter 3 sekunde nach vorne und bleibt stehen
		rightMotor.endSynchronization();
		//Hier ende ich die synchronisierung der Motoren
		rightMotor.rotateTo(418);//90° Drehung
		//Hier lasse ich die schleife 4 mal ausführen
		i++;
		}
	}
	

}
