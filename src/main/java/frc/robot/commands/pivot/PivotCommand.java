package frc.robot.commands.pivot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PivotCommand extends CommandBase {
    private final Pivot pivot;
    private final XboxController controller;

    public PivotCommand(Pivot pivot, XboxController controller) {
        this.pivot = pivot;
        this.controller = controller;
        addRequirements(pivot);
    }

    @Override
    public void execute() {
        double raw_speed = controller.getLeftX();
        double speed = Math.abs(raw_speed * 0.1) > 0.1 ? 0 : raw_speed;
        pivot.setPivot(speed);
    }
}