import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay; 
import lejos.hardware.port.SensorPort; 
import lejos.hardware.sensor.EV3ColorSensor;  


public class SquareDrive {
	
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);
	
	public static void main(String[] args) {
		
		int i=0;
		//Hier Deklariere ich eine Neue Variable mit dem Wert i für eine endlos schleife
			
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		//Hier synchronisiere ich die beiden Motoren
		
		do
		{
		rightMotor.startSynchronization();//Hier starte ich die synchronisierung der Motoren
		
		leftMotor.forward(); //Roboter Fährt
		rightMotor.forward();
		
		rightMotor.endSynchronization();//Hier ende ich die synchronisierung der Motore
		
		Delay.msDelay(3500);//Hier fährt der Roboter 5 sekunden nach vorne
		
		
		rightMotor.setAcceleration(1000);
		leftMotor.setAcceleration(1000);
		
		rightMotor.startSynchronization();//Hier starte ich die synchronisierung der Motoren
		
		rightMotor.stop(true);
		leftMotor.stop(true);
		
		rightMotor.endSynchronization();//Hier ende ich die synchronisierung der Motore

		Delay.msDelay(500);//Roboter wartet 500ms
		
		rightMotor.waitComplete();
		leftMotor.waitComplete();
		
		rightMotor.rotate(412);//90° Drehung 418°
		
		i++;//Hier lasse ich die schleife 4 mal ausführen
		}while(i<4);
		
	 }	
	}