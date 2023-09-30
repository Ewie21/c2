// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.intake.Intake;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.pivot.Pivot;
import frc.robot.commands.pivot.PivotCommand;

public class RobotContainer {

  public final XboxController controller = new XboxController(0);
  public final Intake intakeSubsystem = new Intake();
  public final IntakeCommand intake = new IntakeCommand(intakeSubsystem, controller);
  public final Pivot pivotSubsystem = new Pivot();
  public final PivotCommand pivot = new PivotCommand(pivotSubsystem, controller);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    intakeSubsystem.setDefaultCommand(intake);
    pivotSubsystem.setDefaultCommand(pivot);
  }

  public Command getAutonomousCommand() {
    return null;
  }

}
