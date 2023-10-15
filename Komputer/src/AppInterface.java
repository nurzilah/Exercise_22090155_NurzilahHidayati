/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;

/**
 *
 * @author Owner
 */
public interface AppInterface {
    final int VIEW_ALL_COMPUTERS = 0;
    final int ADD_DATA_COMPUTER = 1;
    final int SEARCH_BY_MODEL = 3; 
    final int SEARCH_BY_BRAND = 2; 
    final int EXIT = 4;
    

    public int menuOption();
    public void add();
    public String keyword(String type);
    public Computer searchByBrand (String brand);
    public Computer searchByModel (String model);
    public void viewData (Computer computer);
    public void exit();
}