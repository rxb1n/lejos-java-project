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
	static EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S1);
	
	
	public static void main(String[] args) {
		
		sensor.getAmbientMode();
		int i=2;
		
		while(i>1)
		{
			if ( > .100)
            {
                leftMotor.setSpeed(40);
                rightMotor.setSpeed(20);
            }
            else
            {
                leftMotor.setSpeed(20);    
                rightMotor.setSpeed(40);
            }
		}
		
		
		
	}

}
