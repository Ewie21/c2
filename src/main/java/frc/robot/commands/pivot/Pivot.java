package frc.robot.commands.pivot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pivot extends SubsystemBase {
    private final TalonFX pivot1 = new TalonFX(11);
    private final TalonFX pivot2 = new TalonFX(10);

    public Pivot() {
        pivot1.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 60, 60, 0));
        pivot2.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 60, 60, 0));
        pivot1.configForwardSoftLimitThreshold(139_000);
        pivot1.configForwardSoftLimitEnable(true);
        pivot1.configReverseSoftLimitThreshold(-134_500);
        pivot1.configReverseSoftLimitEnable(true);
        
        pivot1.setInverted(false);
        pivot2.setInverted(true);
        pivot2.follow(pivot1);
        pivot1.setNeutralMode(NeutralMode.Brake);
        pivot2.setNeutralMode(NeutralMode.Brake);
    }

    public void setPivot(double speed) {
        pivot1.set(TalonFXControlMode.PercentOutput, speed);
    }

    public void stop() {
        pivot1.set(TalonFXControlMode.PercentOutput, 0);
    }
}
