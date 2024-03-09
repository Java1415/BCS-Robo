// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


import edu.wpi.first.wpilibj.Timer;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {
 
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */


  private final CAN rightMotor = new SparkMax(1);

  //left motors
  private final CAN leftMotor = new SparkMax(2);

//Speed Controller Groups
private final MotorControllerGroup launcherGroup = new MotorControllerGroup(topLauncherMotor, bottomLauncherMotor);
private final MotorControllerGroup hookGroup = new MotorControllerGroup(leftHookMotor, rightHookMotor);
//drivetrain
private final DifferentialDrive driveTrain = new DifferentialDrive(leftMotor, rightMotor);

//Left Hook
private final CAN leftHookMotor = new WPI_VictorSPX(3);

//Right Hook
private final CAN rightHookMotor= new WPI_VictorSPX(4);

// Top feeder Mechanism
private final CAN topLauncherMotor = new WPI_VictorSPX(5);

// Bottom feeder Mechanism
private final CAN bottomLauncherMotor = new WPI_VictorSPX(6);


//Joystick
private final Joystick stick1 = new Joystick(1);
private final Joystick stick2 = new Joystick(2);

//Time
Timer timer = new Timer();

//Camera


  @Override
  public void robotInit() {
CameraServer.startAutomaticCapture();

  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {

    timer.reset();

    timer.start();
  }

  @Override
  public void autonomousPeriodic() {
  
    /*if (timer.get()<2){

      //rightSpeedGroup.set(0.25);
      //leftSpeedGroup.set(0.25);
  
    //}else{
			//rightSpeedGroup.set(0);
      //leftSpeedGroup.set(0);
		//}
//^just disabling it for now

 //   if (timer.get()<8 ){

//      shooter.set(Value.kReverse);
  
//    }else{
//			shooter.set(Value.kOff);
//  }
//  if (timer.get()>2 && timer.get()<8){

//    feeder.set(-1);
//
//  }else{
//    feeder.set(0);
//  }
/*Jonathan tries to replicate and add on
if (timer.get()<8){
  feederMotor.set(1);
  }else{
    feederMotor.set(0);
  }

  if (timer.get()>2 && timer.get()<8){
    shooterMotor.set(-0.75);
  }else{
    shooterMotor.set(0);
  }*/

  
}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    drivetrain.arcadeDrive(stick1.getX(), stick1.getY());
    
   /*  boolean hookButtonUp = stick2.getRawButton(11);
    if (hookButtonUp){
			hookLauncherGroup.set(1);
		}
    boolean hookButtonDown = stick2.getRawButton(10);
    if (hookButtonDown){
			hookGroup.set(-1);
		}

    boolean hookButtonOff = stick2.getRawButton(11) || stick2.getRawButton(10);
    if (hookButtonOff){
			hookGroup.set(0);
		}

    boolean ringLauncherButton = stick2.getRawButton(1);
    if (ringLauncherButton){
			ringLauncherGroup.set(-1);
		} else{
			ringLauncherGroup.set(0);
 	}
  
   boolean ringLauncherFoward = stick2.getRawButton(6);
   if (intakeButtonFoward){
     t.set(1);
  } 

  boolean intakeButtonReverse = stick2.getRawButton(7);
  if (intakeButtonReverse){
    ringLnuncherGroup.set(-1);
 } 

  boolean ringLauncehrButtonOff = stick2.getRawButton(6) || stick2.getRawButton(7);
  if (!intakeButtonOff){
    intakeMotor.set(0);
  }

  boolean IntakeFeederButton = stick2.getRawButton(3);
  if(IntakeFeederButton){
    intakeMotor.set(1); feederMotor.set(1);
  }

  boolean HangingButtonUp = stick2.getRawButton(4);
  if(HangingButtonUp){
    hangingMotor.set(1);
  } */
  boolean leftMotorButtonForward = stick1.getx();
  if(HangingButtonDown){
    hangingMotor.set(-1);
  }

  boolean HangingButtonOff = stick2.getRawButton(4) || stick2.getRawButton(5);
  if(!HangingButtonOff){
    hangingMotor.set(0);
  } 
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

