import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;

public class SquareRobotUltrasonic {
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	static EV3UltrasonicSensor uSensor = new EV3UltrasonicSensor(SensorPort.S3);
	
	public static void main(String[] args) {
		
		int i=0;
		
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		
		SampleProvider distance= uSensor.getMode("Distance");
		float[] sample = new float[distance.sampleSize()];
		
		do{
			if()) { // If Distance is < 30cm
				if(){ //If distance < 20cm
					leftMotor.forward();
				}
				else { // IF distance >20 cm
					rightMotor.forward();
				}
			}
			else{ // IF disctance > 30cm
				rightMotor.startSynchronization(); // Hier starte ich die Sync
				
				rightMotor.forward(); // Beide Motoren fahren Nach vorne
				leftMotor.forward();
				
				rightMotor.endSynchronization(); // Hier beende ich die Sync
				
				Delay.msDelay(1500); // Anderthabl sekunden lang Fahren
				
				rightMotor.setAcceleration(1000);
				leftMotor.setAcceleration(1000);
				
				rightMotor.startSynchronization(); // Hier starte ich die Sync
				
				rightMotor.stop(true); // stoppen beider Motoren
				leftMotor.stop(true);
				
				rightMotor.endSynchronization(); // Hier beende ich die Sync
				
				Delay.msDelay(500);
				
				rightMotor.waitComplete();
				leftMotor.waitComplete();
				
				rightMotor.rotate(412);
				
				rightMotor.startSynchronization(); // Hier starte ich die Sync
				
				rightMotor.forward();	// Beide Motoren fahren Nach vorne
				leftMotor.forward();
				
				rightMotor.endSynchronization(); // Hier beende ich die Sync
				
				rightMotor.waitComplete();
				leftMotor.waitComplete();
				
				Delay.msDelay(1500);
				
			}
			i++;  // hier lasse ich die schleife 4 aml Durchführen
		}while(i<4);
		

	}

}