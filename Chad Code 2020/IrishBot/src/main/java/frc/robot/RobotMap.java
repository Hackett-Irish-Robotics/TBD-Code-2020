/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import java.util.concurrent.Flow.Publisher;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // Victors on the RoboRio
  // We need to make sure these are always linked correctly or
  // we could damage the motors.

  public static final int DRIVETRAIN_LEFT_FRONT_VICTOR = 4;
  public static final int DRIVETRAIN_LEFT_BACK_VICTOR = 2;
  public static final int DRIVETRAIN_RIGHT_FRONT_VICTOR = 3;
  public static final int DRIVETRAIN_RIGHT_BACK_VICTOR = 1;

  // Here is our Joystick for the Arcade drive.
  public static final int OI_DRIVER_CONTROLLER = 0;

  // Here is our gamepad controller for button usage.
  public static final int OI_GAMEPAD_CONTROLLER = 1;

  // Need to set our axis for move and rotate.
  // Check the settings for these.
  public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1;
  public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 2;

  // Adding a constant for the solenoid.
  public static final int HATCH_SOLENOID_OUT = 1;
  public static final int HATCH_SOLENOID_IN = 2;
  
  // Adding a constant for our Hatch Compressor.
  public static final int COMPRESSOR_ID = 6;

  // Here is our Hatch Winch. Set to ID5 for now. Check this on PWM.
  public static final int HATCH_WINCH_CONTROLLER = 5;

  // Here is our Cargo Winch. We can check the ID later.
  public static final int CARGO_WINCH_CONTROLLER = 6;

  // Intake System rollers if needed.
  public static final int INTAKE_ROLLER_LEFT = 7;
  public static final int INTAKE_ROLLER_RIGHT = 8;

  // Here is our Grab Arm. We have this at zero.
  public static final int GRAB_SOLENOID = 0;


  





}
