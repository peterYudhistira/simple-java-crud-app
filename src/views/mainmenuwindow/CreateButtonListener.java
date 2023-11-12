package views.mainmenuwindow;
import java.awt.event.*;

import views.createwindow.CreateWindow;

public class CreateButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("CREATE DIPENCET");
        CreateWindow createWindow = new CreateWindow();
        createWindow.setVisible(true);
    }
    
}
