/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team5857.robot.commands.ToggleIntake;
import org.usfirst.frc.team5857.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
  public SpeedController feeder, outtake;
  public boolean feederActive, outtakeActive;

	public Intake() {
    feeder = new WPI_TalonSRX(15); 
    outtake = new WPI_TalonSRX(0);
    outtakeSlow = new WPI_TalonSRX(7);
    feederActive = false;
    outtakeActive = false;
	}

	public void toggleIntake(Joystick driveStick, Joystick secondaryStick) {
		if(driveStick.getRawButtonPressed(1)) {
			//Intake 
			if(feederActive) {
				feederActive = false;
			} else {
				feederActive = true;
			}
			if(feederActive){
				feeder.set(.3);
			} else{
				feeder.set(0);
			}
		}
		if(driveStick.getRawButtonPressed(0)) {
			//Outtake
			if(outtakeActive) {
				outtakeActive = false;
			} else {
				outtakeActive = true;
			}
			if(outtakeActive){
				outtake.set(.3);
			} else{
				outtake.set(0);
			}
		}
	}

	public boolean getIntakeSpeed1() {
		return intake1.getInverted();
	}	

	public void initDefaultCommand() {
		setDefaultCommand(new ToggleIntake());

	}
	
}