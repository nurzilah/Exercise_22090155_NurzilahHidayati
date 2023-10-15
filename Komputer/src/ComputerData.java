/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author arfanxn
 */
public class ComputerData implements AppInterface {
    
    private final Computer[] computers;
    
    public ComputerData () {
        this.computers = new Computer[10001];
        Computer computer = new Computer();
        
        // Dummy data
        computer.setBrand("Apple");
        computer.setModel("M1");
        computer.setDiskType("SSD");
        computer.setDiskSize(256);
        computer.setRamSize(8);
        this.computers[0] = computer;
    }

    public int menuOption() {
        String p = JOptionPane.showInputDialog(null, ""
            + "<html>"
            + "=====Options==================================<br>"
            + "0 &rarr; View all computers<br>"
            + "1 &rarr; Add computer data<br>"
            + "2 &rarr; Find by computer's brand<br>"
            + "3 &rarr; Find by computer's model<br>"
            + "4 &rarr; Exit<br>"
            + "==============================================<br>"
            + "<b›Enter your choice by number from 1 to 4:</b>"
            + "</html>",JOptionPane.QUESTION_MESSAGE);
    int option = Integer.parseInt(p); //casting JOptionPane. QUESTION MESSAGE) ; "Menu option",
    return option;        
    }

    public void add() {
        Computer computer = new Computer();
        String brand = JOptionPane.showInputDialog(
                null,
                "Enter a brand:", ""+" Brand",
                JOptionPane.QUESTION_MESSAGE);
        computer.setBrand(brand);
        String model = JOptionPane.showInputDialog(
                null,
                "Enter a model:", ""+" Model",
                JOptionPane.QUESTION_MESSAGE);
        computer.setModel(model);
        String disk = JOptionPane.showInputDialog(
                null,
                "Enter disk type (HDD/SSD):", ""+" Disk Type",
                JOptionPane.QUESTION_MESSAGE);
        computer.setDiskType(disk);
        int diskSize = Integer.parseInt(
            JOptionPane.showInputDialog(
            null,
            "Enter disk size in number of gigabyte unit:", ""+" Disk Size in gigabyte unit",
            JOptionPane.QUESTION_MESSAGE)
        );
        computer.setDiskSize(diskSize);
        int ramSize = Integer.parseInt(
            JOptionPane.showInputDialog(
            null,
            "Enter RAM size in number of gigabyte unit:", ""+" RAM Size in gigabyte unit",
            JOptionPane.QUESTION_MESSAGE)
        );
        computer.setRamSize(ramSize);
        
        for (int i = 0; i < this.computers.length; i++) {
            if (computers[i] == null) {
                computers[i] = computer;
                break;
            }
        }
        
        this.viewData(computer);
    }

    public String keyword(String type) {
        return JOptionPane.showInputDialog(
                null, 
                "Enter Computer "+type, 
                JOptionPane.QUESTION_MESSAGE);      
    }

    public Computer searchByBrand(String brand) {
        for (Computer computer : computers) {
            if ((computer != null) && 
                    computer.getBrand().matches("(?i:.*"+brand+".*)")) {
                return computer;
            }
        }
        return null;
    }

    public Computer searchByModel(String model) {
        for (Computer computer : computers) {
            if ((computer != null) && 
                    computer.getModel().matches("(?i:.*"+model+".*)")) {
                return computer;
            }
        }
        return null;
    }

    public void viewData(Computer computer) {
        if(computer == null){
            JOptionPane.showMessageDialog (null, "Not found!");
        }else {
            JOptionPane.showMessageDialog (null, 
            "Brand\t\t: "+ computer.getBrand () +
            "\nModel\t\t: " + computer.getModel() +
            "\nDisk Type\t: " + computer.getDiskType()+
            "\nDisk Size\t: " + computer.getDiskSize() +
            "\nRAM Size\t: " + computer.getRamSize(),
            "Computer Data",
        JOptionPane.INFORMATION_MESSAGE) ;
        }
    }
    
    public void viewTable() {
        if(this.computers.length == 0){
            JOptionPane.showMessageDialog (null, "Not found!");
            return;
        }
        
        Object[] cols = {
            "Number", "Brand", "Model", "Disk Type", "Disk Size", "RAM Size"
        };
        Object[][] rows = new Object[this.computers.length][6];
        for (int i = 0; i < this.computers.length; i++) {
            Computer computer = computers[i];
            if (computer == null) {
                break;
            }            
            rows[i][0] = i + 1;
            rows[i][1] = computer.getBrand();
            rows[i][2] = computer.getModel();
            rows[i][3] = computer.getDiskType();
            rows[i][4] = computer.getDiskSize();
            rows[i][5] = computer.getRamSize();            
        }        
        JTable table = new JTable(rows, cols);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));   
    }

    public void exit() {
        System.exit(0);
    }
    
    
}
