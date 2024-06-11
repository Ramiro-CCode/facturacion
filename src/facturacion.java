import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class facturacion {
    private JPanel vistafacturacion;
    private JButton facturarButton;
    private JButton proveedoresButton;
    private JButton clientesButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable facturaciontable;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton stockButton;
    private JTextField subtotalField;
    private JTextField totalField;
    private JTextField descField;
    private JTextField textField7;
    private JButton aplicarButton;
    private JButton facturarButton1;
    private JLabel errorlabel;
    private JFrame facturacionframe;
    DefaultTableModel  dtm=new DefaultTableModel();

    public void setVisible(boolean b) {
        facturacionframe = new JFrame("Facturación");
        facturacionframe.setContentPane(vistafacturacion);
        facturacionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        facturacionframe.pack();
        facturacionframe.setVisible(b);
    }



    facturacion(){
        clientesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientes frame = new clientes();
                frame.setVisible(true);
                facturacionframe.dispose();
            }
        });
        proveedoresButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                proveedores frame = new proveedores();
                frame.setVisible(true);
                facturacionframe.dispose();
            }
        });
        stockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stock frame = new stock();
                frame.setVisible(true);
                facturacionframe.dispose();
            }
        });

        dtm.addColumn("descripcion");
        dtm.addColumn("cantidad");
        dtm.addColumn("unitario");
        dtm.addColumn("total");
        dtm.addRow(new Object[]{"Descripcion","Cantidad","Unitario","Total"});
        facturaciontable.setModel(dtm);

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorlabel.setVisible(false);
                try {
                    double unitario = Double.parseDouble(String.valueOf(textField2.getText()));

                    double precio = Double.parseDouble(String.valueOf(textField3.getText()));
                    dtm.addRow(new Object[]{textField1.getText(), unitario, precio, unitario * precio});
                    facturaciontable.setModel(dtm);
                    sumarSubtotal();
                    sumarTotal();
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                }
                catch(NumberFormatException nfe){
                    errorlabel.setVisible(true);
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = facturaciontable.getSelectedRow();
                dtm.removeRow(fila);
                sumarSubtotal();
                sumarTotal();
            }
        });

        aplicarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                descField.setText(textField7.getText());
                sumarTotal();
            }
        });

        facturarButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bien ahí");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });
    }

    public void sumarSubtotal() {
        double subtotal = 0;
        for (int i = 1; i < facturaciontable.getRowCount(); i++) {
            double acum = Double.parseDouble(String.valueOf(facturaciontable.getValueAt(i, 3)));
            subtotal = acum + subtotal;
        }
        subtotalField.setText(String.valueOf(subtotal));
    }

    public void sumarTotal(){
        double desc = Double.parseDouble(descField.getText());
        double subtotal = Double.parseDouble(subtotalField.getText());
        double total = subtotal - ((subtotal * desc) / 100);
        totalField.setText(String.valueOf(total));
    }
}