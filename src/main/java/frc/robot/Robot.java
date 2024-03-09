/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.*;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.CAN;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Robot extends TimedRobot {
  private DifferentialDrive driveRobot;
  private Joystick leftStick;
  private Joystick rightStick;
  private static final int leftDeviceID = 1; 
  private static final int rightDeviceID = 2;
  private static final int leftHookID = 3;
  private static final int rightHookID = 4;
  private static final int topLauncherID = 5;          //100% speed
  private static final int bottomLauncherID = 6;       //75% speed
  private CANSparkMax leftMotor;
  private CANSparkMax rightMotor;
  private PWMVictorSPX leftHook;
  private PWMVictorSPX rightHook;
  private PWMVictorSPX topLauncher;
  private PWMVictorSPX bottomLauncher;
  //private WPI_VictorSPX leftHookMotor;
  Timer timer = new Timer();

  @Override
  public void robotInit() {
  /**
   * SPARK MAX controllers are intialized over CAN by constructing a CANSparkMax object
   * 
   * The CAN ID, which can be configured using the SPARK MAX Client, is passed as the
   * first parameter
   * 
   * The motor type is passed as the second parameter. Motor type can either be:
   *  com.revrobotics.CANSparkLowLevel.MotorType.kBrushless
   *  com.revrobotics.CANSparkLowLevel.MotorType.kBrushed
   * 
   * The example below initializes four brushless motors with CAN IDs 1 and 2. Change
   * these parameters to match your setup
   */
    leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
    rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);
    leftHook = new PWMVictorSPX(leftHookID);
    rightHook = new PWMVictorSPX(rightHookID);
    topLauncher = new PWMVictorSPX(topLauncherID);
    bottomLauncher= new PWMVictorSPX(bottomLauncherID);

    /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
    leftMotor.restoreFactoryDefaults();
    rightMotor.restoreFactoryDefaults();

    driveRobot = new DifferentialDrive(leftMotor, rightMotor);

    leftStick = new Joystick(1);
    rightStick = new Joystick(2);
  }
  
  @Override
  public void robotPeriodic() {}

  @Override                       // Do This At Start of Auto Period
  public void autonomousInit() {

    timer.reset();

    timer.start();
  }

  @Override                       // Do This During Auto Period - Make Use of Time class and functions
  public void autonomousPeriodic() {}
 
  @Override                       // Do This At Start of TeleOp/Controlled Period
  public void teleopInit() {}

  @Override                       // Do This During TeleOp/Controlled Period
  public void teleopPeriodic() {
    driveRobot.tankDrive(leftStick.getY(), rightStick.getY());
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

}
