import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class proveedores {
    private JButton facturarButton;
    private JPanel vistaproveedores;
    private JButton proveedoresButton;
    private JButton clientesButton;
    private JButton stockButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JTable proveedoresTable;
    private JLabel errorlabel;
    private JFrame proveedoresFrame;
    DefaultTableModel dtm=new DefaultTableModel();

    public void setVisible(boolean b) {
        proveedoresFrame = new JFrame("Proveedores");
        proveedoresFrame.setContentPane(vistaproveedores);
        proveedoresFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        proveedoresFrame.pack();
        proveedoresFrame.setVisible(b);
    }

    proveedores(){
        facturarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                facturacion frame = new facturacion();
                frame.setVisible(true);
                proveedoresFrame.dispose();
            }
        });
        clientesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientes frame = new clientes();
                frame.setVisible(true);
                proveedoresFrame.dispose();
            }
        });
        stockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stock frame = new stock();
                frame.setVisible(true);
                proveedoresFrame.dispose();
            }
        });
        dtm.addColumn("nombre");
        dtm.addColumn("contacto");
        dtm.addColumn("descripcion");
        proveedoresTable.setModel(dtm);
        dtm.addRow(new Object[]{"Nombre","Contacto","Descripción"});

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals("")||textField2.getText().equals("")||textField3.getText().equals("")){
                    errorlabel.setVisible(true);
                }else{
                    errorlabel.setVisible(false);
                    dtm.addRow(new Object[]{textField1.getText(),textField2.getText(),textField3.getText()});
                    proveedoresTable.setModel(dtm);
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = proveedoresTable.getSelectedRow();
                dtm.removeRow(fila);
            }
        });

    }
}
