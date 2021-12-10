/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Asset_View;
import View.Register_View;

/**
 *
 * @author HuyLQ
 */
public class Main {
    public static void main(String[] args) {
        Asset_View view = new Asset_View();
        Register_View regView = new Register_View();
        AssetController cl = new AssetController(view);
        LoginRegisController lgController = new LoginRegisController(regView);
        
    }
}
