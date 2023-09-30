package frc.robot.commands.pivot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pivot extends SubsystemBase {
    private final TalonFX pivot1 = new TalonFX(11);
    private final TalonFX pivot2 = new TalonFX(10);

    public Pivot() {
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
