package views.mainmenuwindow;
import java.awt.event.*;

import daos.MahasiswaBIN;
import views.readwindow.ReadWindow;

public class ReadButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("READ DIPENCET");

        // validasi?

        MahasiswaBIN bin = new MahasiswaBIN();
        ReadWindow readWindow = new ReadWindow(bin.read());
        readWindow.setVisible(true);
    }
    
}
