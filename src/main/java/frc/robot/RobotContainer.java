// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.intake.WheeledIntake;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.intake.OuttakeCommand;
import frc.robot.commands.pivot.Pivot;
import frc.robot.commands.pivot.PivotCommand;

public class RobotContainer {

  public final CommandXboxController driver = new CommandXboxController(0);
  public final WheeledIntake intakeSubsystem = new WheeledIntake();
  public final Pivot pivotSubsystem = new Pivot();
  public final PivotCommand pivot = new PivotCommand(pivotSubsystem, driver);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    driver.a().whileTrue(new IntakeCommand(intakeSubsystem));
    driver.b().whileTrue(new OuttakeCommand(intakeSubsystem));
    pivotSubsystem.setDefaultCommand(pivot);
  }

  public Command getAutonomousCommand() {
    return null;
  }

}
