/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.subsystems.CargoSystem;
import frc.robot.subsystems.Drivetrain;
//import frc.robot.subsystems.GrabSystem;
//import frc.robot.subsystems.HatchSystem;
//import frc.robot.subsystems.IntakeSystem;
//import frc.robot.subsystems.WinchSystem;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    // Adding our Hatch Winch
    //public static WinchSystem m_winch = null;

    // Adding the Drivetrain
    public static Drivetrain m_drivetrain = null;

    // Adding the compressor
    public static Compressor m_compressor = null;

    // Adding the Hatch System
    //public static HatchSystem m_hatchsystem = null;

    // Adding the Grab System
    //public static GrabSystem m_grabsystem = null;

    // Adding the Cargo System
    //public static CargoSystem m_cargosystem = null;

    // If we decide to add the rollers later,
    // we have the system and command code ready.
    //public static IntakeSystem m_intakesystem = null;

    // Input and Ouput
    public static OI m_oi;

    Command m_autonomousCommand;
    SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    // Instantiating. Make sure these occur above OI.
    // Instantiate the Drive system.
    m_drivetrain = new Drivetrain();

    // Instantiate the Winch system.
    //m_winch = new WinchSystem();

    // Instantiate a compressor.
    m_compressor = new Compressor(RobotMap.COMPRESSOR_ID);
    m_compressor.setClosedLoopControl(true);

    // Instantiate the Hatch System.
    //m_hatchsystem = new HatchSystem();

    // Instantiate the Grab System
    //m_grabsystem = new GrabSystem();

    // Instantiate the Cargo System
    //m_cargosystem = new CargoSystem();

    // Instantiate the Intake System in Needed
    //m_intakesystem = new IntakeSystem();

    // Need to see with the camera.
    // Discussions online note that there is no way
    // to rotate it in Java. Might be able to
    // change orientation in the driver station.
    // Must be rotated at driver station.
    CameraServer.getInstance().startAutomaticCapture();

    // Instantiate our input/output.
    m_oi = new OI();

    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
