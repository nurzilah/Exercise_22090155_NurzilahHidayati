/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author arfanxn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ComputerData computerData = new ComputerData();
             
        do {            
            int selectedMenu = computerData.menuOption();
            switch (selectedMenu) {
                case AppInterface.VIEW_ALL_COMPUTERS -> {
                    computerData.viewTable();
                    break;
                }
                case AppInterface.ADD_DATA_COMPUTER -> {
                    computerData.add();
                    computerData.viewTable();
                    break;
                }
                case AppInterface.SEARCH_BY_BRAND -> {
                    String key = computerData.keyword("brand");
                    Computer computer = computerData.searchByBrand(key);
                    computerData.viewData(computer);
                    break;
                }
                case AppInterface.SEARCH_BY_MODEL -> {
                    String key = computerData.keyword("model");
                    Computer computer = computerData.searchByModel(key);
                    computerData.viewData(computer);
                    break;
                }
                case AppInterface.EXIT -> {
                    computerData.exit();
                    break;
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Wrong choice!");
                    break;
                }
            }
        } while (true);
        
        
         
    }
    
}
