package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANDevices;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class RollerSys extends SubsystemBase {
    
    public SparkMax m_rollerMtr = new SparkMax(CANDevices.m_rollerMtrId, MotorType.kBrushless);

    private boolean runRoller = false;
    private boolean runRollerReverse = false;

    private final SparkMaxConfig config;

    public RollerSys() {
        config = new SparkMaxConfig();
        config.idleMode(IdleMode.kCoast);
        config.inverted(false);

        m_rollerMtr.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    }

    public boolean runRoller() {
        return runRoller = true;
    }

    public boolean runRollerReverse() {
        return runRollerReverse = true;
    }

    @Override
    public void periodic() {
        if(runRoller == true){
            m_rollerMtr.set(1);
            runRoller = false;
        }
        else if(runRollerReverse == true){
            m_rollerMtr.set(-1);
            runRollerReverse = false;
        }
        else{
            m_rollerMtr.set(0);
        }
    }

}
