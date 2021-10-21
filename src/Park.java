import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;

public class Park {
	
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);	
	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	
	static EV3UltrasonicSensor uSensor = new EV3UltrasonicSensor(SensorPort.S3);
	
public void Lückeerkannt() {
		
		SampleProvider distance = uSensor.getDistanceMode();
		float[] sample = new float[distance.sampleSize()];
		
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		
		rightMotor.startSynchronization();
		
		rightMotor.setSpeed(50);
		leftMotor.setSpeed(50);
		
		rightMotor.forward();
		leftMotor.forward();
		
		Delay.msDelay(1500);	
		
		rightMotor.stop();
		leftMotor.stop();
		
		rightMotor.endSynchronization();
		
		while(Button.ENTER.isUp()) {
			
			distance.fetchSample(sample, 0);
			float d = sample[0];
			
			if(d < 0.20f) {
				return;
			}
			else if(d > 0.20f) {
				
				rightMotor.startSynchronization();
				
				rightMotor.setSpeed(50);
				leftMotor.setSpeed(50);
				
				rightMotor.backward();
				leftMotor.backward();
				
				Delay.msDelay(500);
				
				rightMotor.stop();
				leftMotor.stop();
				
				rightMotor.endSynchronization();
				
				rightMotor.rotate(412);
				
				rightMotor.startSynchronization();
				
				rightMotor.rotate(540);
				leftMotor.rotate(540);
				
				rightMotor.endSynchronization();
			}
		}
		
	}

	public static void main(String[] args) {
		
		Park park1 = new Park();
		
		SampleProvider distance = uSensor.getDistanceMode();
		float[] sample = new float[distance.sampleSize()]; 

		
		while(Button.ENTER.isUp()) {
			
			distance.fetchSample(sample, 0);
			float d = sample[0];
			
			if(d < 0.10f) {
				leftMotor.rotate(20);
			}
			else if(d > 0.10f && d < 0.19f) {
				rightMotor.rotate(20);
			}
			else if(d > 0.20f) {
				park1.Lückeerkannt();
			}
		}
	}
}
