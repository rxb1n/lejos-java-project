import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorSensorEV3 {
	
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	 
	public static void main(String[] args) {
		
		EV3ColorSensor oSensor = new EV3ColorSensor(SensorPort.S2);
		SampleProvider color = oSensor.getAmbientMode();
		float[] sample = new float[color.sampleSize()];
		
		
		
		
		while(Button.ENTER.isUp())
		{
			color.fetchSample(sample, 0);
			float c = sample[0];
			
			if(c < 0.05) {
				rightMotor.rotate(20);
			}
			else if(c > 0.05){
				leftMotor.rotate(20);
			}
		}
		oSensor.close();
	}

}