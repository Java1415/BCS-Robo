/*Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.cameraserver.CameraServer;
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
//public class Robot2 extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   

  //right motors
private final WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(1);
private final WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(2);

//left motors
private final WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(3);
private final WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(4);

//Speed Controller Groups
private final MotorControllerGroup rightSpeedGroup = new MotorControllerGroup(rightMotor1, rightMotor2);
private final MotorControllerGroup leftSpeedGroup = new MotorControllerGroup(leftMotor1, leftMotor2);

//drivetrain
private final DifferentialDrive drivetrain = new DifferentialDrive(leftSpeedGroup, rightSpeedGroup);

//feeder Mechanism
private final WPI_VictorSPX feederMotor = new WPI_VictorSPX(5);

//intake Mechanism
private final WPI_VictorSPX intakeMotor = new WPI_VictorSPX(0);

//Shooter Mechanism
private final WPI_VictorSPX shooterMotor = new WPI_VictorSPX(7);

//Hanging Arm
private final WPI_VictorSPX hangingMotor = new WPI_VictorSPX(8);

//Joystick
private final Joystick stick1 = new Joystick(0);
private final Joystick stick2 = new Joystick(1);

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
  
    //if (timer.get()<2){

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
//Jonathan tries to replicate and add on
if (timer.get()<8){
  feederMotor.set(1);
  }else{
    feederMotor.set(0);
  }

  if (timer.get()>2 && timer.get()<8){
    shooterMotor.set(-0.75);
  }else{
    shooterMotor.set(0);
  }

  if (timer.get()>8 && timer.get()<11){
    rightSpeedGroup.set(-0.25);
    leftSpeedGroup.set(0.25);
  }else{
    rightSpeedGroup.set(0);
    leftSpeedGroup.set(0);
  }
}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    drivetrain.arcadeDrive(stick1.getX(), stick1.getY());
    
    boolean feederButtonForward = stick2.getRawButton(11);
    if (feederButtonForward){
			feederMotor.set(1);
		}
    boolean feederButtonReverse = stick2.getRawButton(10);
    if (feederButtonReverse){
			feederMotor.set(-1);
		}

    boolean feederButtonOff = stick2.getRawButton(11) || stick2.getRawButton(10);
    if (!feederButtonOff){
			feederMotor.set(0);
		}

    boolean shooterButton = stick2.getRawButton(1);
    if (shooterButton){
			shooterMotor.set(-1);
		} else{
			shooterMotor.set(0);
 	}
  
   boolean intakeButtonFoward = stick2.getRawButton(6);
   if (intakeButtonFoward){
     intakeMotor.set(1);
  } 

  boolean intakeButtonReverse = stick2.getRawButton(7);
  if (intakeButtonReverse){
    intakeMotor.set(-1);
 } 

  boolean intakeButtonOff = stick2.getRawButton(6) || stick2.getRawButton(7);
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
  } 
  boolean HangingButtonDown = stick2.getRawButton(5);
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
}*/