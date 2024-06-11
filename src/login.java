import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    private JPanel vistalogin;
    private JButton ingresarButton;
    private JTextField usuarioField;
    private JPasswordField contraField;
    private JFrame loginframe;

    public void setVisible(boolean b) {
        loginframe = new JFrame("Ingresar");
        loginframe.setContentPane(vistalogin);
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.pack();
        loginframe.setVisible(b);
    }

    public login(){
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuarioField.getText().equals("123") && contraField.getText().equals("123")){
                    facturacion frame = new facturacion();
                    frame.setVisible(true);
                    loginframe.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Mal ahí");
                }
            }
        });
    }
}

