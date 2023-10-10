package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
    private final WheeledIntake intake;

    public IntakeCommand(WheeledIntake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.intakeOn(0.1);
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }
}
