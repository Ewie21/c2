package frc.robot.commands.intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class WheeledIntake extends SubsystemBase {
    private final CANSparkMax motor1 = new CANSparkMax(15, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax motor2 = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);

    public WheeledIntake() {
        motor1.restoreFactoryDefaults();
        motor2.restoreFactoryDefaults();
        setCurrentLimit(20);

        motor1.setIdleMode(CANSparkMax.IdleMode.kBrake);
        motor2.setIdleMode(CANSparkMax.IdleMode.kBrake);

        motor1.setInverted(false);
        motor2.follow(motor1, true);
        motor1.set(0);
    }

    public void stop() {
        motor1.set(0);
    }

    public void intakeOn(double number) {
        motor1.set(number);
    }

    public void outtakeOn(double number) {
        motor1.set(-number);
    }

    public void setCurrentLimit(int limit) {
        motor1.setSmartCurrentLimit(limit); 
        motor2.setSmartCurrentLimit(limit);
    }
}
