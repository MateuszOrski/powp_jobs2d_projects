package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.visitor.CommandCounterVisitor;
import edu.kis.powp.jobs2d.features.CommandsFeature;

public class SelectDisplayCommandCounterOptionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommand command = CommandsFeature.getDriverCommandManager().getCurrentCommand();
        
        if (command == null) {
            JOptionPane.showMessageDialog(null, "No command loaded.", "Command Counter Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int totalCount = CommandCounterVisitor.countAll(command);
        int operateToCount = CommandCounterVisitor.countOperateTo(command);
        int setPositionCount = CommandCounterVisitor.countSetPosition(command);
        int compoundCount = CommandCounterVisitor.countCompound(command);
        
        String message = String.format(
            "Command Counter Information:\n\n" +
            "Total Commands: %d\n" +
            "OperateTo Commands: %d\n" +
            "SetPosition Commands: %d\n" +
            "Compound Commands: %d",
            totalCount, operateToCount, setPositionCount, compoundCount
        );
        
        JOptionPane.showMessageDialog(null, message, "Command Counter Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
