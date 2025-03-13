package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RollerSys;

public class RunRollerReverseCmd extends Command {

    private final RollerSys rollerSys;
    
    public RunRollerReverseCmd(RollerSys rollerSys){
            this.rollerSys = rollerSys;
    }

    //Called when the command is initially scheduled.
    @Override
    public void initialize(){}

    // Called every time the schedule runs while the command is scheduled.
    @Override
    public void execute(){
        rollerSys.runRollerReverse();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted){}

    // Returns true whne the command should end.
    @Override
    public boolean isFinished(){
        return false;
    }
}
