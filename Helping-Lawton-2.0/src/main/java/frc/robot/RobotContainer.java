// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RunRollerCmd;
import frc.robot.commands.RunRollerReverseCmd;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.RollerSys;

import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final RollerSys rollerSys = new RollerSys();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final Joystick m_operatorController =
      new Joystick(OperatorConstants.kDriverControllerPort);

  // Name Commands.
  private final RunRollerCmd runRollerCmd;
  private final RunRollerReverseCmd runRollerReverseCmd;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Initalize Commands.
    runRollerCmd = new RunRollerCmd(rollerSys);
    runRollerReverseCmd = new RunRollerReverseCmd(rollerSys);

    // Add Requirements.
    runRollerCmd.addRequirements(rollerSys);
    runRollerReverseCmd.addRequirements(rollerSys);

    // Register Commands To Path Planner.
    NamedCommands.registerCommand("runRollerCmd", new RunRollerCmd(rollerSys));
    NamedCommands.registerCommand("runRollerReverseCmd", new RunRollerReverseCmd(rollerSys));

    // Configure the trigger bindings
    configureOperatorBindings();
  }

  private void configureOperatorBindings() {
    JoystickButton runRoller = new JoystickButton(m_operatorController, 4);
    JoystickButton runReverseRoller = new JoystickButton(m_operatorController, 4);

    runRoller.whileTrue(new RunRollerCmd(rollerSys));
    runReverseRoller.whileTrue(new RunRollerReverseCmd(rollerSys));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
