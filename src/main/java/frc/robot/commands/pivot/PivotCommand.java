package frc.robot.commands.pivot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class PivotCommand extends CommandBase {
    private final Pivot pivot;
    private final CommandXboxController controller;

    public PivotCommand(Pivot pivot, CommandXboxController controller) {
        this.pivot = pivot;
        this.controller = controller;
        addRequirements(pivot);
    }

    @Override
    public void execute() {
        double raw_speed = controller.getLeftX();
        double speed = Math.abs(raw_speed) < 0.1 ? 0 : raw_speed * 0.1; // deadzone
        pivot.setPivot(speed);
    }
    
    @Override
    public void end(boolean interrupted) {
        pivot.stop();
    }
}