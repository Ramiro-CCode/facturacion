import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clientes {
    private JButton facturarButton;
    private JPanel vistaclientes;
    private JButton proveedoresButton;
    private JButton clientesButton;
    private JButton stockButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable clientestable;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JLabel errorlabel;
    private JFrame clientesframe;
    DefaultTableModel dtm=new DefaultTableModel();

    public void setVisible(boolean b) {
        clientesframe = new JFrame("Clientes");
        clientesframe.setContentPane(vistaclientes);
        clientesframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientesframe.pack();
        clientesframe.setVisible(b);
    }

    clientes(){
        facturarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                facturacion frame = new facturacion();
                frame.setVisible(true);
                clientesframe.dispose();
            }
        });
        proveedoresButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                proveedores frame = new proveedores();
                frame.setVisible(true);
                clientesframe.dispose();
            }
        });
        stockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stock frame = new stock();
                frame.setVisible(true);
                clientesframe.dispose();
            }
        });

        dtm.addColumn("nombre");
        dtm.addColumn("dni");
        dtm.addColumn("telefono");
        clientestable.setModel(dtm);
        dtm.addRow(new Object[]{"Nombre","DNI","Teléfono"});

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals("")||textField2.getText().equals("")||textField3.getText().equals("")){
                    errorlabel.setVisible(true);
                }else{
                    errorlabel.setVisible(false);
                    dtm.addRow(new Object[]{textField1.getText(),textField2.getText(),textField3.getText()});
                    clientestable.setModel(dtm);
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = clientestable.getSelectedRow();
                dtm.removeRow(fila);
            }
        });
    }
}
