import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
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
	 
	public static void Lenken() { // Methode 
		
		LCD.drawString("Method", 0,1);
		
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		
		rightMotor.startSynchronization();
		
		rightMotor.rotate(360);
		leftMotor.rotate(360);
		
		rightMotor.stop();
		leftMotor.stop();
		
		rightMotor.endSynchronization();
		
		rightMotor.rotate(412);	
		
		rightMotor.startSynchronization();
		
		rightMotor.rotate(360);
		leftMotor.rotate(360);
		
		rightMotor.endSynchronization();
		
		rightMotor.waitComplete();
		leftMotor.waitComplete();
		
		return; 
		
	}
	 
	public static void main(String[] args) {
		
		EV3UltrasonicSensor uSensor = new EV3UltrasonicSensor(SensorPort.S3);
		SampleProvider distance = uSensor.getDistanceMode();
		float[] sample = new float[distance.sampleSize()];
		
		LCD.drawString("Startet", 0, 2);
		
		while(Button.ENTER.isUp())
		{
			distance.fetchSample(sample, 0);
			float d = sample[0];
			
			
			if(d < 0.1f) // Distance kleiner als 10cm
			{ 
				leftMotor.rotate(50);
			}	
			else if(d > 0.1f  && d < 0.19f) // Distance größer als 10cm und kleiner als 19cm
			{ 
				rightMotor.rotate(50);
			}
			else if(d > 0.2f) // Distance größer als 20cm 
			{
				Lenken();
				LCD.drawString("Lenken", 0, 3);	// Methode wird abgerufen up
			}
			Delay.msDelay(100);

		
		}
		uSensor.close();
	}
}