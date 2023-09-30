package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
    private final Intake intake;
    private final XboxController controller;

    public IntakeCommand(Intake intake, XboxController controller) {
        this.intake = intake;
        this.controller = controller;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        double raw_speed = controller.getLeftY();
        double speed = Math.abs(raw_speed * 0.1) < 0.1 ? 0 : raw_speed;
        intake.setIntake(speed);
    }
}
