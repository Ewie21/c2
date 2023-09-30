package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class OuttakeCommand extends CommandBase {
    private final WheeledIntake intake;

    public OuttakeCommand(WheeledIntake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.outtakeOn(); // Ask Zach if this should become a setSpeed() function instead
        intake.setCurrentLimit(10);
    }
}
